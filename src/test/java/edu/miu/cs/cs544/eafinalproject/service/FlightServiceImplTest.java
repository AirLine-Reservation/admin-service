package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.controller.FlightController;
import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.AirPort;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;
import edu.miu.cs.cs544.eafinalproject.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class FlightServiceImplTest {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightController flightController;

    @MockBean
    private FlightRepository flightRepository;

    private Flight flight;
    private Flight flight1;

    @BeforeEach
    public void setUp(){
      AirPort airPort = new AirPort();
      airPort.setCode("ETL");
      AirPort airPort1 = new AirPort();
      airPort1.setCode("ETL");
      this.flight = new Flight(1,new AirLine(),new AirPort(),new AirPort(), "1234",200,400.0, new Date(),new Date(),new Date(), new Date());
      this.flight1 = new Flight(2,new AirLine(),new AirPort(),new AirPort(), "4356",300,400.0, new Date(),new Date(),new Date(), new Date());;
    }

    @Test
    void getAllFlights() {
        when(flightRepository.findAll()).thenReturn(Stream.of(flight, flight1).collect(Collectors.toList()));
        assertEquals(2, flightService.getAllFlights().size());
    }

    @Test
    void saveFlight() {
        when(flightRepository.save(Mockito.any(Flight.class))).thenReturn(this.flight);
        assertEquals(this.flight, flightService.saveFlight(this.flight));
    }

    @Test
    void deleteFLight() {
        flightService.deleteFLight(this.flight.getId());
        Mockito.verify(flightRepository, times(1)).deleteById(this.flight.getId());
    }

    @Test
    void updateFlight() {
        when(flightRepository.save(flight)).thenReturn(flight);
        flight.setCapacity(350);
        assertEquals(flight, flightService.updateFlight(flight));
    }

    @Test
    void findByOriginCode() {
        when(flightRepository.findAllByOriginCode("ETL")).
                thenReturn(Stream.of(flight, flight1).collect(Collectors.toList()));
        assertEquals(2, flightService.findAllByOriginCode("ETL").size());
    }
}