package com.game.discover.controller;

import com.game.discover.ResponseEntity.ResponseEntity;
import com.game.discover.dto.UserListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketTextController {
    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send")
    public org.springframework.http.ResponseEntity<Object> sendMessage(@RequestBody UserListDto userListDto){
        template.convertAndSend("/topic/message",userListDto);
        return ResponseEntity.generateReponse("List updated and loaded.", HttpStatus.OK,userListDto);
    }


    @PostMapping("/sendMessage")
    public void receiveMessage(@Payload UserListDto userListDto){
          //receive msg from client
    }

    //all clients register to /topic/message will receive this return
    @SendTo("/users/list")
    public UserListDto broadcastMessage(@Payload UserListDto userListDto){
        return userListDto;
    }


}
