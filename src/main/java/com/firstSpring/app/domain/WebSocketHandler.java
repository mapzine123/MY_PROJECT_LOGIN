package com.firstSpring.app.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();

    // Websocket 연결 성공시 작동
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        System.out.println("하나의 클라이언트가 연결됨");
    }

    // Websocket 연결 종료시 작동
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("클라이언트와 연결 해제됨");
        list.remove(session);
    }

    // websocket 메세지 수신 및 송신
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();

        for (WebSocketSession s : list) {
            s.sendMessage(new TextMessage(session.getAcceptedProtocol() + " : " + msg));
        }
    }
}
