package com.ll.sbkafka.domain.noti.noti.entity;

import com.ll.sbkafka.domain.member.member.entity.Member;
import com.ll.sbkafka.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Noti extends BaseEntity {
    @ManyToOne
    private Member actor;
    @ManyToOne
    private Member receiver;
    private String relTypeCode;
    private long relId;
    private String typeCode;
    private String type2Code;
    private boolean read;
}
