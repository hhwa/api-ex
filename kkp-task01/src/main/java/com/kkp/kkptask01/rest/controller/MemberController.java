package com.kkp.kkptask01.rest.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.kkp.kkptask01.rest.domain.Member;
import com.kkp.kkptask01.rest.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMembers(@PageableDefault Pageable pageable) {
        Page<Member> members = memberService.findAll(pageable);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getMembersById(@PathVariable("id") Long id) {
    	Member persistMember = memberService.findMemberById(id);
        return new ResponseEntity<>(persistMember, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postMember(@RequestBody Member member) {
        Member savedMember = memberService.save(member);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<?> putMember(@PathVariable("id") Long id, @RequestBody Member member) {
        Member persistMember = memberService.findMemberById(id);
        persistMember.update(member);
        Member savedMember = memberService.save(persistMember);
        return new ResponseEntity<>(savedMember, HttpStatus.OK);
    }
    */

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    */

}
