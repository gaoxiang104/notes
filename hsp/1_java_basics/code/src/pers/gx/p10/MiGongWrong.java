package pers.gx.p10;

/**
 * 错误的案例，
 * 错误点： 递归了，没有回溯，导致找到不能走的点不能回溯到上个方法中找其他路走
 */
public class MiGongWrong {

    public static void main(String[] args) {
        String[][] ditu = new String[][]{
                {"*", "*", "*", "*", "*", "*", "*"},
                {"*", "1", "0", "0", "0", "0", "*"},
                {"*", "0", "*", "0", "0", "0", "*"},
                {"*", "*", "*", "0", "0", "0", "*"},
                {"*", "0", "0", "0", "0", "0", "*"},
                {"*", "0", "0", "0", "0", "0", "*"},
                {"*", "0", "0", "0", "0", "$", "*"},
                {"*", "*", "*", "*", "*", "*", "*"}
        };
        run(ditu, 1, 1);
    }

    static void run(String[][] ditu, int x, int y) {
        printDitu(ditu);
        String point = ditu[x][y];
        if ("$".equals(point)) { // 走到了重点
            System.out.println("游戏通过");
            return;
        } else {

            if ("0".equals(ditu[x + 1][y]) || "$".equals(ditu[x + 1][y])) { // 往下走
                System.out.println("走一步：[" + (x + 1) + "," + (y) + "]");
                if ("0".equals(ditu[x + 1][y])) {
                    ditu[x + 1][y] = "1"; // 记录路线
                }
                run(ditu, x + 1, y); // 继续往下
            } else if ("0".equals(ditu[x][y + 1]) || "$".equals(ditu[x][y + 1])) { // 往右走
                System.out.println("走一步：[" + (x) + "," + (y + 1) + "]");
                if ("0".equals(ditu[x][y + 1])) {
                    ditu[x][y + 1] = "1"; // 记录路线
                }
                run(ditu, x, y + 1); // 继续往下
            } else if ("0".equals(ditu[x - 1][y]) || "$".equals(ditu[x - 1][y])) { // 往上走
                System.out.println("走一步：[" + (x - 1) + "," + (y) + "]");
                if ("0".equals(ditu[x - 1][y])) {
                    ditu[x - 1][y] = "1"; // 记录路线
                }
                run(ditu, x - 1, y); // 继续往下
            } else if ("0".equals(ditu[x][y - 1]) || "$".equals(ditu[x][y - 1])) { // 往右走
                System.out.println("走一步：[" + (x) + "," + (y - 1) + "]");
                if ("0".equals(ditu[x][y - 1])) {
                    ditu[x][y - 1] = "1"; // 记录路线
                }
                run(ditu, x, y - 1); // 继续往下
            } else {
                System.out.println("GameOver， 无路可走");
                return;
            }
        }
    }

    static void printDitu(String[][] ditu) {
        for (int i = 0; i < ditu.length; i++) {
            String[] dn = ditu[i];
            for (int j = 0; j < dn.length; j++) {
                System.out.print(dn[j] + " ");
            }
            System.out.println();
        }
    }
}
