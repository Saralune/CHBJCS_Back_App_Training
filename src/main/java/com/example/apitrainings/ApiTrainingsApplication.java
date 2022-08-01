package com.example.apitrainings;

import com.example.apitrainings.dao.CategoryRepository;
import com.example.apitrainings.dao.TrainingRepository;
import com.example.apitrainings.downupload.FileUploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileUploadProperties.class})

public class ApiTrainingsApplication implements CommandLineRunner {

@Autowired
private TrainingRepository trainingRepository;

@Autowired
private CategoryRepository categoryRepository;

//    @Qualifier("ICategoryService")
//    @Autowired
//    ICategoryService categoryService;
//
//    @Qualifier("ITrainingService")
//    @Autowired
//    ITrainingService trainingService;



    public static void main(String[] args) {
        SpringApplication.run(ApiTrainingsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //System.out.println(trainingService.readTraining((long)7));

//        Category info=new Category(null, "Formations informatiques");
//        Category other=new Category(null, "Autres formations");
//        categoryRepository.save(info);
//        categoryRepository.save(other);
//
//        trainingRepository.save(new Training(null, "Java", "Java Standard Edition 8 sur 5 jours",3500, 1, info));
//        trainingRepository.save(new Training(null, "DoNet", "DoNet et EntityFramework en 5 jours", 2750,1,info));
//        trainingRepository.save(new Training(null, "PowerBi", "Business Intelligence en 5 jours", 3000, 1,info));
//        trainingRepository.save(new Training(null, "NodeJS", "Prise en main express de NOde JS /2 jours", 1400,1,info));
//        trainingRepository.save(new Training(null, "PHP", "Initiation dév PHP 4 jours", 1300,1,info));
//        trainingRepository.save((new Training(null, "Python", "Formation Python 10 jours", 4000,1,info)));
//        trainingRepository.save(new Training(null, "Srum","Formation 15 jours", 3000,1,other));
//        trainingRepository.save(new Training(null, "Management des RH", "Formation 10 jours", 2500,1, other));
    }
}
