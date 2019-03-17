package br.hackatona.reprograma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.hackatona.reprograma.model.Pull;

@Repository
public interface UserRepository extends CrudRepository<Pull, String> {

}
