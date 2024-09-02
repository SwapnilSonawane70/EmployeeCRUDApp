package net.javaguides.EMS.Mapper;

import net.javaguides.EMS.dto.EmployeeDto;
import net.javaguides.EMS.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        return new Employee(
            employeeDto.getId(),
            employeeDto.getfirstName(),
            employeeDto.getlastName(),
            employeeDto.getemail()
        );
    }
}
