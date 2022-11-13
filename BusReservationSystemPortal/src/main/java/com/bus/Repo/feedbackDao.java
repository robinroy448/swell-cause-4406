package com.bus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.bean.Feedback;

@Repository
public interface feedbackDao extends JpaRepository<Feedback, Integer>{

}
