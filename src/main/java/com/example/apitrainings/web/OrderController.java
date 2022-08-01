package com.example.apitrainings.web;


import com.example.apitrainings.Entities.Customer;
import com.example.apitrainings.Entities.Order;
import com.example.apitrainings.Entities.OrderItem;
import com.example.apitrainings.Entities.Training;
import com.example.apitrainings.dao.CustomerRepository;
import com.example.apitrainings.dao.TrainingRepository;
import com.example.apitrainings.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private ImplTrainingService implTrainingService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/orders")
    public Long saveOrder(@RequestBody Order o) {
        System.out.println(o);
        Customer customer= new Customer();
        customer.setName(o.getCustomer().getName());
        customer.setFirstName(o.getCustomer().getFirstName());
        customer.setAddress(o.getCustomer().getAddress());
        customer.setEmail(o.getCustomer().getEmail());
        customer.setPhone(o.getCustomer().getPhone());
        customerRepository.save(customer);


        Order order=new Order();
        order.setDate(o.getDate());
        order.setAmount((o.getAmount()));
        order.setCustomer(customer);
        order.setOrderItems(o.getOrderItems());
        //Pareil pour order, constructeur vide puis set et pareil pour OrderItems/ avoir les mêmes infos en back et front (noms de variables)

        Order orderReponse= implTrainingService.saveOrder(order);



//Faire un tableau de trainings que je récupère, un autre des orderitems initialisé à null,
// boucler sur le tableau de training, créer un nouveau orderitem et le add à mon tableau vide de orderitem

        Collection<OrderItem> orderItems= o.getOrderItems();
        System.out.println(orderItems);

        for (OrderItem orderItem : orderItems) {
            OrderItem orderItemToAdd = new OrderItem();
            orderItemToAdd.setQuantity(orderItem.getQuantity());
            orderItemToAdd.setPrice(orderItem.getPrice());
            Training training=implTrainingService.readTraining(orderItem.getId()).get();
            orderItemToAdd.setTraining(training);
            orderItemToAdd.setOrder(orderReponse);
            implTrainingService.saveOrderItem(orderItemToAdd);
        }
        return orderReponse.getId();

    }

//    @PostMapping("/orderItem")
//        public OrderItem saveOrderItem(@RequestBody OrderItem oi){return implTrainingService.saveOrderItem(oi);}

    @GetMapping("/orders")
    public List<Order> allOrders() {
        return implTrainingService.getOrders();
    }

    @GetMapping("/orderItem")
        public List<OrderItem> allOrderItems() {
        return implTrainingService.getOrderItems();
    }
}



