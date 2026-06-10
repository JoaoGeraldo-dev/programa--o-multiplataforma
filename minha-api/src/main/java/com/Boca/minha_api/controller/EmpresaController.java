package com.Boca.minha_api.controller;

import com.Boca.minha_api.model.Empresa;
import com.Boca.minha_api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public List<Empresa> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Empresa cadastrar(@RequestBody Empresa empresa) {
        return service.cadastrar(empresa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    @RestController
    @RequestMapping("/api")
    public class TesteController {

        @GetMapping("/teste")
        public String teste() {
            return "API funcionando!";
        }
    }
    
}