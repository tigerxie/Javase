package com.ericsson.upg.generics;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static <T> Set<T> different(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(superset);
        return result;
    }
}
