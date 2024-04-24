package com.poornima.placement.repository;

import com.poornima.placement.entity.PlacementRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementRecordRepo extends JpaRepository<PlacementRecord,Integer> {
    @Query(value = "select * from placement_record",nativeQuery = true)
    List<PlacementRecord> getAll();
}
