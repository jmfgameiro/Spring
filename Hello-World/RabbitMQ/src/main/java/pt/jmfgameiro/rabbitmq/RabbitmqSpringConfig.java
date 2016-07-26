package pt.jmfgameiro.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitmqSpringConfig {
	
	/***** CONSTANTS *****/
	private static String host;
	private static int port;
	private static int maxConcurrency;
	
	
	/***** STATIC *****/
	static {
		host = "127.0.0.1";
		port = 5672;
		maxConcurrency = 5;
	}
	
	
	/***** BEANS *****/
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connection = new CachingConnectionFactory();
		connection.setHost( host );
		connection.setPort( port );
		return connection;
	}
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory( connectionFactory() );
		factory.setMaxConcurrentConsumers( maxConcurrency );
		return factory;
	}
	
	@Bean
	public RabbitAdmin rabbitAdmin() {
		return new RabbitAdmin( connectionFactory() );
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate( connectionFactory() );
	}
	
	@Bean
	public RabbitMessagingTemplate rabbitMessagingTemplate() {
		return new RabbitMessagingTemplate( rabbitTemplate() );
	}
	
	
}
