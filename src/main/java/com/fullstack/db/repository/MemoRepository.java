package com.fullstack.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.fullstack.db.entity.Memo;

/*
 * Repository의 기능 메서드
 * insert, update >> save()
 * select >> findbyId(key 타입), getOne(키 타입)
 * delete >> deleteById(key 타입), delete(entity 객체)
 * 
 * */


public interface MemoRepository extends JpaRepository<Memo, Long> {
   
   Page<Memo> findByMnoBetween(Long stIdx, Long endIdx, Pageable pag);
}