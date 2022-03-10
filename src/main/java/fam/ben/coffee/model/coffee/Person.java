package fam.ben.coffee.model.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pearson")
public class Person {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<String> hadCoffeeWith;

    public Person() {
    }

    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hadCoffeeWith = new ArrayList<>();
    }

    public void hadCoffeeWithAdd(String pearsonId) {
        this.hadCoffeeWith.add(pearsonId);
    }

    public boolean checkIfHadCoffeeWith(String pearsonId) {
        return this.hadCoffeeWith.contains(pearsonId);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public List<String> getHadCoffeeWith() {
        return hadCoffeeWith;
    }

    public void setHadCoffeeWith(final List<Pair> pairs) {
        pairs
          .stream()
          .filter(p -> p.getPearson1().id.equals(this.id) || p.getPearson2().id.equals(this.id))
          .map(p -> p.getPearson1().getId().equals(this.id) ? p.getPearson2().getId() : p.getPearson1().getId())
          .forEach(this::hadCoffeeWithAdd);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
