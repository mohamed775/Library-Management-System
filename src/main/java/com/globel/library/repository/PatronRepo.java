package com.globel.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globel.library.entity.Patron;

@Repository
public interface PatronRepo extends JpaRepository<Patron,Long> {

}
