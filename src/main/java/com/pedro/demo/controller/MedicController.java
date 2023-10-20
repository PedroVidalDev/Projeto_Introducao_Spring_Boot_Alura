package com.pedro.demo.controller;

import com.pedro.demo.medic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medics")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterMedic data){
        repository.save(new Medic(data));
    }

    @GetMapping
    public Page<MedicGetDataOutput> read(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByLativoTrue(paginacao).map(MedicGetDataOutput::new);
    }

    @PutMapping
    @Transactional
    public void editMedic(@RequestBody @Valid DataEditMedic data){
        var medic = repository.getReferenceById(data.id());
        medic.actualizeData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        medic.actualizeLativo();
    }
}
