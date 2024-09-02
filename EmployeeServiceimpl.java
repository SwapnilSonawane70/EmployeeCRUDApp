package net.javaguides.EMS.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.Collate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.EMS.Mapper.EmployeeMapper;
import net.javaguides.EMS.dto.EmployeeDto;
import net.javaguides.EMS.entity.Employee;
import net.javaguides.EMS.exception.ResourceNotFoundException;
import net.javaguides.EMS.repository.EmployeeRepository;
import net.javaguides.EMS.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {
	
	EmployeeServiceimpl  serimpl;

	private EmployeeRepository employeeRepository;	
	
	@Autowired
	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployere = employeeRepository.save(employee);
		return  EmployeeMapper.mapToEmployeeDto(employee);
		
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("Employee is not exits with given id :" + employeeId));
		
		
 		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	 public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exits with given id: "+ employeeId)
				);
		
			employee.setFirstName(updatedEmployee.getfirstName());
			employee.setLastName(updatedEmployee.getlastName());
			employee.setEmail(updatedEmployee.getemail());
			
		Employee updatedEmployeeObj =	employeeRepository.save(employee);;
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exits with given id: "+ employeeId)
				);
		
		employeeRepository.deleteById(employeeId);
	}
	
	
}

