package fam.ben.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fam.ben.coffee.model.Guest;
import fam.ben.coffee.service.ReservationService;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final ReservationService reservationService;

    @Autowired
    public GuestController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public String getGuests(Model model){
        List<Guest> guests = this.reservationService.getHotelGuests();
        model.addAttribute("guests",guests);
        return "guests";
    }
}
