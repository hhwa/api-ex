package com.api.ex01.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ex01.rest.domain.Account;
import com.api.ex01.rest.service.AccountService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
private final AccountService accountService;
	
	@ApiOperation(value="List of account")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccounts(@PageableDefault Pageable pageable) {
        Page<Account> accounts = accountService.findAll(pageable);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

	@ApiOperation(value="add account")
    @PostMapping
    public ResponseEntity<?> postAccount(@RequestBody Account account) {
        Account savedAccount = accountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

}
