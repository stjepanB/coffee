package fam.ben.coffee.model.coffee;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pair")
public class Pair {

    @Id
    private String id;
    private Person person1;
    private Person person2;
    private LocalDate date;

    public Pair() {
    }

    public Pair(final Person person1, final Person person2, LocalDate date) {
        this.person1 = person1;
        this.person2 = person2;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Pair pair = (Pair) o;
        return person1.equals(pair.person1) && person2.equals(pair.person2) || person1.equals(pair.person2) && person2.equals(pair.person1);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person1, person2);
    }

    public Person getPearson1() {
        return person1;
    }

    public String getPerson1Name() {return person1.toString();}

    public void setPearson1(final Person person1) {
        this.person1 = person1;
    }

    public Person getPearson2() {
        return person2;
    }

    public String getPerson2Name() {
        return person2.toString();
    }

    public void setPerson2(final Person person2) {
        this.person2 = person2;
    }

    @Override
    public String toString() {
        return "Pair{" + person1.toString() + ", " + person2.toString() + '}';
    }

}
