package com.nt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor

public class OrderService {
    private final OrderRepository repo;
    private final EntityManager manager;

    @Transactional
    public List<Orders> produre(int id1, int id2, int id3) {
        return repo.getOrdersByIds(id1, id2, id3);
    }




    public List<Orders> fetchOrdersByIds(int id1, int id2, int id3) {
        StoredProcedureQuery query = manager.createStoredProcedureQuery("getOrdersByIds", Orders.class);
        //register parameters
        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        //set the param values
        query.setParameter(1, id1);
        query.setParameter(2, id2);
        query.setParameter(3, id3);
        //call the plsql &get the result

        return query.getResultList();


    }


}
;