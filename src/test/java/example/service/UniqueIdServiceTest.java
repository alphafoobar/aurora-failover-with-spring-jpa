package example.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueIdServiceTest {

    private final UniqueIdService service = new UniqueIdService();

    @Test
    void createId() {
        final String actual = service.createId(7);
        assertThat(actual)
                .isNotBlank()
                .hasSize(7)
                .isNotEqualTo(service.createId(7));
    }
}
