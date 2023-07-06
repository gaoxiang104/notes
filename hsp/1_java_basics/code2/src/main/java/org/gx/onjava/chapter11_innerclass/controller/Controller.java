package org.gx.onjava.chapter11_innerclass.controller;

import java.util.ArrayList;
import java.util.List;

// 用于控制系统的可复用框架
public class Controller {
    // 用 java.util 中的一个类来保存 Event 对象
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run(){
        while (eventList.size() > 0){
            // 创建一个副本，这样在选择列表中的元素时就不好改动列表了。
            for (Event e : new ArrayList<>(eventList)) {
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
