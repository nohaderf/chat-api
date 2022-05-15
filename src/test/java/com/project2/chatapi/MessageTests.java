package com.project2.chatapi;

import com.project2.chatapi.models.Message;
import com.project2.chatapi.models.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTests {

    Message message = Message.builder()
            .senderName("Doctor")
            .receiverName("Patient")
            .message("How are you doing today?")
            .dateTime("2022-05-14 @ 12:55")
            .status(Status.valueOf("MESSAGE"))
            .build();

    @Test
    void shouldGetSenderName() {
        assertEquals("Doctor", message.getSenderName());
    }

    @Test
    void shouldGgetReceiverName() {
        assertEquals("Patient", message.getReceiverName());
    }

    @Test
    void shouldGetMessage() {
        assertEquals("How are you doing today?", message.getMessage());
    }

    @Test
    void shouldGetDateTime() {
        assertEquals("2022-05-14 @ 12:55", message.getDateTime());
    }

    @Test
    void shouldSetSenderName() {
        message.setSenderName("Dr. Smith");
        assertEquals("Dr. Smith", message.getSenderName());
    }

    @Test
    void shouldSetReceiverName() {
        message.setReceiverName("Jane Doe");
        assertEquals("Jane Doe", message.getReceiverName());
    }

    @Test
    void shouldSetMessage() {
        message.setMessage("How can I help you today?");
        assertEquals("How can I help you today?", message.getMessage());
    }

    @Test
    void shouldSetDateTime() {
        message.setDateTime("2022-12-14, @ 4:55PM");
        assertEquals("2022-12-14, @ 4:55PM", message.getDateTime());
    }

    @Test
    void setStatus() {
    }

    @Test
    void testToString() {
        assertEquals("Message(senderName=Doctor, receiverName=Patient, message=How are you doing today?, dateTime=2022-05-14 @ 12:55, status=MESSAGE)", message.toString());
    }

    @Test
    void testEquals() {
        assertEquals(false, message.equals("2022-12-14, @ 4:55PM"));
    }

}