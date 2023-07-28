package com.quantum.aero.repositories;

import com.quantum.aero.domain.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {
}
