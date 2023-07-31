package pers.xgo.onjava.chapter11_innerclass;

public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost; // 费用

            // 为每个对象执行实例初始化
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.printf("Over budget"); // 超出预算
                }
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.295F);
    }
}
/* OUTPUT:
Over budget
 */