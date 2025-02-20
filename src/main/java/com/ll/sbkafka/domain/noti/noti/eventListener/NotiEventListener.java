package com.ll.sbkafka.domain.noti.noti.eventListener;

import com.ll.sbkafka.domain.noti.noti.service.NotiService;
import com.ll.sbkafka.global.dto.chat.ChatMessageDto;
import com.ll.sbkafka.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class NotiEventListener {
    private final NotiService notiService;

    @EventListener
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async
    public void listenPost(PostCreatedEvent event) {
        notiService.postCreated(event.getPost());
    }

    @KafkaListener(topics="chat-room-1", groupId = "1")
    public void consume(ChatMessageDto message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics="chat-room-1-dlt", groupId = "1")
    public void consumeChatRoom1DLT(byte[] in) {
        String message = new String(in);
        System.out.println("Failed message: " + message);
    }
}
