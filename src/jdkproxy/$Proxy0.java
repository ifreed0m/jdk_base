package jdkproxy;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

//package com.sun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;


/**
 * jdk 动态代理生成的clss文件反编译生成的文件
 */

public final class $Proxy0 extends Proxy implements Hello, HelloTwo {

    public $Proxy0(InvocationHandler invocationhandler) {
        super(invocationhandler);
    }

    public final boolean equals(Object obj) {
        try {
            return ((Boolean) super.h.invoke(this, m1, new Object[]{obj})).booleanValue();
        } catch (Error _ex) {
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            return (String) super.h.invoke(this, m2, null);
        } catch (Error _ex) {
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void say(String s) {
        try {
            super.h.invoke(this, m3, new Object[]{s});
            return;
        } catch (Error _ex) {
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            return ((Integer) super.h.invoke(this, m0, null)).intValue();
        } catch (Error _ex) {
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void sayTwo(String s) {
        try {
            super.h.invoke(this, m4, new Object[]{s});
            return;
        } catch (Error _ex) {
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;
    private static Method m4;

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.demo.jdkproxy.Hello").getMethod("say", new Class[]{Class.forName("java.lang.String")});
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m4 = Class.forName("com.demo.jdkproxy.HelloTwo").getMethod("sayTwo", new Class[]{Class.forName("java.lang.String")});
        } catch (NoSuchMethodException nosuchmethodexception) {
            throw new NoSuchMethodError(nosuchmethodexception.getMessage());
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}

