package com.example.demo.repository;

import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 10/04/2018.
 */
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
