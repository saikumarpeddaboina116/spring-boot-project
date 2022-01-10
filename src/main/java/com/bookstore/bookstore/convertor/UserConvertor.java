package com.bookstore.bookstore.convertor;

import com.bookstore.bookstore.dto.UserDTO;
import com.bookstore.bookstore.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO entityToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User dtoToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
