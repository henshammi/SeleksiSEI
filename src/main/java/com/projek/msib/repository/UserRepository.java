package com.projek.msib.repository;

import org.springframework.data.repository.CrudRepository;

import com.projek.msib.api.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
