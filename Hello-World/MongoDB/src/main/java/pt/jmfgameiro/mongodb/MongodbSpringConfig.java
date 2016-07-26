package pt.jmfgameiro.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories( basePackages = "pt.jmfgameiro.mongodb" )
public class MongodbSpringConfig {
	
	/***** CONSTANTS *****/
	private static String host;
	private static String dbname;
	
	
	/***** STATIC *****/
	static {
		host = "127.0.0.1";
		dbname = "test";
	}
	
	
	/***** BEANS *****/
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory( new MongoClient( host ), dbname );
	}
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate( mongoDbFactory() );
	}
	
}
