package com.epam.mjc.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            StringBuilder str = new StringBuilder();
            int i;
            while ((i = fileInputStream.read()) != -1) {
                str.append((char) i);
            }
            String[] split = str.toString().split("\n");
            profile.setName(split[0].split(": ")[1]);
            profile.setAge(Integer.valueOf(split[1].split(": ")[1]));
            profile.setEmail(split[2].split(": ")[1]);
            profile.setPhone(Long.valueOf(split[3].split(": ")[1]));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
