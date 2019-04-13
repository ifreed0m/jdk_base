package jdkproxy;

/**
 * @author 18070878
 * @version 1.0
 * @date 2019/4/13 15:48
 */
public class HelloImpl2 implements Hello, HelloTwo {
    @Override
    public void say(String string) {
        System.out.println("哦呵呵2：" + string);
    }

    @Override
    public void sayTwo(String string) {
        System.out.println("哦呵呵2sayTwo：" + string);
    }
}
