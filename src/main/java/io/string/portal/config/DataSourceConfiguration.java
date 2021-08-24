package io.string.portal.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.string.portal.context.DatabaseEnvironment;
import io.string.portal.context.MasterSlaveRoutingDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "datasource.master")
    public HikariConfig hikariMasterConfig() {
        HikariConfig config = new HikariConfig();
        return config;
    }

    public DataSource masterDataSource() {
        return new HikariDataSource(hikariMasterConfig());
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.slave")
    public HikariConfig hikariSlaveConfig() {
        HikariConfig config = new HikariConfig();
        return config;
    }

    public DataSource slaveDataSource() {
        return new HikariDataSource(hikariSlaveConfig());
    }

    @Bean
    public DataSource dataSource() {
        MasterSlaveRoutingDataSource masterSlaveRoutingDataSource = new MasterSlaveRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseEnvironment.UPDATABLE, masterDataSource());
        targetDataSources.put(DatabaseEnvironment.READONLY, slaveDataSource());
        masterSlaveRoutingDataSource.setTargetDataSources(targetDataSources);

        // Set as all transaction point to master
        masterSlaveRoutingDataSource.setDefaultTargetDataSource(masterDataSource());
        return masterSlaveRoutingDataSource;
    }
}
