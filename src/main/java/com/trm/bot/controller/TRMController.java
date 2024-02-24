package com.trm.bot.controller;

import com.trm.bot.model.TRM;
import com.trm.bot.service.Scrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TRM")
public class TRMController {
    private final Scrapper scrapper;
    @Autowired
    public TRMController(Scrapper scrapper){
        this.scrapper = scrapper;
    }
    @GetMapping
    public TRM getTrm(){
        return scrapper.getCurrentExchange();
    }
}
