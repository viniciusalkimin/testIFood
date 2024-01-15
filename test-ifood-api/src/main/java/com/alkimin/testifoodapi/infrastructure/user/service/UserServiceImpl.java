package com.alkimin.testifoodapi.infrastructure.user.service;

import com.alkimin.testifoodapi.infrastructure.user.dto.UserCreatedRecord;
import com.alkimin.testifoodapi.application.user.service.UserService;
import com.alkimin.testifoodapi.domain.user.User;
import com.alkimin.testifoodapi.application.user.dto.UserCreationRecord;
import com.alkimin.testifoodapi.infrastructure.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserCreatedRecord createUser(UserCreationRecord userCreate) {
        var user = User.builder().name(userCreate.name()).build();
        userRepository.save(user);
        return new UserCreatedRecord(user.getId(), user.getName());
    }
}
