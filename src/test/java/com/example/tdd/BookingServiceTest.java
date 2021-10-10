package com.example.tdd;

import com.example.tdd.Models.Booking;
import com.example.tdd.Repositoty.BookingRepository;
import com.example.tdd.Service.BookingService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration{

      @Bean
       public  BookingService bookingService(){
           return new BookingService();
       }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void BookingServiceTestDaysCalculator(){
        String name = "Edilson";
        int day     =  bookingService.daysCalculatorWithDataBase(name);
        Assertions.assertEquals(day,10);
    }

    @Before
    public  void setup(){
        LocalDate checkIn  = LocalDate.parse("2020-11-10");
        LocalDate checkOut = LocalDate.parse("2020-11-20");

        Booking booking    = new Booking(1, "Edilson",checkIn,checkOut,2);
        Mockito.when(bookingRepository.findByReserveName(booking.getReserveName()))
                .thenReturn(java.util.Optional.of(booking));
    }
}
