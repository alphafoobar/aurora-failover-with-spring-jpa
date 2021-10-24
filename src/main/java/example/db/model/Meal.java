package example.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "dinnertime.meal")
public class Meal {

    @Id
    @Column
    private UUID id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private ZonedDateTime created;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id) &&
                Objects.equals(title, meal.title) &&
                Objects.equals(description, meal.description) &&
                Objects.equals(created, meal.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, created);
    }
}
