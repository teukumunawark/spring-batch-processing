package org.spring.batch.job;

import org.spring.batch.utils.Constant;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesJobConfiguration {

    @Bean
    public Job runJob(
            JobRepository jobRepository,
            @Qualifier("stepImportCsv") Step stepImportCsv
    ) {
        return new JobBuilder(Constant.JOB_BUILDER_NAME, jobRepository)
                .start(stepImportCsv)
                .build();
    }
}
