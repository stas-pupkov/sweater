package ru.pupkov.stas.sweater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.pupkov.stas.sweater.domain.Message;

import java.util.List;

public interface MessagesRepository extends CrudRepository<Message, Long> {
    List<Message> findById(String id);
}
