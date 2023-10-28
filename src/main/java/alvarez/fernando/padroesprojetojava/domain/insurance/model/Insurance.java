package alvarez.fernando.padroesprojetojava.domain.insurance.model;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.Person;

import java.time.LocalDateTime;
import java.util.UUID;

public record Insurance(
        UUID uuid,
        LocalDateTime createdAt,
        Person person
) {

    public Insurance(Person person) {
        this(UUID.randomUUID(), LocalDateTime.now(), person);
    }

}
