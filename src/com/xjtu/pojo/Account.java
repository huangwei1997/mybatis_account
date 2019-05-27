package com.xjtu.pojo;

public class Account {
    private int aid; //账户id
    private String aname; //账户名
    private String apwd; //账户密码
    private double money; //账户余额

    public Account(){}

    public Account(int aid, String aname, String apwd, double money) {
        this.aid = aid;
        this.aname = aname;
        this.apwd = apwd;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", apwd='" + apwd + '\'' +
                ", money=" + money +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
