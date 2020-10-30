package edu.miu.cs.cs544.eafinalproject.controller;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;
import edu.miu.cs.cs544.eafinalproject.repository.AirLineRepository;
import edu.miu.cs.cs544.eafinalproject.repository.FlightRepository;
import edu.miu.cs.cs544.eafinalproject.service.FlightService;
import edu.miu.cs.cs544.eafinalproject.service.response.AirLineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @PostMapping("/saveFlight")
    public Flight saveFlight(@RequestBody Flight flight){
        return flightService.saveFlight(flight);
    }

    @PutMapping("/updateFlight")
    public Flight updateAirLine(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public void deleteFlight(@PathVariable Integer id){
        flightService.deleteFLight(id);
    }

    @GetMapping("/from/{origin}/to/{destination}/on/{departureDate}")
    public List<Flight> getAllFlightsBetween(@PathVariable String origin, @PathVariable String destination, @PathVariable String departureDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(departureDate);
        //Date date1 = new SimpleDateFormat("MM dd, yyyy").parse(date.toString());
        return flightService.findFlightsBetween(origin, destination, date);
    }

    @GetMapping("/{airportCode}/airlines")
    public List<AirLineResponse> findAllByOriginCode(@PathVariable String airportCode) {
       return flightService.findAllByOriginCode(airportCode).stream().
                           map(this::mapAirLineResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Flight findById(@PathVariable Integer id){
        return flightService.findById(id);
    }

    public AirLineResponse mapAirLineResponse(Flight flight){
       return  new AirLineResponse(flight.getAirLine().getId(), flight.getAirLine().getCode(),
               flight.getAirLine().getName(),flight.getAirLine().getHistory());
    }

}
