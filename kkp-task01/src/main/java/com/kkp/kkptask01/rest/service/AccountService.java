package com.kkp.kkptask01.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kkp.kkptask01.rest.domain.Account;
import com.kkp.kkptask01.rest.repository.AccountRepository;

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

    /**
     * @param id
     */
    public void deleteById(String account_no) {
    	accountRepository.deleteById(account_no);
    }
}