package io.isik.elegantsql;

import io.isik.elegantsql.annotations.ElegantTable;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.reflections.ReflectionUtils.*;

public class ElegantSQL {

    public static void main(String[] args) {
        makeItElegant("io.isik.elegantsql");
    }

    public static void makeItElegant(String prefixPackage) {
        Reflections reflections = new Reflections(prefixPackage);

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(ElegantTable.class);
        annotated.forEach(elegantTableClass -> {
            List<Field> allFields = Arrays.asList(elegantTableClass.getDeclaredFields());
            allFields.forEach(field -> System.out.println(field.getType().getCanonicalName()));
        });
    }

}
