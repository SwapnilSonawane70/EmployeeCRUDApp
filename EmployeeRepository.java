package net.javaguides.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.javaguides.EMS.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
