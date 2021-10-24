package example.mapper;

import example.api.MealDto;
import example.db.model.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MealMapper {
    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

    MealDto map(Meal meal);
    Meal map(MealDto meal);
}
