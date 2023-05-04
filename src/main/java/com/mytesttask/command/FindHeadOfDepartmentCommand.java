package com.mytesttask.command;

import com.mytesttask.entity.Department;
import com.mytesttask.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class FindHeadOfDepartmentCommand implements Command{

    private  final DepartmentRepository departmentRepository;
    Pattern pattern = Pattern.compile("Who is head of department (.*)\\.");

    @Autowired
    public FindHeadOfDepartmentCommand(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public String execute(String userInput) {
        String departmentName = getDepartmentNameFromCommand(pattern, userInput);
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) {
            return "Department not found";
        }
        return "Head of " + departmentName + " department is " + department.getHeadOfDepartment().getName();
    }
}
