package com.kkp.kkptask01.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kkp.kkptask01.rest.domain.Member;
import com.kkp.kkptask01.rest.inter.RemainAmoutInterface;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	@Query(value ="SELECT\r\n"
			+ "TD.ACCOUNT_NO,\r\n"
			+ "SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'Y' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) -  SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'N' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) AS REMAIN_AMOUNT\r\n"
			+ "FROM MEMBER  M \r\n"
			+ "INNER JOIN ACCOUNT T ON M.ID = T.ID \r\n"
			+ "INNER JOIN ACCOUNT_DETAILS TD ON T.ACCOUNT_NO = TD.ACCOUNT_NO \r\n"
			+ "WHERE M.ID = :id \r\n"
			+ "GROUP BY T.ACCOUNT_NO",nativeQuery = true)
	List<RemainAmoutInterface> findRemainAmountById(@Param("id") Long id);
}
