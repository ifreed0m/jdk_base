package jdkproxy;

import java.util.Arrays;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/4/13 16:33
 */
public class Main {
    public static void main(String[] args) {
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(new HelloImpl2());
        Object proxyObj = dynamicProxyHandler.getProxy();
        HelloTwo proxyHelloTwo = (HelloTwo) proxyObj;
        Hello proxyHello = (Hello) proxyObj;
        System.out.println("proxyObj 实现的接口:" + Arrays.toString(proxyObj.getClass().getInterfaces()));
        System.out.println("-----------------------");
        proxyHelloTwo.sayTwo("sayTwo");
        System.out.println("-----------------------");
        proxyHello.say("say");

    }
}
