package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;
import edu.miu.cs.cs544.eafinalproject.repository.AirLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AirLineServiceImpl implements AirLineService{

    @Autowired
    private AirLineRepository airLineRepository;

    @Override
    public List<AirLine> getAllAirLines() {
        return airLineRepository.findAll();
    }

    @Override
    public AirLine saveAirLine(AirLine airLine) {
        return airLineRepository.save(airLine);
    }

    @Override
    public void deleteAirLine(Integer id) {
          airLineRepository.deleteById(id);
    }

    @Override
    public AirLine updateAirLine(AirLine airLine) {
        return airLineRepository.save(airLine);
    }

    @Override
    public AirLine findByCode(String code) {
        return airLineRepository.findByCode(code);
    }

//    @Override
//    public List<Flight> findAllByOriginCode(String code) {
//        return airLineRepository.findAllByOriginCode(code);
//    }
}
