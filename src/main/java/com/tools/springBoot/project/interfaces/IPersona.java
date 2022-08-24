package com.tools.springBoot.project.interfaces;

import com.tools.springBoot.project.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer> {
}
