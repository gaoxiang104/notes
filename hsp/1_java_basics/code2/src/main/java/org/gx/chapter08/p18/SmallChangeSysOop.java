package org.gx.chapter08.p18;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SmallChangeSysOop {

    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 支付明细列表
     */
    private List<PlayFlow> playFlowList;

    public SmallChangeSysOop(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 增减收益
     */
    public void addIncome(double amount) {
        if (0 >= amount) {
            System.out.println("收益必须大于0");
            return;
        }
        modifyBalance(amount);
        addFlow("收益入账", amount);
    }

    /**
     * 增减消费
     */
    public void addConsume(String title, double amount) {
        if (null == title || title.trim().equals("")) {
            System.out.println("请输入正确的消费说明");
            return;
        }
        if (0 >= amount || balance.compareTo(new BigDecimal(amount)) == -1) {
            System.out.println("消费金额必须在 ： 0～" + balance);
            return;
        }
        amount = -1 * amount; // 消费，所以要减
        modifyBalance(amount);
        addFlow(title, amount);
    }

    /**
     * 添加流水
     */
    public void addFlow(String title, double amount) {
        if (null == playFlowList) {
            playFlowList = new ArrayList<>();
        }
        playFlowList.add(new PlayFlow(title, amount, balance));
    }

    /**
     * 修改余额
     */
    public void modifyBalance(double amount) {
        balance = balance.add(new BigDecimal(amount)).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 查看列表
     */
    public void showFlow() {
        for (PlayFlow playFlow : playFlowList) {
            System.out.println(playFlow);
        }
    }
}
