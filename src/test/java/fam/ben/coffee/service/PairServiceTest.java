package fam.ben.coffee.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fam.ben.coffee.model.coffee.Pair;
import fam.ben.coffee.model.coffee.Person;
import fam.ben.coffee.repository.coffee.PairRepository;
import fam.ben.coffee.repository.coffee.PersonRepository;
import fam.ben.coffee.service.coffee.PairService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig
public class PairServiceTest {

    @MockBean
    private PairRepository pairRepository;
    @MockBean
    private PersonRepository personRepository;
    private PairService pairService;

    private Person p1 = new Person("Slavko", "Slavko");
    private Person p2 = new Person("Mirko", "Mirko");
    private Person p3 = new Person("Zdeslav", "Zdeslav");
    private Person p4 = new Person("Boris", "Boris");
    private Person p5 = new Person("Zorica", "Boris");
    private Person p6 = new Person("Krunoslav", "Boris");
    private List<Pair> pairs;
    private List<Person> persons;

    @BeforeEach
    void setUp() {
        persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
    }

    @Test
    @DisplayName("GIVEN pairRepository and PersonRepository" + "WHEN there are some pairs create " + "THEN create new pairs that doesn't exist")
    void createPairsThatDoesntExist() {
        pairs = new ArrayList<>();
        pairs.add(new Pair(p1, p2, LocalDate.now()));
        pairs.add(new Pair(p3, p4, LocalDate.now()));

        Mockito.when(pairRepository.findAll()).thenReturn(pairs);
        Mockito.when(personRepository.findAll()).thenReturn(persons);

        pairService = new PairService(pairRepository, personRepository);
        List<Pair> newPairs = pairService.createNewPairs(LocalDate.now());
        assertFalse(newPairs.contains(new Pair(p1, p2, LocalDate.now())));
        assertFalse(newPairs.contains(new Pair(p3, p4, LocalDate.now())));
    }

    @Test
    @DisplayName("GIVEN two persons in repository" + "WHEN no pairs created" + "THEN create pair")
    void createPairFromFourPersons() {
        pairs = new ArrayList<>();
        Mockito.when(pairRepository.findAll()).thenReturn(pairs);
        Mockito.when(personRepository.findAll()).thenReturn(persons);

        pairService = new PairService(pairRepository, personRepository);
        assertEquals(pairService.createNewPairs(LocalDate.now()).size(), 2);
    }

    @Test
    @DisplayName("GIVEN persons and pairs that already been" +
                   "WHEN persons order is such that last two had been on coffee" +
                   "THEN create new pairs with all persons")
    void lastTwoPersonHadAlreadyBeenOnCoffee() {
        pairs = new ArrayList<>();
        persons.add(p5);
        persons.add(p6);

        pairs.add(new Pair(p5, p6, LocalDate.now()));
        pairs.add(new Pair(p1, p3, LocalDate.now()));
        pairs.add(new Pair(p2, p4, LocalDate.now()));

        Mockito.when(pairRepository.findAll()).thenReturn(pairs);
        Mockito.when(personRepository.findAll()).thenReturn(persons);
        pairService = new PairService(pairRepository, personRepository);
        assertEquals(pairService.createNewPairs(LocalDate.now()).size(), 3);

    }

}
