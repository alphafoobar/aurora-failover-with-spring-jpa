package example.mapper;

import example.api.MealDto;
import example.db.model.Meal;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class MealMapperTest {

    public static final MealDto DTO = MealDto.builder()
            .id(UUID.randomUUID())
            .title("test title")
            .description("test description")
            .created(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"))
            .build();

    @Test
    void map() {
        final Meal entity = MealMapper.INSTANCE.map(DTO);

        assertThat(entity.getId()).isEqualTo(DTO.getId());
        assertThat(entity.getTitle()).isEqualTo(DTO.getTitle());
        assertThat(entity.getDescription()).isEqualTo(DTO.getDescription());
        assertThat(entity.getCreated()).isEqualTo(DTO.getCreated());
    }

    @Test
    void andBack() {
        final Meal entity = MealMapper.INSTANCE.map(DTO);

        final MealDto dto = MealMapper.INSTANCE.map(entity);
        assertThat(dto).isEqualTo(DTO);
    }
}
