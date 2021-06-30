package com.example.fiforest.controller;

import com.example.fiforest.entity.Message;
import com.example.fiforest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    //ObjectMapper objectMapper = new ObjectMapper();
    Message message = new Message();

    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> all() {
        return messageService.showAllMessage();
    }

    @ResponseBody
    @RequestMapping(value = "/poll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Message poll(){
    return messageService.showPoll();
    }

    @ResponseBody
    @RequestMapping(value = "/peek",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Message peek(){
        return messageService.showPeek();
    }

    @ResponseBody
    @RequestMapping(value = "/peekMax",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Message peekMax(){
        return messageService.showPeekMax();
    }

    @ResponseBody
    @RequestMapping(value = "/offer",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> offer(@RequestBody Message message){
        messageService.offer(message);
        return ResponseEntity.ok("Add message succes");
    }

}
