package com.nt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    //use procedure name as the method name
    @Procedure
    List<Orders> getOrdersByIds(int id1, int id2, int id3);

    //   Using @Procedure with different method name.
    //	 use attributes to pass procedureName
    @Procedure(procedureName = "getOrdersByIds")
    List<Orders> getOrders(int id1, int id2, int id3);

    //	Using @NamedStoredProcedureQuery annotation
    @Procedure(procedureName = "getOrdersByIds")
    List<Orders> getOrders2(int id1, int id2, int id3);

    //   Using @Query annotation
    @Query(value = "call orders.getOrdersByIds(:id1, :id2, :id3)",nativeQuery = true)
    List<Orders> getOrders3(int id1, int id2, int id3);
}
