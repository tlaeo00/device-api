package com.example.deviceapi.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * mybatis 설정
 * (mybatis 설정은 application.properties 설정으로 되지 않기 때문에 스프링 @Configuration 설정으로함)
 * 참고 - https://www.leafcats.com/16
 */
@Configuration
@MapperScan(basePackages="com.example.deviceapi")
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml")); // mybatis config 설정
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml")); // resources/mybatis/ 폴더내에 있는 모든 xml 파일에 적용
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true); // mapper 에 camel case 맵핑
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}