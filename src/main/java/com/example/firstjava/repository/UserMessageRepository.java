package com.example.firstjava.repository;

import com.example.firstjava.entity.UserMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessageEntity, Long> {

    @Query(value = "SELECT * FROM user_messages AS um WHERE um.id = :id", nativeQuery = true)
    Optional<UserMessageEntity> getMsgFromId(@Param("id") long id);
}
