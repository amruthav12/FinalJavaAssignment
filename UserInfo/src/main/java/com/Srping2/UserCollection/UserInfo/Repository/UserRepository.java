package com.Srping2.UserCollection.UserInfo.Repository;

import com.Srping2.UserCollection.UserInfo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends JpaRepository <User,Long>{



}
