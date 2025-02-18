package com.ll.sbkafka.domain.post.post.entity;

import com.ll.sbkafka.domain.member.member.entity.Member;
import com.ll.sbkafka.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Post extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne
    private Member author;
}
