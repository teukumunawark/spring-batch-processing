package org.spring.batch.step;

import org.spring.batch.config.SalesProcessor;
import org.spring.batch.entity.Sales;
import org.spring.batch.utils.Constant;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepImportCsvToDatabase {

    @Bean
    public Step stepImportCsv(
            JobRepository jobRepository,
            PlatformTransactionManager platformTransactionManager,
            @Qualifier("readSalesFromCsv") FlatFileItemReader<Sales> readSalesFromCsv,
            @Qualifier("processSales") SalesProcessor processSales,
            @Qualifier("writeSalesToDatabase") RepositoryItemWriter<Sales> writeSalesToDatabase
    ) {
        return new StepBuilder(Constant.STEP_BUILDER_NAME, jobRepository)
                .<Sales, Sales>chunk(Constant.CHUNK_SIZE, platformTransactionManager)
                .reader(readSalesFromCsv)
                .processor(processSales)
                .writer(writeSalesToDatabase)
                .build();
    }
}
