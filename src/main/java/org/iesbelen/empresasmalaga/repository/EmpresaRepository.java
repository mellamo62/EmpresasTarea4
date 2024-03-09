package org.iesbelen.empresasmalaga.repository;

import org.iesbelen.empresasmalaga.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {}
