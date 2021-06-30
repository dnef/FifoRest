package com.example.fiforest.repository;

import com.example.fiforest.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface ImessegeRepository extends CrudRepository<Message,Integer> {
    @Query("SELECT coalesce(min(mes.id), 0) FROM Message mes")
    Integer showFirstId();
//    @Override
//    Iterable<Message> findAllById(Iterable<Integer> iterable);
//
    @Override
    Optional<Message> findById(Integer integer);

    @Query("SELECT coalesce(max(mes.id), 0) FROM Message mes")
    Integer showMax();

    @Override
    <S extends Message> S save(S message);

    @Override
    void deleteById(Integer integer);

//    @Query("SELECT msg FROM Message ORDER BY id")
//    List<Message> getAll();
    List<Message> findAllByOrderByIdAsc();

}
