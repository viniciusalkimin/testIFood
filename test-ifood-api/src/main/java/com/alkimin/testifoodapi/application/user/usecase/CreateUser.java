package com.alkimin.testifoodapi.application.user.usecase;

import com.alkimin.testifoodapi.infrastructure.user.dto.UserCreatedRecord;
import com.alkimin.testifoodapi.application.user.service.UserService;
import com.alkimin.testifoodapi.application.user.dto.UserCreationRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUser {

    private UserService userService;

    public UserCreatedRecord createUser(UserCreationRecord userCreationRecord) {
        return userService.createUser(userCreationRecord);
    }
}
