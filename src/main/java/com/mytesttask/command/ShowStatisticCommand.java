package com.mytesttask.command;

import com.mytesttask.entity.Degree;
import com.mytesttask.entity.Department;
import com.mytesttask.entity.Lector;
import com.mytesttask.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ShowStatisticCommand implements Command{

    private  final DepartmentRepository departmentRepository;
    Pattern pattern = Pattern.compile("Show (.*) statistics\\.");

    @Autowired
    public ShowStatisticCommand(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String execute(String userInput) {
        String departmentName = getDepartmentNameFromCommand(pattern, userInput);
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) {
            return "Department not found";
        }

        int assistantCount = 0;
        int associateProfessorCount = 0;
        int professorCount = 0;

        for(Lector lector : department.getLectors()){
            if(lector.getDegree() == Degree.ASSISTANT)
                assistantCount++;
            if(lector.getDegree() == Degree.ASSOCIATE_PROFESSOR)
                associateProfessorCount++;
            if(lector.getDegree() == Degree.PROFESSOR)
                professorCount++;
        }

        return "assistans - " + assistantCount +
                "\nassociate professors - " + associateProfessorCount +
                "\nprofessors - " + professorCount;
    }
}
