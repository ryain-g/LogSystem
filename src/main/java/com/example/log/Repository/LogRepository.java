package com.example.log.Repository;

import com.example.log.Entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//configure this class as Repository
@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
    List<Log>  findAllByUserId(Long userId);
}
