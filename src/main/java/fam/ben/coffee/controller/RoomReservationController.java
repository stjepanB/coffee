package fam.ben.coffee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fam.ben.coffee.service.ReservationService;
import fam.ben.coffee.service.domain.RoomReservation;
import fam.ben.coffee.util.DateUtils;

@Controller
@RequestMapping("/room-reservations")
public class RoomReservationController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsByDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "room-reservations";
    }

}
