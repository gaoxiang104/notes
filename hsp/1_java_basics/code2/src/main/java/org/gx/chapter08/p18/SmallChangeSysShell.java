package org.gx.chapter08.p18;

import java.math.BigDecimal;
import java.util.Scanner;

public class SmallChangeSysShell {
    public static void main(String[] args) {
        SmallChangeSysOop oop = new SmallChangeSysOop(BigDecimal.ZERO);

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("=============零钱通菜单===============");
            System.out.println("     1 零钱通明细");
            System.out.println("     2 收益入账");
            System.out.println("     3 消   费");
            System.out.println("     4 退   出");

            int step = scanner.nextInt();

            switch (step) {
                case 1:
                    System.out.println("零钱通明细：");
                    oop.showFlow();
                    break;
                case 2:
                    System.out.print("请输入收益金额：");
                    double inAmount = scanner.nextDouble();
                    oop.addIncome(inAmount);
                    break;
                case 3:
                    System.out.print("请输入消费说明：");
                    String title = scanner.next();
                    System.out.print("请输入消费金额：");
                    double cAmount = scanner.nextDouble();
                    oop.addConsume(title, cAmount);
                    break;
                case 4:
                    String choose = "";
                    while (true) {
                        System.out.println("请确认是否要退出？ y/n");
                        choose = scanner.next();
                        if ("y".equals(choose) || "n".equals(choose)) {
                            break;
                        }
                    }
                    if (choose.equals("y")) {
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        } while (flag);

    }
}
