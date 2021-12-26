package fam.ben.coffee.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import fam.ben.coffee.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

    Iterable<Reservation> findAllByDate(Date date);

}
