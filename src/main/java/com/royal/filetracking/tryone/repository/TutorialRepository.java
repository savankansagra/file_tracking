package com.royal.filetracking.tryone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.tryone.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	
}
