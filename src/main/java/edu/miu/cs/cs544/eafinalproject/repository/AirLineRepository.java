package edu.miu.cs.cs544.eafinalproject.repository;

import edu.miu.cs.cs544.eafinalproject.domain.AirLine;
import edu.miu.cs.cs544.eafinalproject.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirLineRepository extends JpaRepository<AirLine, Integer> {
    public AirLine findByCode(String code);
}
