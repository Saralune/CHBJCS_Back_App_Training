package com.example.apitrainings.service;

import com.example.apitrainings.Entities.Category;
import com.example.apitrainings.Entities.Order;
import com.example.apitrainings.Entities.OrderItem;
import com.example.apitrainings.Entities.Training;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface ITrainingService {

    public List<Training> getTrainings();

    Training saveTraining(Training training);

    void deleteTraining(Long id);

    Optional<Training> readTraining(Long id);

    List<Training> readTrainingsByCategoryId(Long catId);

    List<Training> readTrainingsByCategoryName (String name);

    Order saveOrder(Order o);

    OrderItem saveOrderItem(OrderItem oi);

    List<Order> getOrders();

    List<OrderItem> getOrderItems();

    // category

    public Category getCategoryById (Long catId);

    public Category getCategoryByName (String catName);

    public List<Category> readAllCategories();
}
