package jdkproxy;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/4/13 15:48
 */
public class HelloImpl implements Hello,HelloTwo {
    @Override
    public void say(String string) {
        System.out.println("哦呵呵：" + string);
    }

    @Override
    public void sayTwo(String string) {
        System.out.println("哦呵呵sayTwo：" + string);
    }
}
