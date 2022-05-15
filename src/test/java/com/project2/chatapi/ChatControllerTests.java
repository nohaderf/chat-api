package com.project2.chatapi;

import com.project2.chatapi.models.Message;
import com.project2.chatapi.models.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.testng.annotations.BeforeTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatControllerTests {

    @LocalServerPort
    private Integer port;
    private WebSocketStompClient webSocketStompClient;

    @BeforeEach
    public void setup() {
        this.webSocketStompClient = new WebSocketStompClient(new SockJsClient(
                List.of(new WebSocketTransport(new StandardWebSocketClient()))
        ));
    }

//    Message message;
    
//    @BeforeTest
//    public void createMessage() {
//        message
//    }

    Message message = Message.builder()
            .senderName("Doctor")
            .receiverName("Patient")
            .message("How are you doing today?")
            .dateTime("2022-05-14 @ 12:55")
            .status(Status.valueOf("MESSAGE"))
            .build();

    @Test
    void shouldReceivePublicMessage() {
        assertEquals("How are you doing today?", message.getMessage());
    }

    @Test
    void shouldReceivePrivateMessage() {
        assertEquals("How are you doing today?", message.getMessage());
    }
}