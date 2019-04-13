import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] integers = {1, 5, 6};
        Integer[] newIntegers = (Integer[]) copyOfArray(integers, integers.length << 1);
        System.out.println(Arrays.toString(newIntegers));
        System.out.println(invorkMethod("fdvkdsmv", "equalsIgnoreCase", "f"));
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
