package com.mytesttask.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Command {
    String execute(String userInput);

    default String getDepartmentNameFromCommand(Pattern pattern, String input){
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            System.out.println("Invalid input format.");
            return "";
        }
    }
}
