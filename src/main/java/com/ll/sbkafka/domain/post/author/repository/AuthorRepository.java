package com.ll.sbkafka.domain.post.author.repository;

import com.ll.sbkafka.domain.post.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
