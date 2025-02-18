package com.ll.sbkafka.domain.post.post.entity;

import com.ll.sbkafka.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "MEMBER")
public class Author extends BaseEntity {
    @Column(name="nickname")
    private String writer;
}
