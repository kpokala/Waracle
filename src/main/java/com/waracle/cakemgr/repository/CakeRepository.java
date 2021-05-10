package com.waracle.cakemgr.repository;

import com.waracle.cakemgr.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CakeRepository extends JpaRepository<Cake, Long> {

    @Query("SELECT a FROM Cake a WHERE a.clientName = (:clientName)")
    Cake findByClientName(String clientName);

}