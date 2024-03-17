package org.spring.batch.config;

import org.spring.batch.entity.Sales;
import org.springframework.batch.item.ItemProcessor;

public class SalesProcessor implements ItemProcessor<Sales, Sales> {

    @Override
    public Sales process(Sales sales) throws Exception {
        return sales;
    }
}
