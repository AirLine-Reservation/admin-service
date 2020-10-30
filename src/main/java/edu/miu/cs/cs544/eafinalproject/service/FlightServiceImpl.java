package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;
import edu.miu.cs.cs544.eafinalproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFLight(Integer id) {
         flightRepository.deleteById(id);
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAllByOriginCode(String code) {
        return flightRepository.findAllByOriginCode(code);
    }

    @Override
    public List<Flight> findFlightsBetween(String originCode, String destinationCode, Date departureDate) {
        return flightRepository.findAllByOriginCodeAndDestinationCodeAndDepartureDate(originCode,destinationCode,departureDate);
    }

    @Override
    public Flight findById(Integer id) {
        return flightRepository.findById(id).get();
    }

}
