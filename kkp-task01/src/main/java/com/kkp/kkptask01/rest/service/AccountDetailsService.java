package com.kkp.kkptask01.rest.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kkp.kkptask01.rest.domain.AccountDetails;
import com.kkp.kkptask01.rest.inter.AvgBalanceInterface;
import com.kkp.kkptask01.rest.inter.TotalBalanceInterface;
import com.kkp.kkptask01.rest.inter.YearBalanceInterface;
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
     * @return
     */
    public List<AvgBalanceInterface> findAvgBalance() {
        return accountDetailsRepository.findAvgBalance();
    }
    
    /**
     * @param yyyy
     * @return
     */
    public List<YearBalanceInterface> findYearBalance(int yyyy) {
        return accountDetailsRepository.findYearBalance(yyyy);
    }
    
    /**
     * @param startdate
     * @param enddate
     * @return
     */
    public List<TotalBalanceInterface> findTotalBalanceByDate(String startdate,String enddate) {
        return accountDetailsRepository.findTotalBalanceByDate(startdate,enddate);
    }
    
    

    /**
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

}
