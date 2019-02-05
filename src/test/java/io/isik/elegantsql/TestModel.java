package io.isik.elegantsql;

import io.isik.elegantsql.annotations.ElegantID;
import io.isik.elegantsql.annotations.ElegantTable;

import java.util.List;

@ElegantTable
public class TestModel extends Elegant {

    @ElegantID
    private String id;

    private int someNumericValue;

    private boolean someBool;

    private float maybeFloat;

    private List<ManyOther> manyOthers;

    private OneOther oneOther;

}
