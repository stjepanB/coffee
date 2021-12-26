package fam.ben.coffee.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fam.ben.coffee.model.Guest;
import fam.ben.coffee.model.Reservation;
import fam.ben.coffee.model.Room;
import fam.ben.coffee.repository.GuestRepository;
import fam.ben.coffee.repository.ReservationRepository;
import fam.ben.coffee.repository.RoomRepository;
import fam.ben.coffee.service.domain.RoomReservation;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(final RoomRepository roomRepository, final GuestRepository guestRepository, final ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsByDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<String, RoomReservation> roomReservationMap = new HashMap<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());

            roomReservationMap.put(room.getId(), roomReservation);
        });

        Iterable<Reservation> reservations =
          this.reservationRepository.findAllByDate(new java.sql.Date(date.getTime()));

        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);

            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getId());
        });

        List<RoomReservation> roomReservationList = new ArrayList<>();
        for(String id: roomReservationMap.keySet()) {
            roomReservationList.add(roomReservationMap.get(id));
        }

        roomReservationList.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(
              RoomReservation o1,
              RoomReservation o2) {
                if (o1.getRoomName() == o2.getRoomName()) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });

        return roomReservationList;
    }

    public List<Guest> getHotelGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guests.forEach(guest -> {
            guestList.add(guest);
        });
        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(
              Guest o1,
              Guest o2) {
                if (o1.getLastName() == o2.getLastName()) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return guestList;
    }

}
