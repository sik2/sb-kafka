package com.ll.sbkafka.domain.noti.noti.service;

import com.ll.sbkafka.domain.noti.noti.repository.NotiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotiService {
    private final NotiRepository notiRepository;
}
