package com.kkp.kkptask01.rest.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kkp.kkptask01.rest.domain.AccountDetails;
import com.kkp.kkptask01.rest.domain.AccountDetailsPK;
import com.kkp.kkptask01.rest.repository.AccountDetailsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountDetailsService {
	
private final AccountDetailsRepository accountDetailsRepository;
	
	/**
     * @param pageable
     * @return
     */
    public Page<AccountDetails> findAll(Pageable pageable) {
        return accountDetailsRepository.findAll(pageable);
    }

    /**
     * @param id
     * @return
     */
    public AccountDetails findAccountDetailsById(Long id) {
        AccountDetails accountDetails = accountDetailsRepository.findById(id).orElse(new AccountDetails());
        return accountDetails;
    }

    /**
     * @param AccountDetails
     * @return
     */
    public AccountDetails save(AccountDetails accountDetails) {
		
    	LocalDate now = LocalDate.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
    	String formatedNow = now.format(formatter);
    	
    	AccountDetailsPK accountDetailsPK = new AccountDetailsPK();
    	accountDetailsPK.setDeposit_date(formatedNow);
    	accountDetails.setAccountDetails(accountDetailsPK);
        AccountDetails savedAccountDetails = accountDetailsRepository.save(accountDetails);
        return savedAccountDetails;
    }

    /**
     * @param id
     */
    public void deleteById(Long id) {
    	accountDetailsRepository.deleteById(id);
    }

}
