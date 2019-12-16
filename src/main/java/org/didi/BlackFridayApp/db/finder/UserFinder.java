package org.didi.BlackFridayApp.db.finder;

import org.didi.BlackFridayApp.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFinder extends JpaRepository<User, Integer> {

}
