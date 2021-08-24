package io.string.portal.util;

import java.util.List;
import java.util.Map;

public class CollectionUtil {
    public static boolean isEmpty(Object param){
        if (param == null) return true;
        if (param instanceof String && (((String) param).trim().length() == 0)) return true;
        if (param instanceof List) return ((List<?>)param).isEmpty();
        if (param instanceof Map) return ((Map<?, ?>) param).isEmpty();
        return false;
    }
}
