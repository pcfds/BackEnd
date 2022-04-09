package com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl;

import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Adress;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.IDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AdressService  {
    private IDao<Adress> adressDao;

    /*public AdressService(IDao<Adress> adressDao) {
        this.adressDao = adressDao;
    }*/

    public Adress register(Adress adress){
        adressDao.register(adress);
        return adress;
    }

    public Adress findById(Integer id){
        return adressDao.findById(id);
    }

    public List<Adress> findAll(){
        return adressDao.findAll();
    }

    public void delete(Integer id){
        adressDao.delete(id);
    }
}
