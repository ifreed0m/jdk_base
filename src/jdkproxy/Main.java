package jdkproxy;

import java.util.Arrays;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/4/13 16:33
 */
public class Main {
    public static void main(String[] args) {
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(HelloImpl2.class);
        HelloTwo helloTwo = (HelloTwo) dynamicProxyHandler.getProxy();
        Hello hello = (Hello) dynamicProxyHandler.getProxy();
        Object proxyObj = dynamicProxyHandler.getProxy();
        System.out.println("proxyObj 实现的接口:" + Arrays.toString(proxyObj.getClass().getInterfaces()));
        System.out.println("-----------------------");
        helloTwo.sayTwo("sayTwo");
        System.out.println("-----------------------");
        hello.say("say");

        /**
         *
         */
//        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(HelloImpl.class);
    }
}
