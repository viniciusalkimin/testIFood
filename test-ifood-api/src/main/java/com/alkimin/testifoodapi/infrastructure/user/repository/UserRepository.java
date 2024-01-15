package com.alkimin.testifoodapi.infrastructure.user.repository;

import com.alkimin.testifoodapi.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
