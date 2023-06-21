package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringTokenizer;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        String email = "";
        int age = 0;
        long phone = 0;
        Path filePath = file.toPath();
        final String nameKey = "Name:";
        final String phoneKey = "Phone:";
        final String ageKey = "Age:";
        final String emailKey = "Email:";
        try (java.io.FileReader reader = new java.io.FileReader(file)) {
            List<String> lines = Files.readAllLines(filePath);
            for(String line : lines) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                String word = tokenizer.nextToken();
                if(word.equals(nameKey))
                    name = tokenizer.nextToken();
                else if(word.equals(emailKey))
                    email = tokenizer.nextToken();
                else if(word.equals(ageKey))
                    age = Integer.parseInt(tokenizer.nextToken());
                else if(word.equals(phoneKey))
                    phone = Long.parseLong(tokenizer.nextToken());

            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}
