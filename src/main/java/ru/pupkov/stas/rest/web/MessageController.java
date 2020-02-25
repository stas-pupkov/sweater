package ru.pupkov.stas.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pupkov.stas.rest.domain.Message;
import ru.pupkov.stas.rest.repository.MessageRepo;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("")
    public Iterable<Message> getMessages() {
        return messageRepo.findAll();
    }

    @GetMapping(path = "/{id}")
    public Iterable<Message> getMessage(@PathVariable("id") int id) {
        return messageRepo.findById(id);
    }

    @PostMapping("/add")
    public Iterable<Message> addMessage(@RequestBody Message message) {
        messageRepo.save(message);
        return messageRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public Iterable<Message> deleteMessage(@PathVariable("id") int id) {
        messageRepo.deleteById(id);
        return messageRepo.findAll();
    }

    @PutMapping("/{id}")
    public Iterable<Message> updateMessage(@PathVariable("id") int id,
                                           @RequestBody Message message) {
        Message messageFromDb = messageRepo.findById(id).get(0);
        messageFromDb.setText(message.getText());
        messageFromDb.setTag(message.getTag());
        messageRepo.save(messageFromDb);
        return messageRepo.findAll();
    }

}
