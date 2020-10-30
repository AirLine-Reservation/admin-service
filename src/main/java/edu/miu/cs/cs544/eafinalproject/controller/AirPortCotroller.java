package edu.miu.cs.cs544.eafinalproject.controller;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.AirPort;
import edu.miu.cs.cs544.eafinalproject.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airPorts")
public class AirPortCotroller {

    @Autowired
    private AirPortService airPortService;

    @GetMapping
    public List<AirPort> getAllAirPotrs(){
        return airPortService.getAllAirPort();
    }

    @PostMapping("/saveAirPort")
    public AirPort saveAirPort(@RequestBody AirPort airPort){
        return airPortService.saveAirPort(airPort);
    }

    @PutMapping("/updateAirPort")
    public AirPort updateAirLine(@RequestBody AirPort airPort){
        return airPortService.updateAirPort(airPort);
    }

    @DeleteMapping("/deleteAirPort/{id}")
    public void deleteAirPort(@PathVariable Integer id){
        airPortService.deleteAirPort(id);
    }

    @GetMapping("/{code}")
    public AirPort getAirPortByCode(@PathVariable String code){
        return airPortService.findByCode(code);
    }
}
