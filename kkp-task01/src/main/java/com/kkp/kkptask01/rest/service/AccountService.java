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
     * ����¡ ó���� ���� ����Ʈ ��ȯ (REST API ����)
     *
     * @param pageable
     * @return
     */
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    /**
     * ���� ID�� ��ȸ
     *
     * @param id
     * @return
     */
    public Account findAccountById(Long id) {
        Account account = accountRepository.findById(id).orElse(new Account());
        return account;
    }

    /**
     * ���� �߰�
     *
     * @param Account
     * @return
     */
    public Account save(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    /**
     * ���� ����
     *
     * @param id
     */
    public void deleteById(Long id) {
    	accountRepository.deleteById(id);
    }
}
