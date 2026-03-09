package com.capgemini.propertybooking.service;

import com.capgemini.propertybooking.dto.ProfileUpdateRequestDto;
import com.capgemini.propertybooking.dto.UserDto;
import org.apache.catalina.User;

public interface UserService {
    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
