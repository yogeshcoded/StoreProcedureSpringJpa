package com.nt;

import jakarta.persistence.*;
import lombok.Data;




@Entity
@Data
@NamedStoredProcedureQuery(
        name = "getOrdersByIds",
        procedureName = "getOrdersByIds",
        parameters = {
        @StoredProcedureParameter(name = "id1", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "id2", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "id3", type = Integer.class, mode = ParameterMode.IN),
})
public class Orders {
    @Id
    @GeneratedValue
    private Integer orderId;
    private Integer amountPaid;
    private String username;
    private String orderStatus;
    private String paymentId;
    private String transactionId;

}
