package com.mytesttask;

import com.mytesttask.command.CommandExecutor;
import com.mytesttask.repository.DepartmentRepository;
import com.mytesttask.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInterface implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final CommandExecutor commandExecutor;

    @Autowired
    public ConsoleInterface(DepartmentRepository departmentRepository, LectorRepository lectorRepository, CommandExecutor commandExecutor) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            System.out.println("Enter command: ");
            input = scanner.nextLine();
            System.out.println(commandExecutor.executeCommand(input));
        }while (!input.equals("exit"));

        System.out.println("Bye!");
    }

}
