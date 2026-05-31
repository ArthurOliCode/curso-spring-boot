package io.arthurolicode.icecreamshop.controller;

import io.arthurolicode.icecreamshop.model.IceCream;
import io.arthurolicode.icecreamshop.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iceCreams")
public class IceCreamController {

    @Autowired
    private IceCreamService service;

    @Autowired
    public IceCreamController(IceCreamService service){
        this.service = service;
    }

    @GetMapping
    public List<IceCream> getSorvetes(){
        return service.lista();
    }
}
