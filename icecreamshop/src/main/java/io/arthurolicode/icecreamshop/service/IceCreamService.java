package io.arthurolicode.icecreamshop.service;

import io.arthurolicode.icecreamshop.model.IceCream;
import io.arthurolicode.icecreamshop.repository.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IceCreamService {

    @Autowired
    private IceCreamRepository repository;

    @Autowired
    public IceCreamService(IceCreamRepository repository){
        this.repository = repository;
    }

    public List<IceCream> lista(){
        return repository.findAll();
    }
}
