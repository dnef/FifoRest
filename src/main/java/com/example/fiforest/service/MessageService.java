package com.example.fiforest.service;

import com.example.fiforest.entity.Message;
import com.example.fiforest.repository.ImessegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    ImessegeRepository messegeRepository;

    public List<Message> showAllMessage() {
        List<Message> listMessages = new LinkedList<>();
        this.messegeRepository.findAllByOrderByIdAsc().forEach(listMessages::add);
        listMessages.forEach(System.out::println);
        return listMessages;
    }

    public Message showPoll(){
        Integer idMessage = messegeRepository.showFirstId();
        Message message = messegeRepository.findById(idMessage).get();
        this.messegeRepository.deleteById(idMessage);
        return message;
    }

    public Message showPeek(){
        Integer idMessage = messegeRepository.showFirstId();
        Message message = messegeRepository.findById(idMessage).get();
        return message;
    }

    public Message showPeekMax(){
        Integer idMessage = messegeRepository.showMax();
        Message message = messegeRepository.findById(idMessage).get();
        return message;
    }

    public void offer(Message message){
        //message.setId();
        messegeRepository.save(message);
    }
}
