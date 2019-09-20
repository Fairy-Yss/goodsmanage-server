package com.lqcool.service.account.impl;

import com.lqcool.dao.account.AccountDao;
import com.lqcool.model.account.Account;
import com.lqcool.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Map login(String accountNo, String password, HttpServletRequest request) {
        Map resultMap = null;
        try{
            Account account = this.checkAccount(accountNo, password);
            if(account != null){
                request.getSession().setAttribute("account", account);
                account.setPassword("*********");
                resultMap = new HashMap<String,Object>() {
                    {
                        put("status","ok");
                        put("account",account);
                        put("statusText","登陆成功");
                    }
                };
                return resultMap;
            } else {
                resultMap = new HashMap<String,Object>(){
                    {
                        put("status","no");
                        put("statusText","账户不存在或者账户名密码错误");
                    }
                };
            }
            return resultMap;
        } catch (Exception e){
            e.printStackTrace();
            resultMap = new HashMap<String,Object>(){
                {
                    put("status","no");
                    put("statusText",e.getStackTrace());
                }
            };
        }
        return resultMap;
    }

    @Override
    public Map logout(HttpServletRequest request) {
        Map resultMap = null;
        HttpSession session = request.getSession();
        session.removeAttribute("account");

        resultMap = new HashMap(){{
            put("status","ok");
            put("statusText","退出登陆成功");
        }};

        return resultMap;
    }

    @Override
    public Account getAccountByAccountNo(String accountNo) {
        return null;
    }

    @Override
    public Map addAccount(Account account) {
        Map resultMap = null;
        try {
            int result = this.accountDao.addAccount(account);
            if(result > 0) {
                resultMap = new HashMap(){
                    {
                        put("status","ok");
                        put("statusText","创建成功");
                    }
                };
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMap = new HashMap<String,Object>(){
                {
                    put("status","no");
                    put("statusText",e.getStackTrace());
                }
            };
        }
        return resultMap;
    }


    public Account checkAccount(String accountNo, String password) {
        try {
            Account account = this.accountDao.getAccountByAccountNo(accountNo);
            if(password.equals(account.getPassword())) {
                return account;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
