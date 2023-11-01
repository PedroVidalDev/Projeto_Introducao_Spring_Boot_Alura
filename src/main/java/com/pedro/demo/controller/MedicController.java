package com.pedro.demo.controller;

import com.pedro.demo.domain.medic.*;
import com.pedro.demo.domain.medic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medics")
@SecurityRequirement(name = "bearer-key")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataRegisterMedic data, UriComponentsBuilder uriBuilder){
        Medic medic = new Medic(data);

        repository.save(medic);

        var uri = uriBuilder.path("/medics/{id}").buildAndExpand(medic.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataMedicComplete(medic));
    }

    @GetMapping
    public ResponseEntity<Page<MedicGetDataOutput>> read(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByLativoTrue(paginacao).map(MedicGetDataOutput::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity readOne(@PathVariable Long id){
        var medic = repository.getReferenceById(id);

        return ResponseEntity.ok(new DataMedicComplete(medic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity editMedic(@RequestBody @Valid DataEditMedic data){
        var medic = repository.getReferenceById(data.id());
        medic.actualizeData(data);

        return ResponseEntity.ok(new DataMedicComplete(medic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        medic.actualizeLativo();

        return ResponseEntity.noContent().build();
    }
}
