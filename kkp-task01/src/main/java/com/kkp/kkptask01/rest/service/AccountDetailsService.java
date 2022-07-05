package com.kkp.kkptask01.rest.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kkp.kkptask01.rest.domain.AccountDetails;
import com.kkp.kkptask01.rest.repository.AccountDetailsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountDetailsService {
	
private final AccountDetailsRepository accountDetailsRepository;
	
	/**
     * ����¡ ó���� ȸ�� ����Ʈ ��ȯ (REST API ����)
     *
     * @param pageable
     * @return
     */
    public Page<AccountDetails> findAll(Pageable pageable) {
        return accountDetailsRepository.findAll(pageable);
    }

    /**
     * ȸ�� ID�� ��ȸ
     *
     * @param id
     * @return
     */
    public AccountDetails findAccountDetailsById(Long id) {
        AccountDetails accountDetails = accountDetailsRepository.findById(id).orElse(new AccountDetails());
        return accountDetails;
    }

    /**
     * ȸ�� �߰�
     *
     * @param AccountDetails
     * @return
     */
    public AccountDetails save(AccountDetails accountDetails) {
		
    	LocalDate now = LocalDate.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
    	String formatedNow = now.format(formatter);
    	
    	accountDetails.setDeposit_date(formatedNow);
        AccountDetails savedAccountDetails = accountDetailsRepository.save(accountDetails);
        return savedAccountDetails;
    }

    /**
     * ȸ�� ����
     *
     * @param id
     */
    public void deleteById(Long id) {
    	accountDetailsRepository.deleteById(id);
    }

}
