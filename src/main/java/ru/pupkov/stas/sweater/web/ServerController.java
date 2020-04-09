package ru.pupkov.stas.sweater.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pupkov.stas.sweater.domain.Message;
import ru.pupkov.stas.sweater.domain.MessageFromCourier;
import ru.pupkov.stas.sweater.repository.MessagesRepository;

import java.util.Map;

@Controller
public class ServerController {

    @Autowired
    MessagesRepository messagesRepository;

    @PostMapping("/delay")
    public String wait(@RequestParam String text, Map<String, Object> model) {
        MessageFromCourier messageFromCourier = new MessageFromCourier(text);
        //messagesRepository.save(messageFromCourier);

        Iterable<Message> messages = messagesRepository.findAll();
        model.put("messages", messages);
        return "main";
    }



}
