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

import com.kkp.kkptask01.rest.domain.AccountDetails;
import com.kkp.kkptask01.rest.domain.AccountDetailsPK;
import com.kkp.kkptask01.rest.service.AccountDetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accountdetails")
public class AccountDetailController {
	
	private final AccountDetailsService accountDetailsService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccountDetailss(@PageableDefault Pageable pageable) {
        Page<AccountDetails> accountDetailss = accountDetailsService.findAll(pageable);
        return new ResponseEntity<>(accountDetailss, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postAccountDetails(@RequestBody AccountDetails accountDetails) {
    	System.out.println("controll :"+accountDetails.getAccountDetails().getAccount_no());
    	AccountDetails savedAccountDetails = accountDetailsService.save(accountDetails);
        return new ResponseEntity<>(savedAccountDetails, HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<?> putAccountDetails(@PathVariable("id") Long id, @RequestBody AccountDetails accountDetails) {
        AccountDetails persistAccountDetails = accountDetailsService.findAccountDetailsById(id);
        persistAccountDetails.update(accountDetails);
        AccountDetails savedAccountDetails = accountDetailsService.save(persistAccountDetails);
        return new ResponseEntity<>(savedAccountDetails, HttpStatus.OK);
    }
    */

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountDetails(@PathVariable("id") Long id) {
        accountDetailsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    */

}
