package edu.miu.cs.cs544.eafinalproject.repository;

import edu.miu.cs.cs544.eafinalproject.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    public List<Flight> findAllByOriginCode(String code);
    public List<Flight> findAllByOriginCodeAndDestinationCodeAndDepartureDate(String originCode, String destinationCode, Date departureDate);
}
