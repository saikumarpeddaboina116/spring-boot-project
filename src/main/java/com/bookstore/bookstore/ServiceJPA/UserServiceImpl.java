package com.bookstore.bookstore.ServiceJPA;

import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.Exception.MyException;
import com.bookstore.bookstore.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserServiceJPA{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String username) {
        Optional<User> result=userRepository.findById(username);
        User user=null;
        if(result.isPresent())
        {
            user=result.get();
        }

        else {
            // we didn't find the artist
            throw new MyException("Did not find Book with id - " + username);
        }
        return user;
    }
}
