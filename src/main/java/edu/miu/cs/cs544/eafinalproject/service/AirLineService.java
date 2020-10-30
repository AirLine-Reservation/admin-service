package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.AirPort;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;

import java.util.List;

public interface AirLineService {
    public List<AirLine> getAllAirLines();
    public AirLine saveAirLine(AirLine airLine);
    public void deleteAirLine(Integer id);
    public AirLine updateAirLine(AirLine airLine);
    public AirLine findByCode(String code);
    //public List<Flight> findAllByOriginCode(String code);

}
