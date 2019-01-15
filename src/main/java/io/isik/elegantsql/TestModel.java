package io.isik.elegantsql;

import io.isik.elegantsql.annotations.ElegantID;
import io.isik.elegantsql.annotations.ElegantTable;

@ElegantTable
public class TestModel extends Elegant {

    @ElegantID
    private String id;

    private int someNumericValue;
}
