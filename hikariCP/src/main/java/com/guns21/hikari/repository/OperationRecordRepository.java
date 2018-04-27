package com.guns21.hikari.repository;

import com.guns21.hikari.entity.LoanDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author vincentchen
 * @date 17/12/13.
 */
public interface OperationRecordRepository extends JpaRepository<LoanDO, String> {


    @Query(value = "select SLEEP(90)", nativeQuery = true)
    List<String> listAll();
}
