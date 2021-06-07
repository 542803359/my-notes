package com.example.demostrategy.strategy.context;

public enum LoginEnum {


    WX("loginForWx"),

    VCODE("loginForVcode");

    private String name;

    LoginEnum(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return name;
    }
}
