package pt.jmfgameiro.rabbitmq;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = RabbitmqSpringConfig.class )
public class HelloWorldTest {
	
	/***** CONSTANTS *****/
	private static final String QUEUE_NAME = "test.queue";
	private static final String MESSAGE = "Hello RabbitMQ " + LocalDateTime.now().toString();
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private RabbitAdmin admin;
	
	
	/***** BEFORE *****/
	@Before
	public void before() {
		template.setRoutingKey( QUEUE_NAME );
		template.setQueue( QUEUE_NAME );
		
		admin.declareQueue( new Queue( QUEUE_NAME ) );
	}
	
	
	/***** TEST *****/
	@Test
	public void helloWorldTest() {
		// write message
		template.convertAndSend( MESSAGE );
		// read message
		String actual = ( String )template.receiveAndConvert();
		
		//
		System.out.println( "Received: " + actual );
		assertEquals( MESSAGE, actual );
	}
	
	
	/***** AFTER *****/
	@After
	public void after() {
		admin.deleteQueue( QUEUE_NAME );
	}
	
	
}
