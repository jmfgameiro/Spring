package pt.jmfgameiro.elasticsearch;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories( basePackages = "pt.jmfgameiro.elasticsearch" )
public class ElasticsearchSpringConfig {
	
	/***** CONSTANTS *****/
	private static boolean local;
	
	
	/***** STATIC *****/
	static {
		local = true;
	}
	
	
	/***** BEANS *****/
	@Bean
	public NodeBuilder nodeBuilder() {
		return new NodeBuilder();
	}
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate( nodeBuilder().local( local ).node().client() );
	}
	
}
