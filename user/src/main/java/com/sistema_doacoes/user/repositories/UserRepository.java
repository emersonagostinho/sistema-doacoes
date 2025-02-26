package com.sistema_doacoes.user.repositories;

import com.sistema_doacoes.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
