package jpa.jpa_study.stomp.config;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;

@Component
public class StompHandler extends ChannelInterceptorAdapter {
    @Override
    public void postSend(Message message, MessageChannel channel, boolean sent) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        String sessionId = accessor.getSessionId();
        switch (accessor.getCommand()) {
            case CONNECT:
                // 유저가 Websocket으로 connect()를 한 뒤 호출됨
                System.out.println(1);
                System.out.println(sessionId);
                System.out.println("msg"+message);
                System.out.println("channel = "+channel);
                break;
            case DISCONNECT:
                // 유저가 Websocket으로 disconnect() 를 한 뒤 호출됨 or 세션이 끊어졌을 때 발생함(페이지 이동~ 브라우저 닫기 등)
                System.out.println(2);
                System.out.println(sessionId);
                System.out.println("msg"+message);
                System.out.println("channel = "+channel);
                break;
            default:
                break;
        }

    }
}