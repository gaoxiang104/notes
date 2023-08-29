package pers.xgo.onjava.chapter15_exceptions;

// 重写的方法只能抛出其基类版本中说明的异常，
// 或者时以这些异常为基类派生而来的异常

class BaseballException extends Exception {
}

class Foul extends BaseballException {
} // 犯规

class Strike extends BaseballException {
} // 罢工

abstract class Inning {
    Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
        // 实际上不是必须抛出异常
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    } // 没有抛出检查型异常
}

class StormException extends Exception {
} // 暴风雨

class RainedOut extends StormException {
} // 下雨

class PopFoul extends Foul {
} // 流行犯规

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    // 可以为构造器添加新异常，但是必须处理基类构造器的异常：
    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws BaseballException {
    }

    // 普通方法必须遵守基类方法的约定：
    //- public void walk() throws PopFoul {} // 编译错误

    // 对于基类中存在的方法，接口不能增加其异常：
    //- public void event() throws RainedOut {} // 编译错误

    // 对于基类中不存在的方法，接口中可以自行声明：
    @Override
    public void rainHard() throws RainedOut {
    }

    // 即使基类版本会抛出异常，我们也可以选择不抛出让你好异常
    @Override
    public void event() {
    }

    // 重写的方法，可以抛出其基类版本所说明的异常的子类：
    @Override
    public void atBat() throws PopFoul {
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Grneric baseball exception");
        }

        // 派生版本没有抛出 Strike

        try {
            // 如果向上转型，会发生什么情况？
            Inning i = new StormyInning();
            i.atBat();
            // 必须捕捉来自该方法的基类版本的异常
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Grneric baseball exception");
        }
        
    }
}
