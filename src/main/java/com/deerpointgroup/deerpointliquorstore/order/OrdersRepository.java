package com.deerpointgroup.deerpointliquorstore.order;

import com.deerpointgroup.deerpointliquorstore.order.Orders;
import com.deerpointgroup.deerpointliquorstore.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

    Optional<Orders> findOrdersByOrderCode(String orderCode);

    List<Orders> findByUserId(Long userID);
}
