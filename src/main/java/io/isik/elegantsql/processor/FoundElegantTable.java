package io.isik.elegantsql.processor;

import io.isik.elegantsql.annotations.ElegantIgnore;
import io.isik.elegantsql.annotations.ElegantTable;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("unchecked")
public class FoundElegantTable {

    private String tableName;
    private Class<?> foundClass;

    public FoundElegantTable(Class<?> foundClass) {
        this.foundClass = foundClass;

        ElegantTable declaredAnnotation = foundClass.getDeclaredAnnotation(ElegantTable.class);
        String defaultName = foundClass.getSimpleName()
                .replaceAll("([A-Z])", "_$1")
                .toLowerCase()
                .substring(1) + "s";
        this.tableName = Optional.of(declaredAnnotation.name()).orElse(defaultName);
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

    public String getTableName() {
        return tableName;
    }
}
