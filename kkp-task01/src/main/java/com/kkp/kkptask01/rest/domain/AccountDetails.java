package com.kkp.kkptask01.rest.domain;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class AccountDetails{
	
	@EmbeddedId
	private AccountDetailsPK accountDetails;
	
	@Column
	private String deposit_date;
	
	@Builder
	public AccountDetails(AccountDetailsPK accountDetails) {
		this.accountDetails.setAccount_no(accountDetails.getAccount_no());
		this.accountDetails.setDeposit_amount(accountDetails.getDeposit_amount());
		this.accountDetails.setDeposit_withdrawal_status(accountDetails.getDeposit_withdrawal_status());
	}
	
//	@Builder
//	public AccountDetails(String account_no,String deposit_withdrawal_status,int deposit_amount,String deposit_date) {
//		this.account_no = account_no;
//		this.deposit_withdrawal_status = deposit_withdrawal_status;
//		this.deposit_amount = deposit_amount;
//		this.deposit_date = deposit_date;
//	}
	
	

}
