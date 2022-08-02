package com.example.apitrainings.dao;

import com.example.apitrainings.Entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin
//@CrossOrigin("*")
//@RepositoryRestResource
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByCategoryId(Long catId);

    //List<Training> findByCategoryName(String name);

    // public Training findByName(String name);
}
