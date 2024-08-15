package com.syscode.saas_erp.services;

import com.syscode.saas_erp.exceptions.ObjectNotFoundException;
import com.syscode.saas_erp.models.User;
import com.syscode.saas_erp.repositories.UserRepository;
import com.syscode.saas_erp.utils.GenerateUuids;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User getByUuid(String uuid) {
    return userRepository.findByUuid(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("User not found - UUID: " + uuid));
  }

  public List<User> getAllUsers(Pageable pageable) {
    return userRepository.findAll(pageable).toList();
  }

  public User create(User user) {
    user.setId(null);
    user.setUuid(GenerateUuids.genUuid13());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public User update(User user) {
    return userRepository.save(user);
  }

  public void delete(String uuid) {
    User user = getByUuid(uuid);
    userRepository.delete(user);
  }

}
