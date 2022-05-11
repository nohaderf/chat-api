package com.project2.chatapi.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Message {

    private String senderName;
    private String receiverName;
    private String message;
    private String dateTime;
    private Status status;
}
