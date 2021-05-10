package com.waracle.cakemgr.service;

import com.waracle.cakemgr.Cake;
import com.waracle.cakemgr.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

@Service("cakeService")
public class CakeService {
    @Autowired
    private final CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<Cake> findAll() {
        List<Cake> cakeList = cakeRepository.findAll();

        return cakeList.stream().collect(Collectors.toList());
    }

    public Cake findByClientName(String clientName) {
        return cakeRepository.findByClientName(clientName);
    }

    public Cake create(Cake cake) {
        return cakeRepository.save(cake);
    }


}
