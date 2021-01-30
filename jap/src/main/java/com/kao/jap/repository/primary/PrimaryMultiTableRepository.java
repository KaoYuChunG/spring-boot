package com.kao.jpa.repository.primary;

import com.kao.jpa.entity.primary.PrimaryMultiTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryMultiTableRepository extends JpaRepository<PrimaryMultiTable, Long> {
}
