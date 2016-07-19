package pt.jmfgameiro.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import pt.jmfgameiro.elasticsearch.entity.HelloWorldDocument;

public interface HelloWorldRepository extends ElasticsearchRepository< HelloWorldDocument, String > {}
