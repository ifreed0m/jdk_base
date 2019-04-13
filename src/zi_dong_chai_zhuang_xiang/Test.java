package zi_dong_chai_zhuang_xiang;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        // 这样操作修改了缓存IntegerCache.cache里面的值
        //  IntegerCache.cache[129]==1 --改变--> 2
        //  IntegerCache.cache[130]==2 --改变--> 1
        //  的值被改变了
        swap(a, b);
        System.out.println(a + "-" + b);// 输出2-1
        // 这里会自动装箱Integer.valueOf()会先找缓存(-128-127之间的数字)
        Integer after_a = 1;// 相当于 Integer after_a = Integer.valueOf(1);
        Integer after_b = 2;// 相当于 Integer after_b = Integer.valueOf(2);
        System.out.println(after_a + "-" + after_b);// 输出2-1
        // 用new的方式强制要求重新创建对象，不在IntegerCache.cache里面取值
        Integer new_after_a = new Integer(1);
        Integer new_after_b = new Integer(2);
        System.out.println(new_after_a + "-" + new_after_b);// 输出1-2


        Integer[] integers = {1, 5, 6};
        Integer[] newIntegers = (Integer[]) copyOfArray(integers, integers.length << 1);
        System.out.println(Arrays.toString(newIntegers));
        System.out.println(invorkMethod("fdvkdsmv", "equalsIgnoreCase", "f"));
    }

    /**
     * 这样操作修改了缓存IntegerCache.cache里面的值
     * IntegerCache.cache[129]
     * IntegerCache.cache[130]
     * 的值被改变了
     *
     * @param numa
     * @param numb
     */
    public static void swap(Integer numa, Integer numb) {
        try {
            Integer value_a = new Integer(numa.intValue());
            Integer value_b = new Integer(numb.intValue());
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(numa, value_b);
            field.set(numb, value_a);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object copyOfArray(Object sourceArray, int newLength) {
        Class clazz = sourceArray.getClass();
        if (!clazz.isArray()) {
            return null;
        }
        int length = Array.getLength(sourceArray);
        Object newArray = Array.newInstance(clazz.getComponentType(), newLength);
        System.arraycopy(sourceArray, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    public static Object invorkMethod(Object targetObj, String mathodName, Object... params) {
        Class clazz = targetObj.getClass();
        Class[] parameterTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            parameterTypes[i] = params[i].getClass();
        }
        Object o = null;
        try {
            Method method = clazz.getMethod(mathodName, parameterTypes);
            o = method.invoke(targetObj, params);
        } catch (Exception e) {
        }
        return o;
    }
}
