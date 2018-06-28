package com.fcu.gtml.edx.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLogUtils {
    
    public static void main(String[] args) throws IOException {
        String file = "D:\\TrackingLogVaild.csv";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.lines().forEach(text -> {System.out.println(text);} );
    }
}
