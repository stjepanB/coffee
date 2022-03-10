package fam.ben.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import fam.ben.coffee.model.Guest;
import fam.ben.coffee.model.Room;
import fam.ben.coffee.model.coffee.Pair;
import fam.ben.coffee.model.coffee.Person;
import fam.ben.coffee.repository.GuestRepository;
import fam.ben.coffee.repository.ReservationRepository;
import fam.ben.coffee.repository.RoomRepository;
import fam.ben.coffee.repository.coffee.PairRepository;
import fam.ben.coffee.repository.coffee.PersonRepository;
import fam.ben.coffee.util.CreateData;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class CoffeeApplication implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PairRepository pairRepository;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        List<Person> persons = CreateData.createPersons(personRepository);
        List<Pair> pairs = CreateData.createPairsHadCoffee(pairRepository, personRepository);
        persons.forEach(p -> p.setHadCoffeeWith(pairs));
    }

}
