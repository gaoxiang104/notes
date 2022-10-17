package org.gx.chapter08.p20.house;

import java.util.Scanner;

public class HouseView {

    private HouseService service = new HouseService();

    /**
     * 显示界面
     */
    public void show() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("=============房屋出租系统===============");
            System.out.println("     1 添加房屋信息");
            System.out.println("     2 修改房屋信息");
            System.out.println("     3 删除房屋信息");
            System.out.println("     4 查看");

        } while (flag);
    }

}
