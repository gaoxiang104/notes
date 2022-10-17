package org.gx.chapter08.p18;

import org.gx.chapter08.p03.modifier.B;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 支付流水
 */
public class PlayFlow {
    /**
     * 标题
     */
    private String title;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 创建流水时间
     */
    private String createTime;

    /**
     * 余额
     */
    private BigDecimal balance;

    public PlayFlow() {
    }

    public PlayFlow(String title, double amount, BigDecimal balance) {
        this.title = title;
        this.amount = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
        this.balance = balance;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        createTime = df.format(new Date());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(title).append(" ");
        if (amount.compareTo(BigDecimal.ZERO) == 1) {
            sb.append("+").append(amount.setScale(2, RoundingMode.HALF_UP));
        } else {
            sb.append(amount.setScale(2, RoundingMode.HALF_UP));
        }
        sb.append(" ").append(createTime).append(" ")
                .append("余额：").append(balance.setScale(2, RoundingMode.HALF_UP));
        return sb.toString();
    }
}
