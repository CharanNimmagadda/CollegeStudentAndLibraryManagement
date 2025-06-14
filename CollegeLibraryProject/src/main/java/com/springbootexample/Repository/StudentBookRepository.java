package com.springbootexample.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootexample.entity.StudentBook;

import jakarta.transaction.Transactional;



@Repository
public interface StudentBookRepository extends JpaRepository<StudentBook, Integer>{

	Optional<StudentBook> findByBIdAndSIdAndBookStatus(int bId, int sId,String bookStatus);
	
	Optional<StudentBook> findBySId(int sId);
	
	@Modifying
    @Transactional
    @Query("UPDATE StudentBook  SET sBookTakenDate = current_date WHERE sId = :sid and bId=:bid")
	void setBookDate(@Param("sid") int sId,@Param("bid") int bId);
	
	//modifying and Transactional is only for update and delete and insert
	@Modifying
    @Transactional
    @Query("UPDATE StudentBook SET sBookReturnDate = current_date WHERE sId = :sid and bId= :bid")
	void setReturnDate(@Param("sid") int sId,@Param("bid") int bId);
  
	
    @Query("select datediff(sBookReturnDate,sBookTakenDate) from StudentBook WHERE sId = :sid and bId= :bid")
	int calculatePenality(@Param("sid") int sId,@Param("bid") int bId);
//    
//    @Modifying
//    @Transactional
//    @Query("UPDATE StudentBook sb SET sb.sBookReturnDate = CURRENT_DATE WHERE sb.student.id = :sid AND sb.book.id = :bid")
//    void setReturnDate(@Param("sid") int sId, @Param("bid") int bId);
//
//    @Query("SELECT DATEDIFF(sb.sBookReturnDate, sb.sBookTakenDate) FROM StudentBook sb WHERE sb.student.id = :sid AND sb.book.id = :bid")
//    int calculatePenality(@Param("sid") int sId, @Param("bid") int bId);

    @Query("select s from StudentBook s where s.sId= :sId")
	List<StudentBook> findStudentData(int sId);





	
	
}
