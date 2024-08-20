package com.Lakkam.Repository;

import com.Lakkam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String username);
}
