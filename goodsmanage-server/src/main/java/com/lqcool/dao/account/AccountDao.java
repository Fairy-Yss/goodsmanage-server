package com.lqcool.dao.account;

import com.lqcool.model.account.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    public Account getAccountByAccountNo(String accountNo) throws Exception;

    public int addAccount(Account account) throws Exception;

}
