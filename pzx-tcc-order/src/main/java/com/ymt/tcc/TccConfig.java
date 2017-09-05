/**
 * 
 */
package com.ymt.tcc;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mengyun.tcctransaction.TransactionRepository;
import org.mengyun.tcctransaction.recover.RecoverConfig;
import org.mengyun.tcctransaction.repository.RedisTransactionRepository;
import org.mengyun.tcctransaction.spring.recover.DefaultRecoverConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhailiang
 *
 */
@Configuration
public class TccConfig {
	
	@Autowired
	private DataSourceProperties dataSourceProperties;
	
	@Bean(destroyMethod = "close")
	public DataSource tccDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		return dataSource;
	}
	
	@Bean
	public TransactionRepository transactionRepository() {
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(1000);
		jedisPoolConfig.setMaxWaitMillis(1000);
		
		RedisTransactionRepository transactionRepository = new RedisTransactionRepository();
		transactionRepository.setJedisPool(new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 1000));
		transactionRepository.setKeyPrefix("TCC:ORDER:");
		
//		SpringJdbcTransactionRepository transactionRepository = new SpringJdbcTransactionRepository();
//		transactionRepository.setDataSource(tccDataSource());
//		transactionRepository.setDomain("ORDER");
//		transactionRepository.setTbSuffix("_ORDER");
		return transactionRepository;
	}
	
	@Bean
	public RecoverConfig recoverConfig() {
		DefaultRecoverConfig recoverConfig = new DefaultRecoverConfig();
		recoverConfig.setMaxRetryCount(30);
		recoverConfig.setRecoverDuration(60);
		recoverConfig.setCronExpression("0/30 * * * * ?");
		return recoverConfig;
	}

}
