package jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/4/13 15:49
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object targetObject;

    public DynamicProxyHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getProxy() {
        Class<?> targetObjectType = targetObject.getClass();
        return Proxy.newProxyInstance(targetObjectType.getClassLoader(), targetObjectType.getInterfaces(), this);
    }

    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     *
     * @param className
     * @param path
     */
    private void addClassToDisk(String className, String path) {
        // 用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, targetObject.getClass().getInterfaces());
        try (FileOutputStream out = new FileOutputStream(path)) {
            // 将代理对象的class字节码写到硬盘上
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        addClassToDisk(proxy.getClass().getName(), "F:/$Proxy0.class");
        System.out.println("jdkproxy impl Interface:" + Arrays.toString(proxy.getClass().getInterfaces()));
        System.out.println("methodNem:" + method.getName());
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        System.out.println("argsClass:" + Arrays.toString(classes));
        System.out.println("before");
        Object result = method.invoke(targetObject, args);
        System.out.println("after");
        return result;
    }

}
