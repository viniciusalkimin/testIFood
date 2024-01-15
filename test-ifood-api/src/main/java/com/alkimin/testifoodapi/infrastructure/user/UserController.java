package com.alkimin.testifoodapi.infrastructure.user;

import com.alkimin.testifoodapi.infrastructure.user.dto.UserCreatedRecord;
import com.alkimin.testifoodapi.application.user.usecase.CreateUser;
import com.alkimin.testifoodapi.application.user.dto.UserCreationRecord;
import com.alkimin.testifoodapi.infrastructure.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/users")
public class UserController {

    private CreateUser createUser;

    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserCreatedRecord> create(@RequestBody UserCreationRecord userCreationRecord) {
        return ResponseEntity.ok().body(createUser.createUser(userCreationRecord));
    }
}
