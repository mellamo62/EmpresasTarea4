package org.iesbelen.empresasmalaga.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.empresasmalaga.domain.Empresa;
import org.iesbelen.empresasmalaga.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping({"","/"})
    public List<Empresa> all() {
        log.info("Accediendo a todas las empresas");
        return this.empresaService.all();
    }

    @PostMapping({"","/"})
    public Empresa newEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.save(empresa);
    }

    @GetMapping("/{id}")
    public Empresa one(@PathVariable("id") Long id) {
        return this.empresaService.one(id);
    }

}
