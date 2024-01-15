package com.alkimin.testifoodapi.application.user.service;

import com.alkimin.testifoodapi.infrastructure.user.dto.UserCreatedRecord;
import com.alkimin.testifoodapi.application.user.dto.UserCreationRecord;

public interface UserService {

    public UserCreatedRecord createUser(UserCreationRecord user);

}
