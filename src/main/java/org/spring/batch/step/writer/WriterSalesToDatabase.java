package org.spring.batch.step.writer;

import lombok.RequiredArgsConstructor;
import org.spring.batch.entity.Sales;
import org.spring.batch.repository.SalesRepository;
import org.spring.batch.utils.Constant;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WriterSalesToDatabase {

    private final SalesRepository repository;

    @Bean
    public RepositoryItemWriter<Sales> writeSalesToDatabase() {
        RepositoryItemWriter<Sales> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName(Constant.METHOD_NAME);
        return writer;
    }
}
