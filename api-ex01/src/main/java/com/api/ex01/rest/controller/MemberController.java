package com.api.ex01.rest.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.api.ex01.rest.domain.Member;
import com.api.ex01.rest.inter.RemainAmoutInterface;
import com.api.ex01.rest.service.MemberService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

	private final MemberService memberService;
	
	@ApiOperation(value="List of member")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMembers(@PageableDefault Pageable pageable) {
        Page<Member> members = memberService.findAll(pageable);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

	@ApiOperation(value="MemberInfo By Id")
	@GetMapping("/{id}")
    public ResponseEntity<?> getMembersById(@PathVariable("id") Long id) {
    	Member persistMember = memberService.findMemberById(id);
        return new ResponseEntity<>(persistMember, HttpStatus.OK);
    }

	@ApiOperation(value="balance by user's account")
	@GetMapping("/remain/{id}")
    public ResponseEntity<?> getAccountBalance(@PathVariable("id") Long id) {
        List<RemainAmoutInterface> accountBalance = memberService.findRemainAmountById(id);
        return new ResponseEntity<>(accountBalance, HttpStatus.OK);
    }

	@ApiOperation(value="Add Member")
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
