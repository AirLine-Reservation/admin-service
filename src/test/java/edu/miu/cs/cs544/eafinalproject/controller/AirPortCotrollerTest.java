package edu.miu.cs.cs544.eafinalproject.controller;

import edu.miu.cs.cs544.eafinalproject.domain.Address;
import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.AirPort;
import edu.miu.cs.cs544.eafinalproject.repository.AirPortRepository;
import edu.miu.cs.cs544.eafinalproject.service.AirPortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class AirPortCotrollerTest {

    @Autowired
    private AirPortService airPortService;

    @Autowired
    private AirPortCotroller airPortCotroller;

    @MockBean
    private AirPortRepository airPortRepository;
    private AirPort airPort;
    private AirPort airPort1;

    @BeforeEach
    public void setUp(){
        this.airPort = new AirPort(1,"ETL","Ethiopian Airline", new Address());
        this.airPort1 = new AirPort(2,"UAE","United Emirate", new Address());
    }

    @Test
    void getAllAirPotrs() {
        when(airPortRepository.findAll()).
                thenReturn(Stream.of(this.airPort, this.airPort1).collect(Collectors.toList()));
        assertEquals(2, airPortService.getAllAirPort().size());
    }

    @Test
    void saveAirPort() {

            when(airPortRepository.save(Mockito.any(AirPort.class))).thenReturn(this.airPort);
            assertEquals(airPort, airPortService.saveAirPort(this.airPort));
    }

    @Test
    void updateAirLine() {

        when(airPortRepository.save(airPort)).thenReturn(airPort);
        airPort.setCode("ETR");
        assertEquals(airPort, airPortService.updateAirPort(airPort));
    }

    @Test
    void deleteAirPort() {
        //final AirPort airPort = new AirPort(1,"ETL","Ethiopian Airline", new Address());

        // when
        airPortService.deleteAirPort(1);

        // then
        Mockito.verify(airPortRepository, times(1)).deleteById(airPort.getId());
    }

    @Test
    void getAirPortByCode() {
        when(airPortRepository.findByCode("ETL")).
                thenReturn(airPort);
        assertEquals("Ethiopian Airline", airPortService.findByCode("ETL").getName());
    }
}