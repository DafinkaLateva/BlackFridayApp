package org.didi.BlackFridayApp.db.finder;

import org.didi.BlackFridayApp.db.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFinder extends JpaRepository<Order, Integer> {

}
