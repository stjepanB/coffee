package fam.ben.coffee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fam.ben.coffee.model.Guest;

public interface GuestRepository extends MongoRepository<Guest,String> {
}
