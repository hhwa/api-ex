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
     * 페이징 처리된 회원 리스트 반환 (REST API 전용)
     *
     * @param pageable
     * @return
     */
    public Page<AccountDetails> findAll(Pageable pageable) {
        return accountDetailsRepository.findAll(pageable);
    }

    /**
     * 회원 ID로 조회
     *
     * @param id
     * @return
     */
    public AccountDetails findAccountDetailsById(Long id) {
        AccountDetails accountDetails = accountDetailsRepository.findById(id).orElse(new AccountDetails());
        return accountDetails;
    }

    /**
     * 회원 추가
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
     * 회원 삭제
     *
     * @param id
     */
    public void deleteById(Long id) {
    	accountDetailsRepository.deleteById(id);
    }

}
