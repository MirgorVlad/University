package com.mytesttask.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

    private final String headOfDepartmentCommand = "Who is head of department";
    private final String statisticCommand = "statistics";
    private final String averageSalaryCommand = "Show the average salary for the department";
    private final String countEmployeeCommand = "Show count of employee for";
    private final String searchByCommand = "Global search by";

    private final FindHeadOfDepartmentCommand findHeadOfDepartmentCommand;
    private final FindByNameCommand findByNameCommand;
    private final ShowStatisticCommand showStatisticCommand;
    private final ShowAverageSalaryCommand showAverageSalaryCommand;
    private final ShowCountOfEmployeeCommand showCountOfEmployeeCommand;

    @Autowired
    public CommandExecutor(FindHeadOfDepartmentCommand findHeadOfDepartmentCommand,
                           FindByNameCommand findByNameCommand,
                           ShowStatisticCommand showStatisticCommand,
                           ShowAverageSalaryCommand showAverageSalaryCommand,
                           ShowCountOfEmployeeCommand showCountOfEmployeeCommand) {
        this.findHeadOfDepartmentCommand = findHeadOfDepartmentCommand;
        this.findByNameCommand = findByNameCommand;
        this.showStatisticCommand = showStatisticCommand;
        this.showAverageSalaryCommand = showAverageSalaryCommand;
        this.showCountOfEmployeeCommand = showCountOfEmployeeCommand;
    }


    public String executeCommand(String input) {

        if(input.contains(headOfDepartmentCommand))
            return findHeadOfDepartmentCommand.execute(input);
        if(input.contains(searchByCommand))
            return findByNameCommand.execute(input);
        if(input.contains(statisticCommand))
            return showStatisticCommand.execute(input);
        if(input.contains(averageSalaryCommand))
            return showAverageSalaryCommand.execute(input);
        if(input.contains(countEmployeeCommand))
            return showCountOfEmployeeCommand.execute(input);
        else
            return "Unknown command!";

    }
}
