package org.gx.onjava.chapter08_reuse;
// 继承、构造器和参数

class Game{
    Game(int i){
        System.out.println("Game constructor");
    }
}
class BoardGame extends Game{ // 棋盘游戏
    BoardGame(int i){
        super(i);
        System.out.println("BoardGame constructor");
    }
}
public class Chess extends BoardGame{ // 国际象棋
    Chess(){
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
