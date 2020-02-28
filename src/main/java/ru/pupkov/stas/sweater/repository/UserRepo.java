package ru.pupkov.stas.sweater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pupkov.stas.sweater.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
