package com.concesionario.Repository;

import com.concesionario.Domain.Exposicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpositionRepository extends JpaRepository<Exposicion, Integer> {
}
