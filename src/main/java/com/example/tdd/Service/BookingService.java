package com.example.tdd.Service;

import com.example.tdd.Models.Booking;
import com.example.tdd.Repositoty.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculatorWithDataBase(String name) {
        Optional<Booking> booking = bookingRepository.findByReserveName(name);
        return Period.between(booking.get().getCheckIn(),booking.get().getCheckOut()).getDays();
    }
}
