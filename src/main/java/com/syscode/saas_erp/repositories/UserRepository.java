package com.syscode.saas_erp.repositories;

import com.syscode.saas_erp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUuid(String uuid);
  UserDetails findByEmail(String email);

}
