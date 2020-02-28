package io.pivotal.pal.tracker;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

    private DataSource dataSource;
    
    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
    
    public PalTrackerApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    TimeEntryRepository timeEntryRepository() {
        return new JdbcTimeEntryRepository(dataSource);
    }
}