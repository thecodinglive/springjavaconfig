package info.thecodinglive.api.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"info.thecodinglive.api"})
public class DBConfig implements TransactionManagementConfigurer{

	 /**
	  * DataSource 설정
	  * <bean id="dataSource"
	  *  class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	  *
	  *  <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
	  *  <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe" />
	  *  <property name="username" value="intercast" />
	  *  <property name="password" value="pass123!" />
	  * </bean>
	  */
	
	   @Bean
	    public DataSource getDataSource() {
		   return new EmbeddedDatabaseBuilder()
				   .setName("testdb")
				   .setType(EmbeddedDatabaseType.HSQL)
				   .addScript("schema.sql")
				   .addScript("data.sql")
				   .build();
	    }

	   @Bean
	   public DataSourceTransactionManager transactionManager() {
	       return new DataSourceTransactionManager(getDataSource());
	   }

	  @Override
	   public PlatformTransactionManager annotationDrivenTransactionManager() {
		   return transactionManager();
	}
	   
	   /**
	    * SqlSessionFactory 설정
	    *
	    * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	    *  <property name="dataSource" ref="dataSource" />
        *  
	    * <property name="mapperLocations" value="classpath:com/ttp/cmsapi/mybatis/*.xml" />
	    * </bean>
	    *
	    * @param dataSource
	    * @param applicationContext
	    * @return
	    * @throws IOException
	    */
	   @Bean
	   public SqlSessionFactory sqlSessionFactory() throws Exception {
	      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	      sessionFactory.setDataSource(getDataSource());
	      sessionFactory.setTypeAliasesPackage("info.thecodinglive.api.mybatis");
	      sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:info/thecodinglive/api/mybatis/*.xml"));
	      return sessionFactory.getObject();
	   }
	   
	   /**
	    * SqlSessionTemplate 설정
	    *
	    * <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	    *  <constructor-arg ref="sqlSessionFactory" />
	    * </bean>
	    *
	    * @param sqlSessionFactory
	    * @return
	    */
	   @Bean
	   public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		   return new SqlSessionTemplate(sqlSessionFactory());
	   }
}
