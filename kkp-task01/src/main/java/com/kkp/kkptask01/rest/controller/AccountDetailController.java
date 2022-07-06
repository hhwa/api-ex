package com.kkp.kkptask01.rest.controller;

import java.util.List;

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
import com.kkp.kkptask01.rest.inter.AvgBalanceInterface;
import com.kkp.kkptask01.rest.inter.TotalBalanceInterface;
import com.kkp.kkptask01.rest.inter.YearBalanceInterface;
import com.kkp.kkptask01.rest.service.AccountDetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accountdetails")
public class AccountDetailController {
	
	private final AccountDetailsService accountDetailsService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccountDetails(@PageableDefault Pageable pageable) {
        Page<AccountDetails> accountDetails = accountDetailsService.findAll(pageable);
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }
	
	@GetMapping("/avgbalance")
    public ResponseEntity<?> getAvgBalance() {
        List<AvgBalanceInterface> avgBalance = accountDetailsService.findAvgBalance();
        return new ResponseEntity<>(avgBalance, HttpStatus.OK);
    }
	
	@GetMapping("/yearbalance/{yyyy}")
    public ResponseEntity<?> getYearBalance(@PathVariable("yyyy") int yyyy) {
        List<YearBalanceInterface> yearBalance = accountDetailsService.findYearBalance(yyyy);
        return new ResponseEntity<>(yearBalance, HttpStatus.OK);
    }
	
	@GetMapping("/totalbalance/{startdate}/{enddate}")
    public ResponseEntity<?> getTotalBalanceByDate(@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate) {
        List<TotalBalanceInterface> totalBalance = accountDetailsService.findTotalBalanceByDate(startdate,enddate);
        return new ResponseEntity<>(totalBalance, HttpStatus.OK);
    }
	
    @PostMapping
    public ResponseEntity<?> postAccountDetails(@RequestBody AccountDetails accountDetails) {
    	System.out.println("controll :"+accountDetails.getAccountDetails().getAccount_no());
    	AccountDetails savedAccountDetails = accountDetailsService.save(accountDetails);
        return new ResponseEntity<>(savedAccountDetails, HttpStatus.CREATED);
    }

}
