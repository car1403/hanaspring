package com.hana.controller;

import com.hana.app.data.msg.Msg;
import com.hana.util.NcpUtil;
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
public class ChatController {

    final SimpMessagingTemplate template;
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;
    @MessageMapping("/sendchat") // 특정 Id에게 전송
    public void sendchat(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        String id = msg.getSendid();
        String target = msg.getReceiveid();
        log.info("-------------------------");
        log.info(msg.toString());
        template.convertAndSend("/send3/to/"+id,msg);

        String sentiment =
                NcpUtil.getSentimentDetail(
                        NcpUtil.getSentiment(ncpId, ncpSecret, msg.getContent1())
                );
        msg.setContent1(msg.getContent1()+":"+sentiment);
        template.convertAndSend("/send3/to/"+target,msg);

    }
}
