package com.lqcool.controller.account;

import com.lqcool.model.account.Account;
import com.lqcool.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value="/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value="/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> login(@RequestParam("accountNo") String accountNo,@RequestParam("password") String password, HttpServletRequest request){
        return this.accountService.login(accountNo,password,request);
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request){
        return this.accountService.logout(request);
    }

    @RequestMapping(value="/addAccount",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> addAccount(Account account, HttpServletRequest request){
        return this.accountService.addAccount(account);
    }
}
