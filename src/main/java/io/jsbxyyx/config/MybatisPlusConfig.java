package io.jsbxyyx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author jsbxyyx
 */
@Configuration
@MapperScan("io.jsbxyyx.mapper")
public class MybatisPlusConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean sqlSessionFactoryBean =
                new com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/mapper/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(DataSource dataSource) throws Exception {
        DbType dbType;
        try (Connection con = dataSource.getConnection()) {
            String url = con.getMetaData().getURL();
            dbType = com.baomidou.mybatisplus.extension.toolkit.JdbcUtils.getDbType(url);
        }
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(dbType));
        return interceptor;
    }

}
