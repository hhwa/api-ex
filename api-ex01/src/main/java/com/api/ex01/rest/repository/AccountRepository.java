package com.api.ex01.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ex01.rest.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
}
