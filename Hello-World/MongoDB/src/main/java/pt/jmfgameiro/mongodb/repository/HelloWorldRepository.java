package pt.jmfgameiro.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.jmfgameiro.mongodb.entity.HelloWorldDocument;

public interface HelloWorldRepository extends MongoRepository< HelloWorldDocument, String > {}
