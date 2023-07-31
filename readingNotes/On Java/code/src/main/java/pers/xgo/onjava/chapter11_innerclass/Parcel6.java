package pers.xgo.onjava.chapter11_innerclass;

// 将一个类嵌入到某个作用域内
public class Parcel6 {
    private void internalTracking(boolean b) { // 内部跟踪
        if (b) {
            class TrackingSlip { // 追踪单
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("x");
            String s = ts.getSlip();
        }
        // 这里不能使用，已经出了作用域
        // TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
