package com.ll.sbkafka.domain.member.member.service;

import com.ll.sbkafka.domain.member.member.entity.Member;
import com.ll.sbkafka.domain.member.member.repository.MemberRepository;
import com.ll.sbkafka.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        return RsData.of(
                memberRepository.save(
                        Member.builder()
                                .username(username)
                                .password(password)
                                .nickname(nickname)
                                .build()
                )
        );
    }

    public long count() {
        return memberRepository.count();
    }

    @Transactional
    public void increasePostsCount(long id) {
        findById(id).ifPresent(member -> {
            member.increasePostsCount();
        });
    }

    private Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }
}
