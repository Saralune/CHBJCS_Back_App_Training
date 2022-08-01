package com.example.apitrainings.web;


import com.example.apitrainings.Entities.Training;
import com.example.apitrainings.service.ImplTrainingService;
import com.example.apitrainings.Exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TrainingController {

    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTrainings() {
        return implTrainingService.getTrainings();
    }

    @PostMapping("/trainings")
    public Training saveTraining(@RequestBody Training t) {
        return implTrainingService.saveTraining(t);
    }

    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable("id") Long id) {
        implTrainingService.deleteTraining(id);
    }

    @GetMapping("/trainings/{id}")
    public Training getTrainingById(@PathVariable("id") Long id) {
        return implTrainingService.readTraining(id)
                .orElseThrow(() -> new RecordNotFoundException("Id de formation" + id + " n'existe pas"));
    }

    @GetMapping("/trainings/category/{name}")
    public List<Training> getTrainingsByCategoryName(@PathVariable("name") String name) {
        return implTrainingService.readTrainingsByCategoryName(name);
    }

    @GetMapping("/trainings/category/{id}")
    public List<Training> getTrainingsByCategoryId(@PathVariable("id") Long id) {
        return implTrainingService.readTrainingsByCategoryId(id);
    }
}
