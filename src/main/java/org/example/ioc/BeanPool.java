package org.example.ioc;

import java.util.HashMap;
import java.util.Map;

public class BeanPool {
    private static BeanPool beansPool;

    private static BeanPool getInstance() {
        if (beansPool == null)
            beansPool = new BeanPool();

        return beansPool;
    }

    private Map<Class, Object> map = new HashMap<>();
    
    private Object getObject(Class clazz) {
        return map.get(clazz);
    }
}
