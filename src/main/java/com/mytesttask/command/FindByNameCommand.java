package com.mytesttask.command;

import com.mytesttask.entity.Lector;
import com.mytesttask.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FindByNameCommand implements Command{
    private  final LectorRepository lectorRepository;
    Pattern pattern = Pattern.compile("Show count of employee for (.*)\\.");

    @Autowired
    public FindByNameCommand(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String execute(String userInput) {
        String template = getTemplate(userInput);

        if (template == null) {
            return "No matches";
        }

        List<Lector> lectors = lectorRepository.findAll();
        List<String> result = lectors.stream().map(Lector::getName).filter(n -> n.contains(template)).toList();

        StringBuilder answer = new StringBuilder();
        result.forEach(e -> answer.append(e).append("\n"));

        return answer.toString();
    }

    private String getTemplate(String input){
        Pattern pattern = Pattern.compile("Global search by (.*)\\.");

        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            System.out.println("Invalid input format.");
            return null;
        }

    }
}
