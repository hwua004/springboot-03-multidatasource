package com.hwua.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.hwua.springboot.dao.write",
        sqlSessionFactoryRef="getWriteSqlSessionFactory")
public class WriteDBConfig {
    /*
    * <bean id="xxx" class="yyy">
    *     @Bean相当于写了bean表现
    *     方法的返回值类型机相当于class指向的类型
    *     id相当于方法名
    * */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource getWriteDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory getWriteSqlSessionFactory()throws Exception{
        SqlSessionFactoryBean bean= new SqlSessionFactoryBean();
        bean.setDataSource(getWriteDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mappers/write/*Dao.xml"));
        return bean.getObject();
    }
    @Bean
    public SqlSessionTemplate getWriteSqlSessionTemplate()throws Exception{
        SqlSessionTemplate template= new SqlSessionTemplate(getWriteSqlSessionFactory());
        return template;
    }


}
