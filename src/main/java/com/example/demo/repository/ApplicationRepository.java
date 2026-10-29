
package com.example.demo.repository;

import com.example.demo.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository
        extends JpaRepository<Application, Long>,
        JpaSpecificationExecutor<Application> {
    @Query("""
    SELECT DISTINCT a.category
    FROM Application a
    WHERE a.category IS NOT NULL
      AND a.category <> ''
    ORDER BY a.category
    """)
    List<String> findDistinctCategories();
}
