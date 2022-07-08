package com.api.ex01.rest.controller;

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

import com.api.ex01.rest.domain.AccountDetails;
import com.api.ex01.rest.inter.AvgBalanceInterface;
import com.api.ex01.rest.inter.TotalBalanceInterface;
import com.api.ex01.rest.inter.YearBalanceInterface;
import com.api.ex01.rest.service.AccountDetailsService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accountdetails")
public class AccountDetailController {
	
	private final AccountDetailsService accountDetailsService;
	
	@ApiOperation(value="List of account details")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccountDetails(@PageableDefault Pageable pageable) {
        Page<AccountDetails> accountDetails = accountDetailsService.findAll(pageable);
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }
	
	@ApiOperation(value="Average of balance by age group")
	@GetMapping("/avgbalance")
    public ResponseEntity<?> getAvgBalance() {
        List<AvgBalanceInterface> avgBalance = accountDetailsService.findAvgBalance();
        return new ResponseEntity<>(avgBalance, HttpStatus.OK);
    }
	
	@ApiOperation(value="Total balance for the year")
	@GetMapping("/yearbalance/{yyyy}")
    public ResponseEntity<?> getYearBalance(@PathVariable("yyyy") int yyyy) {
        List<YearBalanceInterface> yearBalance = accountDetailsService.findYearBalance(yyyy);
        return new ResponseEntity<>(yearBalance, HttpStatus.OK);
    }
	
	@ApiOperation(value="Total balance by member over time period")
	@GetMapping("/totalbalance/{startdate}/{enddate}")
    public ResponseEntity<?> getTotalBalanceByDate(@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate) {
        List<TotalBalanceInterface> totalBalance = accountDetailsService.findTotalBalanceByDate(startdate,enddate);
        return new ResponseEntity<>(totalBalance, HttpStatus.OK);
    }
	
	@ApiOperation(value="Add account details")
    @PostMapping
    public ResponseEntity<?> postAccountDetails(@RequestBody AccountDetails accountDetails) {
    	AccountDetails savedAccountDetails = accountDetailsService.save(accountDetails);
        return new ResponseEntity<>(savedAccountDetails, HttpStatus.CREATED);
    }

}
