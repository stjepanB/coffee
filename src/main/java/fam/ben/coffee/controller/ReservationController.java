package fam.ben.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fam.ben.coffee.model.Reservation;
import fam.ben.coffee.repository.ReservationRepository;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;

    @GetMapping
    public Iterable<Reservation> getReservations() {
        return this.repository.findAll();
    }

}

