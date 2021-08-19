package com.sapient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}