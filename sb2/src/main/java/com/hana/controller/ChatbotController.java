package com.hana.controller;

import com.hana.app.data.msg.Msg;
import com.hana.util.ChatBotUtil;
import com.hana.util.KoGPTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatbotController {

    final SimpMessagingTemplate template;
//    @Value("${app.key.chatbot_key}")
    @Value("${app.key.kakao_rest_key}")
    private String secretKey;
    @Value("${app.key.chatbot_url}")
    private String apiUrl;

    @MessageMapping("/sendchatbot") // 나에게만 전송 ex)Chatbot
    public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        log.info(msg.toString());

        String id = msg.getSendid();
        template.convertAndSend("/send/me/"+id,msg);

//        String result = ChatBotUtil.getMsg(apiUrl,secretKey,msg.getContent1());
        String result = KoGPTUtil.getMsg(secretKey, msg.getContent1());
        msg.setContent1(result);
        msg.setSendid("KoBot");
        template.convertAndSend("/send/me/"+id,msg);

    }

}
