package com.springbootexample.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootexample.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	Optional<Book> findByBId(int bId);
	Optional<Book> findByBName(String bName);

}
