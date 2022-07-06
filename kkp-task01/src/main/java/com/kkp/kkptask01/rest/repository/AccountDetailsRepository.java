package com.kkp.kkptask01.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kkp.kkptask01.rest.domain.AccountDetails;
import com.kkp.kkptask01.rest.domain.AccountDetailsPK;
import com.kkp.kkptask01.rest.inter.AvgBalanceInterface;
import com.kkp.kkptask01.rest.inter.TotalBalanceInterface;
import com.kkp.kkptask01.rest.inter.YearBalanceInterface;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, AccountDetailsPK>{
	
	@Query(value ="SELECT (AGE/10)*10 AVGAGE,ROUND(AVG(BALANCE),0) AVGBALANCE FROM (\r\n"
			+ "SELECT\r\n"
			+ "M.AGE,\r\n"
			+ "SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'Y' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) -  SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'N' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) AS BALANCE\r\n"
			+ "FROM MEMBER  M \r\n"
			+ "INNER JOIN ACCOUNT T ON M.ID = T.ID \r\n"
			+ "INNER JOIN ACCOUNT_DETAILS TD ON T.ACCOUNT_NO = TD.ACCOUNT_NO \r\n"
			+ "GROUP BY M.id,M.AGE\r\n"
			+ "ORDER BY AGE\r\n"
			+ ")\r\n"
			+ "GROUP BY (AGE/10)*10"
			,nativeQuery = true)
	List<AvgBalanceInterface> findAvgBalance();
	
	@Query(value ="SELECT\r\n"
			+ "SUBSTR(DEPOSIT_DATE,1,4)  AS YYYY,\r\n"
			+ "SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'Y' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) -  SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'N' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) AS BALANCE\r\n"
			+ "FROM MEMBER  M \r\n"
			+ "INNER JOIN ACCOUNT T ON M.ID = T.ID \r\n"
			+ "INNER JOIN ACCOUNT_DETAILS TD ON T.ACCOUNT_NO = TD.ACCOUNT_NO \r\n"
			+ "WHERE SUBSTR(DEPOSIT_DATE,1,4) = :yyyy \r\n"
			+ "GROUP BY SUBSTR(DEPOSIT_DATE,1,4) "
			,nativeQuery = true)
	List<YearBalanceInterface> findYearBalance(@Param("yyyy") int yyyy);
	
	@Query(value ="SELECT\r\n"
			+ "M.ID,\r\n"
			+ "M.NAME,\r\n"
			+ "SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'Y' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) -  SUM(CASE WHEN TD.DEPOSIT_WITHDRAWAL_STATUS = 'N' THEN TD.DEPOSIT_AMOUNT ELSE 0 END) AS BALANCE\r\n"
			+ "FROM MEMBER  M \r\n"
			+ "INNER JOIN ACCOUNT T ON M.ID = T.ID \r\n"
			+ "INNER JOIN ACCOUNT_DETAILS TD ON T.ACCOUNT_NO = TD.ACCOUNT_NO \r\n"
			+ "WHERE REPLACE(DEPOSIT_DATE,'-','') between :startdate and :enddate \r\n"
			+ "GROUP BY M.ID,M.NAME\r\n"
			+ "ORDER BY BALANCE DESC"
			,nativeQuery = true)
	List<TotalBalanceInterface> findTotalBalanceByDate(@Param("startdate") String startdate,@Param("enddate") String enddate);
}
