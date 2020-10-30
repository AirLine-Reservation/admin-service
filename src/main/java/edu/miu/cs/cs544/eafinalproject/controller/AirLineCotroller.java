package edu.miu.cs.cs544.eafinalproject.controller;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.service.AirLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airLines")
public class AirLineCotroller {

    @Autowired
    private AirLineService airLineService;

    @GetMapping
    public List<AirLine> getAllAirLines()
    {
        return airLineService.getAllAirLines();
    }

    @PostMapping("/saveAirLine")
    public AirLine saveAirLine(@RequestBody AirLine airLine){
        return airLineService.saveAirLine(airLine);
    }

    @PutMapping("/updateAirLine")
    public AirLine updateAirLine(@RequestBody AirLine airLine){
        return airLineService.updateAirLine(airLine);
    }

    @DeleteMapping("/deleteAirLine/{id}")
    public void deleteAirLine(@PathVariable Integer id){
        airLineService.deleteAirLine(id);
    }

    @GetMapping("/{code}")
    public AirLine getAirLineByCode(@PathVariable String code){
        return airLineService.findByCode(code);
    }


}
