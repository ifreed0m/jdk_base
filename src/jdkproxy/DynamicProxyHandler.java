package jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 18070878
 * @version 1.0
 * @date 2019/4/13 15:49
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Class<?> proxyClass;

    public DynamicProxyHandler(Class<?> proxyClass) {
        this.proxyClass = proxyClass;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(proxyClass.getClassLoader(), proxyClass.getInterfaces(), this);
    }

    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     *
     * @param className
     * @param path
     */
    private void addClassToDisk(String className, String path) {
        // 用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, proxyClass.getInterfaces());
        try (FileOutputStream out = new FileOutputStream(path)) {
            // 将代理对象的class字节码写到硬盘上
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        addClassToDisk(proxy.getClass().getName(), "F:/$Proxy0.class");
        System.out.println("jdkproxy impl Interface:" + Arrays.toString(proxy.getClass().getInterfaces()));
        System.out.println("methodNem:" + method.getName());
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        System.out.println("argsClass:" + Arrays.toString(classes));
        return method.invoke(proxyClass.newInstance(), args);
    }

}
