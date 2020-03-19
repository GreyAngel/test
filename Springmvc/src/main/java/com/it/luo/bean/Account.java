package com.it.luo.bean;

import sun.applet.resources.MsgAppletViewer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private String username;
    private String password;
    private BigDecimal money;

    private User user;
    private List<BankAccount> bankAccounts;
    private Map<String , Integer> map;
    private Map<String , User> map1;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, User> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, User> map1) {
        this.map1 = map1;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", bankAccounts=" + bankAccounts +
                ", map=" + map +
                ", map1=" + map1 +
                '}';
    }
}
