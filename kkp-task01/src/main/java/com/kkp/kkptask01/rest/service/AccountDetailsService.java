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
    public AccountDetails findAccountDetailsById(AccountDetailsPK accountDetailsPK) {
        AccountDetails accountDetails = accountDetailsRepository.findById(accountDetailsPK).orElse(new AccountDetails());
        return accountDetails;
    }

    /**
     * @param AccountDetails
     * @return
     */
    public AccountDetails save(AccountDetailsPK accountDetailsPK) {
		
    	LocalDate now = LocalDate.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
    	String formatedNow = now.format(formatter);
    	
    	AccountDetails accountDetails = new AccountDetails();
    	accountDetails.setDeposit_date(formatedNow);
    	accountDetails.setAccountDetails(accountDetailsPK);
//    	System.out.println("ac_NO1:"+accountDetails.getAccount_no());
        AccountDetails savedAccountDetails = accountDetailsRepository.save(accountDetails);
        return savedAccountDetails;
    }

    /**
     * @param id
     */
    public void deleteById(AccountDetailsPK accountDetailsPK) {
    	accountDetailsRepository.deleteById(accountDetailsPK);
    }

}
