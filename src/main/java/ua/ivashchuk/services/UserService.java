package ua.ivashchuk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.UserRepository;
import ua.ivashchuk.domains.Role;
import ua.ivashchuk.domains.User;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singleton;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return (UserDetails) user;
    }

    public boolean addUser(User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(singleton(Role.USER));
        userRepository.save(user);
        return true;
    }

    public User findById(Integer id) {
        return userRepository.getById(id);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public void update(User user, Integer id, String[] roles) {
        User userToBeUpdate = findById(id);

        userToBeUpdate.setName(user.getName());

        Set<String> userRoles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        userToBeUpdate.getRoles().clear();


        for (String key : roles) {
            if (userRoles.contains(key)) {
                userToBeUpdate.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(userToBeUpdate);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String name){
        return userRepository.findByName(name);
    }




}
