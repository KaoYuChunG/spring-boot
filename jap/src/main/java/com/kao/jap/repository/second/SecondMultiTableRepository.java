package com.kao.jpa.repository.second;

import com.kao.jpa.entity.second.SecondMultiTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondMultiTableRepository extends JpaRepository<SecondMultiTable, Long> {
}
