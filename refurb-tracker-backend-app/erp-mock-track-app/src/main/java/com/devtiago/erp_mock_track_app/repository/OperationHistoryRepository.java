package com.devtiago.erp_mock_track_app.repository;

import com.devtiago.erp_mock_track_app.entity.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OperationHistoryRepository extends JpaRepository<OperationHistory, Long> {

    @Query("SELECT oph FROM OperationHistory oph JOIN oph.reception r WHERE r.sn = :sn")
    Optional<OperationHistory> findByReceptionSn(String sn);
}
