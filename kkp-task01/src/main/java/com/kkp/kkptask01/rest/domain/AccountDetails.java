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
	public AccountDetails(AccountDetailsPK accountDetailsPK,String deposit_date) {
		this.accountDetails = accountDetailsPK;
		this.deposit_date = deposit_date;
	}

}
