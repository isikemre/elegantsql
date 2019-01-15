package io.isik.elegantsql.processor;

import io.isik.elegantsql.annotations.ElegantIgnore;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

@SuppressWarnings("unchecked")
public class FoundElegantTable {

    private Class<?> foundClass;

    public FoundElegantTable(Class<?> foundClass) {
        this.foundClass = foundClass;
    }

    public Class<?> getFoundClass() {
        return foundClass;
    }

    public Set<Field> getAllFields() {
        return ReflectionUtils.getAllFields(
                foundClass,
                input -> input != null && !input.isAnnotationPresent(ElegantIgnore.class)
        );
    }

}
