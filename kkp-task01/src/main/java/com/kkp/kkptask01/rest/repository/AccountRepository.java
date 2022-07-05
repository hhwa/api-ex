package com.kkp.kkptask01.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kkp.kkptask01.rest.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
}
