package com.lqcool.model.account;

import com.lqcool.model.base.Entity;

public class Account extends Entity {

    private String accountNo; // 账户

    private String password; // 密码

    private String nickName; // 昵称

    private String roleName; // 角色【user 和 admin】普通用户和管理员

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
