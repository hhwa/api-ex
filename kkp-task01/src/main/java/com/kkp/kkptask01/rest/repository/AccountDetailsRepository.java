package com.kkp.kkptask01.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kkp.kkptask01.rest.domain.AccountDetails;
import com.kkp.kkptask01.rest.domain.AccountDetailsPK;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, AccountDetailsPK>{
}
