package com.hana.controller;

import com.hana.app.data.msg.Msg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatbotController {

    final SimpMessagingTemplate template;


    @MessageMapping("/sendchatbot") // 나에게만 전송 ex)Chatbot
    public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        log.info(msg.toString());

        String id = msg.getSendid();
        template.convertAndSend("/send/me/"+id,msg);
    }

}
