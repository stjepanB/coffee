package fam.ben.coffee.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("room")
public class Room {

    @Id
    private String id;
    private String name;
    private String number;
    private String badInfo;

    public Room() {
    }

    public Room(final String name, final String number, final String badInfo) {
        this.name = name;
        this.number = number;
        this.badInfo = badInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getBadInfo() {
        return badInfo;
    }

    public void setBadInfo(final String badInfo) {
        this.badInfo = badInfo;
    }

}
