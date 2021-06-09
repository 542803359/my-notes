package com.example.demostrategy.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XWX
 * @date 2021/6/9 14:25
 * @since 3.6
 **/
public class Demo {


    public static void main(String[] args) {
        LoginUmengReq loginUmengReq = new LoginUmengReq();
        loginUmengReq.setUmengToken("0000");
        loginUmengReq.setUserName("xwx");
        test(loginUmengReq);

        LoginVcodeReq loginVcodeReq = new LoginVcodeReq();
        loginVcodeReq.setVcode("0001");
        loginVcodeReq.setUserName("xwx1");
        test2(loginVcodeReq);

        ArrayList<? super LoginBase> loginBases = new ArrayList<>();
        LoginUmengReq umengReq = new LoginUmengReq();
        umengReq.setUmengToken("um");
        LoginVcodeReq vcodeReq = new LoginVcodeReq();
        vcodeReq.setVcode("voce");
        loginBases.add(umengReq);
        loginBases.add(vcodeReq);
        test3((List<? extends LoginBase>) loginBases);
    }


    public static void test(LoginBase loginBase) {

        LoginUmengReq umengReq = (LoginUmengReq) loginBase;
        System.out.println(umengReq.getUserName());
        System.out.println(umengReq.getUmengToken());

    }

    public static void test2(LoginBase loginBase) {
        LoginVcodeReq vcodeReq = (LoginVcodeReq) loginBase;
        System.out.println(vcodeReq.getUserName());
        System.out.println(vcodeReq.getVcode());
    }

    public static void test3(List<? extends LoginBase> loginBases) {
        for (LoginBase loginBase : loginBases) {
            System.out.println(loginBase);
        }
    }
}
