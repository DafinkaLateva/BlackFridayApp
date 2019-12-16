package org.didi.BlackFridayApp.db.finder;

import org.didi.BlackFridayApp.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFinder extends JpaRepository<Product, Integer> {

}
