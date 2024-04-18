package com.globel.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globel.library.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
