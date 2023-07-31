package pers.xgo.onjava.chapter11_innerclass.controller;

// 这里生成了控制系统的一个具体应用，所有代码在一个类中
// 内部类允许我们为每类事件封装不同功能
public class GreenhouseControls extends Controller {
    // 灯的控制
    private boolean light = false; // 灯
    // 水的控制
    private boolean water = false; // 水

    // 恒温器
    private String thermostat = "Day"; // 白天

    // 开灯
    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    // 关灯
    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    // 开水
    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    // 关水
    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    public class ThermostatNight extends Event {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    // 铃
    public class Bell extends  Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime.toMillis()));
        }

        @Override
        public String toString() {
            return "Bing";
        }
    }

    // 重置
    public class Restart extends Event {
        private Event[] eventsList;

        public Restart(long delayTime,Event[] eventsList){
            super(delayTime);
            this.eventsList = eventsList;
            for (Event e : eventsList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventsList) {
                e.start(); // 重新运行每个事件
                addEvent(e);
            }
            start(); // 重新运行该事件
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    // 终止
    public static class Terminate extends Event{
        public Terminate(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
}
