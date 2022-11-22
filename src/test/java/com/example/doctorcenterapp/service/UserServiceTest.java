//package com.example.doctorcenterapp.service;
//
//import com.example.doctorcenterapp.model.User;
//import com.example.doctorcenterapp.model.dto.UserDto;
//import com.example.doctorcenterapp.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//
//class UserServiceTest {
//    @Mock
//    UserRepository userRepository;
//    @InjectMocks
//    UserService sut;
//
//    private UserDto userDto;
//    private User user;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        userDto = new UserDto("vlkefmvlk", "ekmd;ckme","ekldmvck", "klfmcwdlkmc", "cknsmdklmc", "cklmsd/lk");
//        user = new User("vlkefmvlk", "ekmd;ckme","ekldmvck", "klfmcwdlkmc", "cknsmdklmc", "cklmsd/lk", "cklmsd/lk", true);
//    }
//
//    @Test
//    void testGetUserByEmail() {
//        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
//
//        UserDto result = sut.getUserByEmail("ekmd;ckme");
//
//        Assertions.assertEquals(userDto, result);
//    }
//
//    @Test
//    void testRemoveUser() {
//        sut.removeUser("vlkefmvlk");
//    }
//}