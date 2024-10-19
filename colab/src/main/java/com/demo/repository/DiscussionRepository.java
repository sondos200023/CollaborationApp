package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.*;
@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {

}
