package example.db.write;

import example.db.model.Meal;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MealRepositoryWrite extends CrudRepository<Meal, UUID> {
}
