package com.example.tdd.Repositoty;

import com.example.tdd.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByReserveName(String Name);
}
