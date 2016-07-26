package pt.jmfgameiro.mongodb.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pt.jmfgameiro.mongodb.MongodbSpringConfig;
import pt.jmfgameiro.mongodb.entity.HelloWorldDocument;
import pt.jmfgameiro.mongodb.repository.HelloWorldRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = MongodbSpringConfig.class )
public class HelloWorldTest {
	
	/***** CONSTANTS *****/
	@Autowired
	private HelloWorldRepository repository;
	private static final String ID = "id", NAME = "jmfgameiro";
	
	
	/***** BEFORE *****/
	@Before
	public void init() {
		assertNotNull( "The repository was not autowired!", repository );
		this.repository.deleteAll();
		HelloWorldDocument hello = new HelloWorldDocument( ID, NAME );
		this.repository.save( hello );
	}
	
	/***** TEST *****/
	@Test
	public void execute() {
		assertEquals( "There are more elements than expected", 1, this.repository.count() );
		HelloWorldDocument hello = this.repository.findOne( ID );
		assertNotNull( "There is no element for the given ID!", hello );
		assertEquals( "The name is not the same as the provided!", hello.getName(), NAME );
	}
	
	
}
