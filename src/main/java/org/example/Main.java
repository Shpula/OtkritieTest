package org.example;

import com.google.gson.Gson;
import org.example.models.Root;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        var numberOfUserCards = ReaderFromJson.Read();
        System.out.println("Number of active card: " + numberOfUserCards.getCountActiveCard());
        System.out.println("Number of salary card: " + numberOfUserCards.getCountSalaryCard());
        System.out.println(WriterToJson.Write());
    }

}