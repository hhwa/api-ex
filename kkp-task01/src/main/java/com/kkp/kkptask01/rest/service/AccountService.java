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
     * 페이징 처리된 계좌 리스트 반환 (REST API 전용)
     *
     * @param pageable
     * @return
     */
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    /**
     * 계좌 ID로 조회
     *
     * @param id
     * @return
     */
    public Account findAccountById(Long id) {
        Account account = accountRepository.findById(id).orElse(new Account());
        return account;
    }

    /**
     * 계좌 추가
     *
     * @param Account
     * @return
     */
    public Account save(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    /**
     * 계좌 삭제
     *
     * @param id
     */
    public void deleteById(Long id) {
    	accountRepository.deleteById(id);
    }
}
