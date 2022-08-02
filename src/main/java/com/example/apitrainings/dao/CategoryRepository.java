package com.example.apitrainings.dao;

import com.example.apitrainings.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("*")
//@RepositoryRestResource
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

   // public Category findByName(String catName);
}
