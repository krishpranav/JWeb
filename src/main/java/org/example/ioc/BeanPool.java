package org.example.ioc;

import java.util.HashMap;
import java.util.Map;

public class BeanPool {

    private static BeanPool beansPool;

    public static BeanPool getInstance() {
        if (beansPool == null)
            beansPool = new BeanPool();
        return beansPool;
    }

    private Map<Class, Object> map = new HashMap<>();

    public Object getObject(Class clazz) {
        return map.get(clazz);
    }

    public void setObject(Class clazz, Object object) {
        map.put(clazz, object);
    }
}