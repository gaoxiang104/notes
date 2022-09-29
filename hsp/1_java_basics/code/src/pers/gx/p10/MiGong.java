package pers.gx.p10;

public class MiGong {
    public static void main(String[] args) {
        String[][] map = new String[][]{
                {"*", "*", "*", "*", "*", "*", "*"},
                {"*", "0", "0", "0", "0", "0", "*"},
                {"*", "0", "*", "0", "0", "0", "*"},
                {"*", "*", "*", "0", "*", "0", "*"},
                {"*", "0", "*", "0", "*", "0", "*"},
                {"*", "0", "0", "*", "0", "0", "*"},
                {"*", "0", "0", "0", "0", "0", "*"},
                {"*", "*", "*", "*", "*", "*", "*"}
        };
        printMap(map);
        findWay(map, 1, 1);
        printMap(map);
    }

    static void printMap(String[][] map) {
        System.out.println("====棋盘====");
        for (int i = 0; i < map.length; i++) {
            String[] dn = map[i];
            for (int j = 0; j < dn.length; j++) {
                System.out.print(dn[j] + " ");
            }
            System.out.println();
        }
    }

    // 使用递归回溯到思想来解决老鼠出迷宫

    // 韩老师解读
    // 1. findWay 方法就是专门来找出迷宫的路径
    // 2. 如果找到，就返回 true，否则返回false
    // 3. map 是二维数组，表示迷宫
    // 4. x,y 就是老鼠的位置，初始化的位置为(1,1)
    // 5. 因为我们是递归的找路，所以县规定 map 数组的各个值的含义
    //    *表示障碍物 0表示可以走，未走过 2表示可以走 3表示走过，但是走不通，是死路
    // 6. 当map[6][5] = 2 就说明找到通路，否则就继续 
    static boolean findWay(String[][] map, int x, int y) {
        if(map[6][5].equals("2")) { // 说明已经找到
            return true;
        } else {
            if(map[x][y].equals("0")){ // 当前这个位置0，说明表示还没走过，可以走
                map[x][y] = "2"; // 假定可以走通，设置为2
                // 使用找路策略，来确定该位置是否真的可以走通
                // 下 -> 右 -> 上 -> 左

                // 个人理解：  map[x][y] = 2;这个假定的成立条件是能不能找下一个可以走的点

                if(findWay(map, x + 1, y)){ // 往下走
                    return true;
                } else if(findWay(map, x, y + 1)){ // 往右走
                    return true;
                } else if(findWay(map, x - 1, y)){ // 往上走
                    return true;
                } else if(findWay(map, x, y - 1)){ // 往左走
                    return true;
                } else {
                    map[x][y] = "3"; // 此路不通
                    return false; 
                }
            } else {
                return false;
            }
        }
    }
}

