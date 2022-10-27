package org.gx.chapter10.p03;

public class HomeWork06 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", VehiclesFactory.getHorse());
        tang.common();
        tang.passRiver();
    }
}

interface Vehicles { // 交通工具
    void work();
}

class Horse implements Vehicles { // 交通工具：马
    @Override
    public void work() {
        System.out.println("马儿在工作。。。");
    }
}

class Boat implements Vehicles { // 交通工具：船

    @Override
    public void work() {
        System.out.println("船儿在工作。。。");
    }
}

class VehiclesFactory {

    private static final Horse HORSE = new Horse();
    private static final Boat BOAT = new Boat();

    private VehiclesFactory() {

    }

    public static Vehicles getHorse() {
        return HORSE;
    }

    public static Vehicles getBoat() {
        return BOAT;
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void common() {
        if (null == vehicles || !(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }

    public void passRiver() {
        if (null == vehicles || !(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"vehicles\":")
                .append(vehicles);
        sb.append('}');
        return sb.toString();
    }
}