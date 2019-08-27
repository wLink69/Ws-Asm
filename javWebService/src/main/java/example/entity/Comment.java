package example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Calendar;

@Entity
public class Comment {
    @Id
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Place place;

    private String content;

    private long createdAt;

    private long updatedAt;

    public Comment() {
        this.id = Calendar.getInstance().getTimeInMillis();
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
