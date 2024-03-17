package org.spring.batch.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    public static final String SALES_100_DATA = "src/main/resources/sales_100.csv";
    public static final String SALES_500_000_DATA = "src/main/resources/sales_500_000.csv";
    public static final String ITEM_READER_NAME = "csvReader";
    public static final String METHOD_NAME = "save";
    public static final String STEP_BUILDER_NAME = "csvImport";
    public static final String JOB_BUILDER_NAME = "importSales";
    public static final Integer CHUNK_SIZE = 1000;
}
