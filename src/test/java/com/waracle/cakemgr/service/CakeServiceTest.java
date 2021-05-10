package com.waracle.cakemgr.service;

import com.waracle.cakemgr.Cake;
import com.waracle.cakemgr.repository.CakeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CakeServiceTest {
    @InjectMocks
    CakeService cakeService;
    @Mock
    CakeRepository cakeRepository;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(cakeService);
        cakeService = new CakeService(cakeRepository);
    }

    @Test
    void findAll() {
        List<Cake> cakeList = new ArrayList();
        cakeList.add(new Cake(1233,"Jones","Choclate Cake"));
        cakeList.add(new Cake(1234,"Smiht","Vanilla Cake"));

        when(cakeRepository.findAll()).thenReturn(cakeList);
        Assert.assertEquals(2, cakeService.findAll().size());
    }

    @Test
    void findByClientName() {
        Cake cake = new Cake(1233,"Jones","Choclate Cake");
        when(cakeRepository.findByClientName(any())).thenReturn(cake);
        Assert.assertEquals(12333, cakeService.findByClientName("Jones").getCakeId());

    }

    @Test
    void create() {
        Cake cake = new Cake(1233,"Jones","Choclate Cake");
        when(cakeRepository.save(any())).thenReturn(cake);
        Assert.assertEquals(12333, cakeService.create(any()).getCakeId());
    }
}
