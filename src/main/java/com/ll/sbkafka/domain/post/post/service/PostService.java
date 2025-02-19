package com.ll.sbkafka.domain.post.post.service;

import com.ll.sbkafka.domain.member.member.entity.Member;
import com.ll.sbkafka.domain.post.post.entity.Author;
import com.ll.sbkafka.domain.post.post.entity.Post;
import com.ll.sbkafka.domain.post.post.repository.PostRepository;
import com.ll.sbkafka.global.event.PostCreatedEvent;
import com.ll.sbkafka.global.rsData.RsData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationEventPublisher eventPublisher;

    public RsData<Post> write(Author author, String title, String content) {
        author.increasePostsCount();

        Post post = postRepository.save(
                Post.builder()
                        .author(author)
                        .title(title)
                        .content(content)
                        .build()
        );

        eventPublisher.publishEvent(new PostCreatedEvent(this, post));

        return RsData.of(post);
    }

    public Author of(Member member) {
        return entityManager.getReference(Author.class, member.getId());
    }

    public Member of(Author author) {
        return entityManager.getReference(Member.class, author.getId());
    }
}
