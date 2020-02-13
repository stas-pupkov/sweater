package ru.pupkov.stas.sweater.domain.repos;

import org.springframework.data.repository.CrudRepository;
import ru.pupkov.stas.sweater.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
