package example.db;

import example.api.MealDto;
import example.db.write.MealRepositoryWrite;
import example.mapper.MealMapper;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class MealService {
    private final MealRepositoryWrite repository;

    public MealService(MealRepositoryWrite repository) {
        this.repository = repository;
    }

    public MealDto find() {
        return MealMapper.INSTANCE.map(repository.findAll().iterator().next());
    }

    public MealDto findById(UUID id) {
        return MealMapper.INSTANCE.map(repository.findById(id).orElseThrow());
    }

    public MealDto create(MealDto request) {
        MealDto dto = request.withId(UUID.randomUUID())
                .withCreated(ZonedDateTime.now(ZoneId.of("UTC")));

        repository.save(MealMapper.INSTANCE.map(dto));
        return dto;
    }
}
