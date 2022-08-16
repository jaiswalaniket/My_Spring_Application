package com.springboot.service;

import com.springboot.dto.UserDto;
import com.springboot.model.Address;
import com.springboot.model.UserTable;
import com.springboot.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	public UserRepository userRepository;

    @Spy //implementation m jakar uska use krega
    public ModelMapper modelMapper  ;
    @InjectMocks
	public UserService userService;

	@BeforeEach
    void setUp()
    {
//        this.userService
//            = new UserService(this.userRepository);

    }
	@Test
    void getAllPerson()
    {
    	userService.getAllPerson();
        verify(userRepository).findAll();
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

        when(userRepository.save(Mockito.any())).thenReturn(userTableDataSet());
        UserDto userDtos = userService.createUser(userTable);



        assertEquals(userTable.getUserName(),userDtos.getUserName());

        assertEquals(userTable.getSalary(),userDtos.getSalary());
        assertNotNull(userDtos.getAddresses().get(0).getAddressLine1());

    }

    UserTable userTableDataSet(){
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
        userTable.setAddresses(Arrays.asList(address)); //user is map to address
        return userTable;

    }


}
