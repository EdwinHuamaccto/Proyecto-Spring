package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
