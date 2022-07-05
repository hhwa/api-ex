package com.kkp.kkptask01.rest.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class AccountDetailsPK implements Serializable{
	
	@Column
	private String account_no;
	@Column
	private String deposit_withdrawal_status;
	@Column
	private int deposit_amount;
	@Column
	private String deposit_date;
	
	@Builder
	public AccountDetailsPK(String account_no,String deposit_withdrawal_status,int deposit_amount,String deposit_date) {
		this.account_no = account_no;
		this.deposit_withdrawal_status = deposit_withdrawal_status;
		this.deposit_amount = deposit_amount;
		this.deposit_date = deposit_date;
	}
}
