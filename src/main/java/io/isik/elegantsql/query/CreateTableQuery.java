package io.isik.elegantsql.query;

import io.isik.elegantsql.processor.FoundElegantTable;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class CreateTableQuery {

    private String tableName;
    private List<String> columns;

    public CreateTableQuery(FoundElegantTable elegantTable) {
        Set<Field> allFields = elegantTable.getAllFields();
        allFields.forEach(System.out::println);
    }


}
