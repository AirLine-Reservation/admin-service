package edu.miu.cs.cs544.eafinalproject.service;

import edu.miu.cs.cs544.eafinalproject.domain.AirPort;
import edu.miu.cs.cs544.eafinalproject.repository.AirPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AirPortServiceImpl implements AirPortService{

    @Autowired
    private AirPortRepository airPortRepository;

    @Override
    public List<AirPort> getAllAirPort() {
        return airPortRepository.findAll();
    }

    @Override
    public AirPort saveAirPort(AirPort airPort) {
        return airPortRepository.save(airPort);
    }

    @Override
    public void deleteAirPort(Integer id) {
       airPortRepository.deleteById(id);
    }

    @Override
    public AirPort updateAirPort(AirPort airPort) {
        return airPortRepository.save(airPort);
    }

    @Override
    public AirPort findByCode(String code) {
        return airPortRepository.findByCode(code);
    }
}
