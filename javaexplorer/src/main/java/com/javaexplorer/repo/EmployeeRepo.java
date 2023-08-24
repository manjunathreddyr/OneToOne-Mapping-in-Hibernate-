package com.javaexplorer.repo;

import com.javaexplorer.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employee,Long> {
}
