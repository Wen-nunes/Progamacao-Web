package com.example.projetoarduino.controller;

import com.example.projetoarduino.conexao.ControlePorta;
import com.example.projetoarduino.model.Status;
import com.example.projetoarduino.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;
    ControlePorta controle = new ControlePorta("COM4", 9600);

    @GetMapping("/on")
    public String saveLigado() {

        controle.enviaDados('1');
        Status estado = new Status();
        estado.setEstado(true);
        estado.setData(LocalDateTime.now());
        statusRepository.save(estado);
        return "redirect:/";
    }

    @GetMapping("/off")
    public String saveDesligado() {
        controle.enviaDados('2');
        Status estado = new Status();
        estado.setEstado(false);
        estado.setData(LocalDateTime.now());
        statusRepository.save(estado);
        return "redirect:/";
    }

//    @GetMapping("/lista")
//    public List<Status> getAll() {
//        statusRepository.findAll();
//        return "redirect:/";
//    }
}
