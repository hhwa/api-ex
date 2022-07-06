package com.kkp.kkptask01.rest.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kkp.kkptask01.rest.domain.Member;
import com.kkp.kkptask01.rest.inter.RemainAmoutInterface;
import com.kkp.kkptask01.rest.repository.MemberRepository;

import lombok.*;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	/**
     * @param pageable
     * @return
     */
    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    /**
     * @param id
     * @return
     */
    public Member findMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(new Member());
        return member;
    }
    
    /**
     * @param id
     * @return
     */
    public List<RemainAmoutInterface> findRemainAmountById(Long id){
    	List<RemainAmoutInterface> remain = memberRepository.findRemainAmountById(id);
    	return remain;
    }

    /**
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
     * @param id
     */
    public void deleteById(Long id) {
    	memberRepository.deleteById(id);
    }
	
}
