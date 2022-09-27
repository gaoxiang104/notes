package pers.gx.p3;

public class Method02 {
    public static void main(String args[]) {
        int[][] map = {{0,0,1},{1,1,1},{1,2,3}};
        MyTools mt = new MyTools();
        mt.forArray(map);
    }

}

class MyTools {
    void forArray(int[][] map) {
        for(int i = 0; i < map.length; i++){
            int[] m1 = map[i];
            for(int j = 0; j < m1.length; j++){
                System.out.print(m1[j] + " ");
            } 
            System.out.println();
        }
    }
}