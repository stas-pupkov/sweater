package ru.pupkov.stas.rest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pupkov.stas.rest.domain.Message;

import java.util.List;


public interface MessageRepo extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);
    List<Message> findById(int id);

}
