package com.ll.sbkafka.domain.post.post.service;

import com.ll.sbkafka.domain.member.member.entity.Member;
import com.ll.sbkafka.domain.post.post.entity.Author;
import com.ll.sbkafka.domain.post.post.entity.Post;
import com.ll.sbkafka.domain.post.post.repository.PostRepository;
import com.ll.sbkafka.global.rsData.RsData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public RsData<Post> write(Author author, String title, String content) {
        author.increasePostsCount();

        Post post = postRepository.save(
                Post.builder()
                        .author(author)
                        .title(title)
                        .content(content)
                        .build()
        );

        // 알림
        firePostCreatedEvent(post);

        return RsData.of(post);
    }

    public Author of(Member member) {
        return entityManager.getReference(Author.class, member.getId());
    }

    private void firePostCreatedEvent(Post post) {
        System.out.println("게시글 생성 알림");
    }
}
