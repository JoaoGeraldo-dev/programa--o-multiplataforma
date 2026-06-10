package com.Boca.minha_api.service;

import com.Boca.minha_api.model.Empresa;
import com.Boca.minha_api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> listarTodas() {
        return repository.findAll();
    }

    public Empresa cadastrar(Empresa empresa) {
        return repository.save(empresa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}