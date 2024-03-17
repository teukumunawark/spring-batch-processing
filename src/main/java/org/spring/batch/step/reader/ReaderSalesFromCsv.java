package org.spring.batch.step.reader;

import lombok.RequiredArgsConstructor;
import org.spring.batch.config.SalesStepProperties;
import org.spring.batch.entity.Sales;
import org.spring.batch.utils.Constant;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.lang.reflect.Field;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(SalesStepProperties.class)
public class ReaderSalesFromCsv {
    private final SalesStepProperties stepProperties;

    @Bean
    public FlatFileItemReader<Sales> readSalesFromCsv() {
        FlatFileItemReader<Sales> itemReader = new FlatFileItemReader<>();

        itemReader.setResource(new FileSystemResource(Constant.SALES_100_DATA));
        itemReader.setName(Constant.ITEM_READER_NAME);
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());

        return itemReader;
    }

    private LineMapper<Sales> lineMapper() {
        DefaultLineMapper<Sales> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(stepProperties.delimiter());
        lineTokenizer.setStrict(true);
        lineTokenizer.setNames(Arrays.stream(Sales.class.getDeclaredFields())
                .map(Field::getName)
                .toArray(String[]::new));

        BeanWrapperFieldSetMapper<Sales> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Sales.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }
}
