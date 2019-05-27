package com.xjtu.pojo;

public class Log {
    private int outId; //转账账户id
    private int inId; //入账账户id
    private double money; //转账金额

    public Log(){}

    public Log(int outId, int inId, double money) {
        this.outId = outId;
        this.inId = inId;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Log{" +
                "outId=" + outId +
                ", inId=" + inId +
                ", money=" + money +
                '}';
    }

    public int getOutId() {
        return outId;
    }

    public void setOutId(int outId) {
        this.outId = outId;
    }

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
