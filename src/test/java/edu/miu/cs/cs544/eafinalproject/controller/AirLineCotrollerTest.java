package edu.miu.cs.cs544.eafinalproject.controller;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.repository.AirLineRepository;
import edu.miu.cs.cs544.eafinalproject.service.AirLineService;
import edu.miu.cs.cs544.eafinalproject.service.AirLineServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AirLineCotrollerTest {

    @Autowired
    private AirLineCotroller airLineCotroller;

    @Autowired
    private AirLineServiceImpl airLineService;

    @MockBean
    private AirLineRepository airLineRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllAirLines() {
        when(airLineRepository.findAll()).
               thenReturn(Stream.of(new AirLine(1,"ET","Ethiopian Airline", "Successful Airline"),
                        new AirLine(2,"UA","United Emirate", "Big Airline")).collect(Collectors.toList()));
        assertEquals(2, airLineService.getAllAirLines().size());
    }

    @Test
    void saveAirLine() {
        AirLine airLine = new AirLine(1,"ET","Ethiopian Airline", "Successful Airline");

        when(airLineRepository.save(Mockito.any(AirLine.class))).thenReturn(airLine);
        assertEquals(airLine, airLineService.saveAirLine(airLine));
    }

    @Test
    void updateAirLine() {
        AirLine airLine = new AirLine(1,"ET","Ethiopian Airline", "Successful Airline");

        when(airLineRepository.save(airLine)).thenReturn(airLine);
        airLine.setCode("RT");
        assertEquals(airLine, airLineService.updateAirLine(airLine));
    }

    @Test
    void deleteAirLine() {
        final AirLine airLine = new AirLine(1,"ET","Ethiopian Airline", "Successful Airline");

        // when
        airLineService.deleteAirLine(1);

        // then
        Mockito.verify(airLineRepository, times(1)).deleteById(airLine.getId());
        //I dont think you need to assert to confirm actual delete as you are testing mock registry. to assert somethink like below you need to return null by mocking the same call again and return the null but thats of no use
        //assertThat(airLineRepository.findById(1).get()).isNull();
    }

    @Test
    void getAirLineByCode() {
        when(airLineRepository.findByCode("ET")).
                thenReturn(new AirLine(1,"ET","Ethiopian Airline", "Successful Airline"));
        assertEquals("Ethiopian Airline", airLineService.findByCode("ET").getName());
    }
}