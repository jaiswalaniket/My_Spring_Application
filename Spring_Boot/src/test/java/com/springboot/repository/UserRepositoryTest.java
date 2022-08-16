package com.springboot.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.model.UserTable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

    @Test
    void findAll_success() {
        List<UserTable> allUsers = userRepository.findAll();
        assertThat(allUsers.size()).isGreaterThanOrEqualTo(1);
    }

}
