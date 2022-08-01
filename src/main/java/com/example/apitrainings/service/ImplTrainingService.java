package com.example.apitrainings.service;

import com.example.apitrainings.Entities.Order;
import com.example.apitrainings.Entities.OrderItem;
import com.example.apitrainings.Entities.Training;
import com.example.apitrainings.dao.OrderItemRepository;
import com.example.apitrainings.dao.OrderRepository;
import com.example.apitrainings.dao.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements ITrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }


    @Override
    public Optional<Training> readTraining(Long id) {
        return trainingRepository.findById(id);
    }

    @Override
    public List<Training> readTrainingsByCategoryId(Long catId) {
        return  trainingRepository.findByCategoryId(catId);
    }

    @Override
    public List<Training> readTrainingsByCategoryName(String name) {
        return null;// trainingRepository.findByCategoryName(name);
    }

    @Override
    public Order saveOrder(Order o) {
        return orderRepository.save(o);
    }

    @Override
    public OrderItem saveOrderItem(OrderItem oi) {
        return orderItemRepository.save(oi);
    }
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }


}
