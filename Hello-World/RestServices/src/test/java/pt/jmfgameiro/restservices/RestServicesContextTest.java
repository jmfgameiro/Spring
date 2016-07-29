package pt.jmfgameiro.restservices;

import javax.ws.rs.core.Response;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pt.jmfgameiro.Application;
import pt.jmfgameiro.resources.restclient.ClientService;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = Application.class )
@WebAppConfiguration
public class RestServicesContextTest {
	
	/*****  *****/
	private static final Integer PORT = 8080;
	private static final String SERVICE = "/hello";
	private static final ClientService CLIENT = new ClientService( "localhost", PORT , SERVICE );
	
	/*****  *****/
	@BeforeClass
	public static void beforeClass() {
		
	}
	
	/*****  *****/
	@Test
	public void helloWorld() {
		try {
			Response response = CLIENT.get( "/world" );
			System.out.println( "RESPONSE: " + response );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
}
