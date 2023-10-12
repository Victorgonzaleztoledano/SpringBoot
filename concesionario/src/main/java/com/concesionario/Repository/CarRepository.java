package com.concesionario.Repository;

import com.concesionario.Domain.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Coche, String> {
}
