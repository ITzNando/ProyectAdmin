package com.example.proyect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyect.repository.ICiclistaDAO;
import com.example.proyect.service.CiclistaService;

@Service
public class CiclistaServiceimpl implements CiclistaService{


    @Autowired
    private ICiclistaDAO ciclistaDAO;

	

   
}
