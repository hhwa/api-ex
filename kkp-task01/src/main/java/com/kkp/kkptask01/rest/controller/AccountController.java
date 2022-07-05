package com.kkp.kkptask01.rest.controller;

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

import com.kkp.kkptask01.rest.domain.Account;
import com.kkp.kkptask01.rest.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
private final AccountService accountService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccounts(@PageableDefault Pageable pageable) {
        Page<Account> accounts = accountService.findAll(pageable);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
	
	@GetMapping("/{account_no}")
    public ResponseEntity<?> getAccountsById(@PathVariable("account_no") String account_no) {
		Account persistAccount = accountService.findAccountById(account_no);
        return new ResponseEntity<>(persistAccount, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postAccount(@RequestBody Account account) {
        Account savedAccount = accountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<?> putAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        Account persistAccount = accountService.findAccountById(id);
        persistAccount.update(account);
        Account savedAccount = accountService.save(persistAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }
    */

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    */

}
