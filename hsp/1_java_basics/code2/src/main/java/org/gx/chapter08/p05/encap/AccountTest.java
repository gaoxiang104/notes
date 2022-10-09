package org.gx.chapter08.p05.encap;

/*
com.hspedu.encap 包:AccountTest.java 和 Account.java
创建程序，在其中定义两个类：Account和AccountTest类体会Java的封装性。
1. Account类要求具有属性：姓名（长度为2位3位或4位）、余额(必须>20)密码（必须是六位），如果不满足，则给出提示信息，并给默认值
2.通过setXxx的方法给Account 的属性赋值。
3.在AccountTest中测试
提示知识点：:String name=int len = name.length();
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("tomcat", 19.9, "abcde");
        System.out.println(account);
    }
}

class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    // 姓名（长度为2位3位或4位）
    public void setName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            System.out.println("输入错误，名字范围：2 ～ 4");
            this.name = "无名氏";
        } else {
            this.name = name;
        }
    }

    public double getBalance() {
        return balance;
    }

    // 余额(必须>20)
    public void setBalance(double balance) {
        if (balance < 20) {
            System.out.println("输入错误，余额(必须>20)");
            this.balance = 20;
        } else {
            this.balance = balance;
        }

    }


    public String getPassword() {
        return password;
    }

    // 密码（必须是六位）
    public void setPassword(String password) {
        if (password.length() != 6) {
            System.out.println("输入错误，密码（必须是六位）,默认密码：123456");
            this.password = "123456";
        } else {
            this.password = password;
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"balance\":")
                .append(balance);
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
