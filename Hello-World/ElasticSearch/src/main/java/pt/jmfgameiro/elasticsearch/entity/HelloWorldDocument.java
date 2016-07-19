package pt.jmfgameiro.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "helloworlds", type = "helloworld" )
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
