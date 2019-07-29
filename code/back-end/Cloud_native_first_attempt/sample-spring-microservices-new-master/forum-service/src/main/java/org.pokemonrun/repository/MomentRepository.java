package org.pokemonrun.repository;

import org.pokemonrun.entity.Moment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MomentRepository extends MongoRepository<Moment,String> {
    List<Moment> findAllByUsername(String username);
}
