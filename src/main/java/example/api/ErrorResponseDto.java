package example.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
@With
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponseDto {
    String referenceId;
    String description;
}
