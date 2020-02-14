package ru.pupkov.stas.rest.domain.repos;

import org.springframework.data.repository.CrudRepository;
import ru.pupkov.stas.rest.domain.Message;

import java.util.List;
import java.util.Optional;


public interface MessageRepo extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);
    List<Message> findById(int id);

}
