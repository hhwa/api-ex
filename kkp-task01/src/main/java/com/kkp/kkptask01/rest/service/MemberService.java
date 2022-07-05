package com.kkp.kkptask01.rest.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kkp.kkptask01.rest.domain.Member;
import com.kkp.kkptask01.rest.repository.MemberRepository;

import lombok.*;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	/**
     * 페이징 처리된 회원 리스트 반환 (REST API 전용)
     *
     * @param pageable
     * @return
     */
    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    /**
     * 회원 ID로 조회
     *
     * @param id
     * @return
     */
    public Member findMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(new Member());
        return member;
    }

    /**
     * 회원 추가
     *
     * @param Member
     * @return
     */
    public Member save(Member member) {
		
    	LocalDate now = LocalDate.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
    	String formatedNow = now.format(formatter);
    	
    	member.setJoin_date(formatedNow);
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    /**
     * 회원 삭제
     *
     * @param id
     */
    public void deleteById(Long id) {
    	memberRepository.deleteById(id);
    }
	
}
