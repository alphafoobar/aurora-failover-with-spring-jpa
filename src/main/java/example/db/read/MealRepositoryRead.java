package example.db.read;

import example.db.model.Meal;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MealRepositoryRead extends CrudRepository<Meal, UUID> {
}
