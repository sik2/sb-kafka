package com.ll.sbkafka.domain.member.member.entity;

import com.ll.sbkafka.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Member extends BaseEntity {
    private String username;
    private String password;
    private String nickname;
}
