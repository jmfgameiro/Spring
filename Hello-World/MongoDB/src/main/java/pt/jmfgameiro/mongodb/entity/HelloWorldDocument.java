package pt.jmfgameiro.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "helloworlds" )
@TypeAlias( "helloworld" )
public class HelloWorldDocument {
	
	/***** CONSTANTS *****/
	@Id
	private final String id;
	
	/***** VARIABLES *****/
	private String name;
	
	
	/***** CONSTRUCTOR *****/
	public HelloWorldDocument() {
		this.id = null;
	}
	public HelloWorldDocument( String name ) {
		this.id = null;
		this.name = name;
	}
	public HelloWorldDocument( String id, String name ) {
		this.id = id;
		this.name = name;
	}
	
	
	/***** GETTER/SETTER *****/
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName( String name ) {
		this.name = name;
	}
	
	
}
