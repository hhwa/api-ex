package com.kkp.kkptask01.rest.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class Member implements Serializable{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String join_date;
	
	@Builder
	public Member(Long id,String name,int age,String join_date) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.join_date = join_date;
	}
	
	public void update(Member member) {
		this.name = member.getName();
		this.age = member.getAge();
	}
	
}
