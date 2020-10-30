package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.domain.AirPort;

import java.util.List;

public interface AirPortService {
    public List<AirPort> getAllAirPort();
    public AirPort saveAirPort(AirPort airPort);
    public void deleteAirPort(Integer id);
    public AirPort updateAirPort(AirPort airPort);
    public AirPort findByCode(String code);

}
