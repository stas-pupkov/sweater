package ru.pupkov.stas.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pupkov.stas.rest.domain.Message;
import ru.pupkov.stas.rest.repository.MessageRepo;

import javax.xml.ws.ServiceMode;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public boolean addMessage(Message message) {
        messageRepo.save(message);
        return true;
    }



}
