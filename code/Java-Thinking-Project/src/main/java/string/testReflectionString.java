package string;

import java.lang.reflect.Field;

public class testReflectionString {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        String string = "111aaaa";
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(false);
        char[] cs = (char[]) field.get(string);
        cs[4] = '_';
        System.out.println(string);
    }
}
