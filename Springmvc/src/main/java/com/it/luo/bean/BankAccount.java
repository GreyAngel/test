package com.it.luo.bean;

import java.io.Serializable;

public class BankAccount implements Serializable {

    private String AccountNum;
    private String AccountPassword;

    public String getAccountNum() {
        return AccountNum;
    }

    public void setAccountNum(String accountNum) {
        AccountNum = accountNum;
    }

    public String getAccountPassword() {
        return AccountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        AccountPassword = accountPassword;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "AccountNum='" + AccountNum + '\'' +
                ", AccountPassword='" + AccountPassword + '\'' +
                '}';
    }
}
