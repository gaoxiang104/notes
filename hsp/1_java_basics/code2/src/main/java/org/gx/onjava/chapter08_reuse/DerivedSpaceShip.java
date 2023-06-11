package org.gx.onjava.chapter08_reuse;

public class DerivedSpaceShip extends SpaceShipControls { // 衍生太空船
    private String name;

    public DerivedSpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        DerivedSpaceShip protector = new DerivedSpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
