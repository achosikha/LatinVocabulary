package com.example.latinvocabulary;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HelloController {
    public TextArea theWord;
    public TextArea translation;
    private Map<String, String> vocabulary = new TreeMap<>();
    private String tempKey;

    public HelloController()
    {
        // src\main\resources\com\example\latinvocabulary/db.txt
        File path = new File("src\\main\\resources\\com\\example\\latinvocabulary/db.txt");
        try {
            Scanner read = new Scanner(path);
            while (read.hasNext())
            {
                String[] temp = read.nextLine().split(" ", 2);
                vocabulary.put(temp[0], temp[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(vocabulary);
        tempKey = "";
    }
    public void close(MouseEvent mouseEvent) {
        ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
    }

    public void randomWord(MouseEvent mouseEvent) {
        // взять все ключи и иметь возможность по ним пройтись
        Iterator<String> iterator = vocabulary.keySet().iterator();
        String[] temp = new String[vocabulary.size()];

        int index = 0;

        for (String el : vocabulary.keySet())
        {
            temp[index] = el;
            index++;
        }

        tempKey = temp[random().nextInt(0, temp.length - 1)];
        theWord.setText(tempKey);

        if (!translation.getText().isEmpty())
        {
            translation.clear();
        }
    }

    public Random random()
    {
        return new Random();
    }

    public void show(MouseEvent mouseEvent) {
        if (!tempKey.isEmpty())
        {
            translation.setText(vocabulary.get(tempKey));
            tempKey = "";
        }
    }
}