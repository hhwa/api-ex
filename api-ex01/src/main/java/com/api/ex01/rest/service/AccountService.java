package com.api.ex01.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.ex01.rest.domain.Account;
import com.api.ex01.rest.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	
	/**
     * @param pageable
     * @return
     */
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    /**
     * @param id
     * @return
     */
    public Account findAccountById(String account_no) {
    	Account account = accountRepository.findById(account_no).orElse(new Account());
        return account;
    }

    /**
     * @param Account
     * @return
     */
    public Account save(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }
}
