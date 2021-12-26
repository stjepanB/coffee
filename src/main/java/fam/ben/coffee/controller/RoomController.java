package fam.ben.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fam.ben.coffee.model.Room;
import fam.ben.coffee.repository.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public Iterable<Room> getRooms() {
        return this.roomRepository.findAll();
    }

}
