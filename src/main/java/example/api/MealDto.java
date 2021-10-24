package example.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Value
@With
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
public class MealDto {
    UUID id;
    String title;
    String description;
    ZonedDateTime created;
}
