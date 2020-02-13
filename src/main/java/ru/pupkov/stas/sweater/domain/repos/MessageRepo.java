package ru.pupkov.stas.sweater.domain.repos;

import org.springframework.data.repository.CrudRepository;
import ru.pupkov.stas.sweater.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

}
