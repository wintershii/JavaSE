package com.dao;

import java.util.Scanner;

public class Input {
    public static String userInput() {
        System.out.println("请输入账号:");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        return user;
    }

    public static String pwdInput() {
        System.out.println("请输入密码:");
        Scanner scan = new Scanner(System.in);
        String pwd = scan.nextLine();
        return pwd;
    }
}
