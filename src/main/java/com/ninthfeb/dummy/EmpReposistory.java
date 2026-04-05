package com.ninthfeb.dummy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmpReposistory extends JpaRepository<EmpEntity, Long> {
    List<EmpEntity> findByName(String name);
    
}
