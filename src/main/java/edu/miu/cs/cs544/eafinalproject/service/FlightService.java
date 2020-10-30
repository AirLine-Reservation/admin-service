package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    public List<Flight> getAllFlights();
    public Flight saveFlight(Flight flight);
    public void deleteFLight(Integer id);
    public Flight updateFlight(Flight flight);
    public List<Flight> findAllByOriginCode(String code);
    public List<Flight> findFlightsBetween(String originCode, String destinationCode, Date departureDate);
    public Flight findById(Integer id);
}
