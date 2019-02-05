package io.isik.elegantsql;

import io.isik.elegantsql.annotations.ElegantTable;
import io.isik.elegantsql.processor.FoundElegantTable;
import io.isik.elegantsql.query.CreateTableQuery;
import org.reflections.Reflections;

import java.util.Properties;
import java.util.Set;

public class Elegant {

    public static void makeItElegant(String prefixPackage, Properties properties) {
        Reflections reflections = new Reflections(prefixPackage);

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(ElegantTable.class);
        annotated.forEach(elegantTableClass -> {
            FoundElegantTable foundElegantTable = new FoundElegantTable(elegantTableClass);
            new CreateTableQuery(foundElegantTable);
        });
    }

}
