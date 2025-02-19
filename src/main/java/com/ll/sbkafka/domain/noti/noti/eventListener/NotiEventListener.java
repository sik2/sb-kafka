package com.ll.sbkafka.domain.noti.noti.eventListener;

import com.ll.sbkafka.domain.noti.noti.service.NotiService;
import com.ll.sbkafka.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class NotiEventListener {
    private final NotiService notiService;

    @EventListener
    public void listenPost(PostCreatedEvent event) {
        notiService.postCreated(event.getPost());
    }
}
