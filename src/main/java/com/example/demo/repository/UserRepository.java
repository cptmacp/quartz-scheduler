package com.example.demo.repository;

import com.example.demo.models.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "temp", path = "temp")
public interface UserRepository extends JpaRepository<Temp, Long> {


    List<Temp> findByName(@Param("name") String name);
}
