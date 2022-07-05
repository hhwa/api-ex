package com.kkp.kkptask01.rest.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class Account implements Serializable{

	@Id
	@Column
	private String account_no;
	
	@Column
	private Long id;
	
	@Builder
	public Account(Long id, String account_no) {
		this.id = id;
		this.account_no = account_no;
	}

}
