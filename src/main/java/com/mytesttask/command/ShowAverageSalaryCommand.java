package com.mytesttask.command;

import com.mytesttask.entity.Department;
import com.mytesttask.entity.Lector;
import com.mytesttask.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Pattern;

@Component
public class ShowAverageSalaryCommand implements Command{
    private  final DepartmentRepository departmentRepository;
    Pattern pattern = Pattern.compile("Show the average salary for the department (.*)\\.");

    @Autowired
    public ShowAverageSalaryCommand(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String execute(String userInput) {
        String departmentName = getDepartmentNameFromCommand(pattern, userInput);
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) {
            return "Department not found";
        }

        Set<Lector> lectors = department.getLectors();

        String salary =  lectors.stream()
                .map(Lector::getSalary)
                .mapToInt(Integer::intValue)
                .average().orElse(0) + "";

        return "The average salary of "+departmentName+" is " + salary;

    }
}
