package example.db;

import example.api.MealDto;
import example.db.read.MealRepositoryRead;
import example.db.write.MealRepositoryWrite;
import example.mapper.MealMapper;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class MealService {
    private final MealRepositoryRead reader;
    private final MealRepositoryWrite writer;

    public MealService(MealRepositoryRead reader, MealRepositoryWrite writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public MealDto find() {
        return MealMapper.INSTANCE.map(reader.findAll().iterator().next());
    }

    public MealDto findById(UUID id) {
        return MealMapper.INSTANCE.map(reader.findById(id).orElseThrow());
    }

    public MealDto create(MealDto request) {
        MealDto dto = request.withId(UUID.randomUUID())
                .withCreated(ZonedDateTime.now(ZoneId.of("UTC")));

        writer.save(MealMapper.INSTANCE.map(dto));
        return dto;
    }
}
