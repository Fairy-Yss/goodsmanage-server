package com.lqcool.service.account;

import com.lqcool.model.account.Account;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AccountService {
    public abstract Map login(String accountNo, String password, HttpServletRequest request);

    public abstract Map logout(HttpServletRequest request);

    public abstract Account getAccountByAccountNo(String accountNo);

    public abstract Map addAccount(Account account);
}
