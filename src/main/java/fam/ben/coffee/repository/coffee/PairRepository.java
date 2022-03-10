package fam.ben.coffee.repository.coffee;

import org.springframework.data.mongodb.repository.MongoRepository;

import fam.ben.coffee.model.coffee.Pair;

public interface PairRepository extends MongoRepository<Pair,String> {}
