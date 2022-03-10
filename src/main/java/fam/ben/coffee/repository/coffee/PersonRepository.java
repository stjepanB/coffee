package fam.ben.coffee.repository.coffee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fam.ben.coffee.model.coffee.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

}
