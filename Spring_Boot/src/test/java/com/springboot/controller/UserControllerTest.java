package com.springboot.controller;

import com.springboot.dto.UserDto;
import com.springboot.model.Address;
import com.springboot.model.UserTable;
import com.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService service ;//Dummy Object

    @InjectMocks
    private UserController controller;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); //if we are using junit 4 ,we will use openMocks
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllUsersAPI() throws Exception {
        UserTable userTable = new UserTable();
        Address address = new Address();
        userTable.setId(1);
        userTable.setUserName("Sonu");
        userTable.setLatitude("1234");
        userTable.setLongitude("4321");
        userTable.setSalary("7890");
        address.setAddressId(2);
        address.setType("Permanent");
        address.setAddressLine1("Noida");
        address.setAddressLine2("Noida2");
        address.setCity("Noida");
        address.setCountry("India");
        address.setPincode("12345");
        userTable.setAddresses(Arrays.asList(address));

        List<UserTable> userTableSet = new ArrayList<>();
        userTableSet.add(userTable);
        when(service.getAllPerson()).thenReturn(userTableSet);
        ResponseEntity<?> tResponseEntity = controller.getAllPersons();
        assertEquals(HttpStatus.OK, tResponseEntity.getStatusCode());
    }
    @Test
    public void test_create_user_success() throws Exception {

        UserDto userTable = new UserDto();
        Address address = new Address();
        userTable.setId(1);
        userTable.setUserName("Sonu");
        userTable.setLatitude("1234");
        userTable.setLongitude("4321");
        userTable.setSalary("7890");
        address.setAddressId(2);
        address.setType("Permanent");
        address.setAddressLine1("Noida");
        address.setAddressLine2("Noida2");
        address.setCity("Noida");
        address.setCountry("India");
        address.setPincode("12345");
        userTable.setAddresses(Arrays.asList(address)); //user is map to address

        when(service.createUser(Mockito.any())).thenReturn(userTable);

        ResponseEntity<UserDto> userDtos= controller.createUser(userTable);

        assertEquals(HttpStatus.CREATED, userDtos.getStatusCode());

        assertEquals(userTable.getUserName(),userDtos.getBody().getUserName());

        assertEquals(userTable.getSalary(),userDtos.getBody().getSalary());
        assertNotNull(userDtos.getBody().getAddresses().get(0).getAddressLine1());

    }

//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}