package fam.ben.coffee.service.coffee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fam.ben.coffee.model.coffee.Pair;
import fam.ben.coffee.model.coffee.Person;
import fam.ben.coffee.repository.coffee.PairRepository;
import fam.ben.coffee.repository.coffee.PersonRepository;

@Service
public class PairService {

    PairRepository pairRepository;
    PersonRepository personRepository;

    @Autowired
    public PairService(final PairRepository pairRepository, final PersonRepository personRepository) {
        this.pairRepository = pairRepository;
        this.personRepository = personRepository;
    }

    public List<Pair> getAllPairs() {
        return this.pairRepository.findAll();
    }

    public List<Pair> createNewPairs(LocalDate localDate) {
        List<Pair> oldPairs = this.pairRepository.findAll();
        List<Person> persons = this.personRepository.findAll();
        List<Pair> newPairs = new ArrayList<>();

        while (!persons.isEmpty()) {
            Person person = persons.remove(0);
            Person second = null;
            for (Person next : persons) {
                if (!oldPairs.contains(new Pair(person, next, localDate))) {
                    second = next;
                    break;
                }
            }
            if (second != null) {
                persons.remove(second);
                newPairs.add(new Pair(person, second, localDate));
            } else if (!persons.isEmpty()) {
                for (Pair p : newPairs) {
                    if (!oldPairs.contains(new Pair(p.getPearson1(), person, LocalDate.now()))) {
                        persons.add(p.getPearson2());
                        newPairs.remove(p);
                        newPairs.add(new Pair(p.getPearson1(), person, LocalDate.now()));
                        break;
                    }
                    if (!oldPairs.contains(new Pair(p.getPearson2(), person, LocalDate.now()))) {
                        persons.add(p.getPearson1());
                        newPairs.remove(p);
                        newPairs.add(new Pair(p.getPearson2(), person, LocalDate.now()));
                        break;
                    }
                }
            }
        }
        pairRepository.saveAll(newPairs);
        return newPairs;
    }

}
