package example.service;

import example.entity.Comment;
import example.entity.Place;
import example.entity.User;
import example.ulti.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService()
public class MyService {
    private static final Logger LOGGER = Logger.getLogger(MyService.class.getSimpleName());

    @WebMethod
    public User createUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            user.setRole("user");
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Can't create user: ", ex);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @WebMethod
    public User getUserByName(String username) {
        try (Session session = HibernateUtil.getSession()) {
            Query<User> userQuery = session.createQuery("FROM User u WHERE u.username=:username", User.class);
            userQuery.setParameter("username", username);
            User user = userQuery.getSingleResult();
            return user;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Not found user: ", ex);
        }
        return null;
    }

    @WebMethod
    public List<Place> getAllPlace() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Place> placeQuery = session.createQuery("FROM Place p", Place.class);
            List<Place> placeList = placeQuery.getResultList();
            return placeList;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Not found places: ", ex);
        }
        return null;
    }

    @WebMethod
    public String createPlace(Place place) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(place);
            transaction.commit();
            return "ok";
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Can't create place: ", ex);
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @WebMethod
    public Place getPlaceById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Place> placeQuery = session.createQuery("FROM Place p WHERE p.id=:id", Place.class);
            placeQuery.setParameter("id", id);
            Place place = placeQuery.getSingleResult();
            return place;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Not found place: ", ex);
        }
        return null;
    }

    @WebMethod
    public String updatePlace(Place place) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction txn = session.beginTransaction();

            Query placeQuery = session.createQuery(
        "update Place set name=:name, district=:district, image=:image, information=:info where id=:id");
            placeQuery.setParameter("id", place.getId());
            placeQuery.setParameter("name", place.getName());
            placeQuery.setParameter("district", place.getDistrict());
            placeQuery.setParameter("image", place.getImage());
            placeQuery.setParameter("info", place.getInformation());

            placeQuery.executeUpdate();
            txn.commit();
            return "ok";
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Not found place: ", ex);
            return null;
        }
    }

    @WebMethod
    public String deletePlace(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction txn = session.beginTransaction();
            Query placeQuery = session.createQuery("delete Place where id=:id");
            placeQuery.setParameter("id", id);
            placeQuery.executeUpdate();
            txn.commit();
            return "ok";
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Not found place: ", ex);
            return null;
        }
    }

    @WebMethod
    public Comment createComment(Comment comment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            comment.setCreatedAt(Calendar.getInstance().getTimeInMillis());
            comment.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
            session.save(comment);
            transaction.commit();
            return comment;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Can't create comment: ", ex);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @WebMethod
    public List<Comment> getAllCommentByPlaceId(int placeId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Comment> commentQuery = session.createQuery("SELECT c FROM Comment c WHERE c.place.id=:place_id", Comment.class);
            commentQuery.setParameter("place_id", placeId);
            List<Comment> comments = commentQuery.getResultList();
            return comments;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Not found comments: ", ex);
        }
        return null;
    }
}
