package com.ll.sbkafka.domain.noti.noti.repository;

import com.ll.sbkafka.domain.noti.noti.entity.Noti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotiRepository extends JpaRepository<Noti, Long> {

}
