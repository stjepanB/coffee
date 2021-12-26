package fam.ben.coffee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fam.ben.coffee.model.Room;

public interface RoomRepository extends MongoRepository<Room,String> {}
