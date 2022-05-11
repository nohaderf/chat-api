package com.project2.chatapi.controller;

import com.project2.chatapi.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * Handles messages coming into the public chatroom
     * @param message
     * @return message
     */
    @MessageMapping("/message")  // /app/message
    @SendTo("/chatroom/public")
    public Message receivePublicMessage(@Payload Message message) {
        return message;
    }

    /**
     * Handles messages being sent to a private chat
     * Receives the message from a user and sends to another user
     * @param message
     * @return message
     */
    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); // listens to /user/name/private
        return message;
    }
}
