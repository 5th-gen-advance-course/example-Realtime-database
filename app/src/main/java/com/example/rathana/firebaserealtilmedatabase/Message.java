package com.example.rathana.firebaserealtilmedatabase;

/**
 * Created by RATHANA on 12/12/2017.
 */

public class Message {
    String id;
    String status;
    String message;
    String code;

    public Message(){}
    public Message(String id, String status, String message, String code) {
        this.id = id;
        this.status = status;
        this.message = message;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
