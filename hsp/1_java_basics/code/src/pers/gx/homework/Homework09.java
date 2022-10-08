package pers.gx.homework;

/**
 * 9. 定义Music类，里面有音乐名name，音乐时长times属性，并有播放play功能 和返回本身属性信息的功能方法getInfo.
 */
public class Homework09 {
    public static void main(String[] args) {
        Music music = new Music("牛仔很忙", 4 * 60 + 30);
        music.play();
        music.getInfo();
    }
}

class Music {

    String name;
    int times; // 单位秒

    public Music(){

    }

    public Music(String name, int times){
        this.name = name;
        this.times = times;
    }

    public void play(){
        System.out.println("play....");
    }

    public void getInfo(){
        System.out.println("name : " + name + ", times : " + times);
    }

}