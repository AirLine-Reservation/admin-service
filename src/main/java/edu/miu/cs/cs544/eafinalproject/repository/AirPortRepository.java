package edu.miu.cs.cs544.eafinalproject.repository;

import edu.miu.cs.cs544.eafinalproject.domain.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirPortRepository extends JpaRepository<AirPort, Integer> {
    public AirPort findByCode(String code);
}
