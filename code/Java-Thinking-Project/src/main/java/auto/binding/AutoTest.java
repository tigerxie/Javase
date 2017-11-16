package auto.binding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoTest {
    public void f(List m) {
        System.out.println("List");
    }

    public void f(Collection c) {
        System.out.println("Collection");
    }

    public void f(Set m) {
        System.out.println("Set");
    }

    public static void main(String[] args) {
        AutoTest overrideTest = new AutoTest();
        Collection[] c = { new ArrayList(), new HashSet() };
        for (int i = 0; i < c.length; i++) {
            overrideTest.f(c[i]);
        }
    }
}
