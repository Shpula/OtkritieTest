package org.example;

import com.google.gson.Gson;
import org.example.models.Root;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Gson g = new Gson();
        FileReader reader = new FileReader("src/main/java/org/example/test1.json");
        Root root = g.fromJson(reader, Root.class);

        int count = 0;
        for(int a = 0; a < root.cards.size(); a++) {
            if (root.cards.get(a).cardData.tarif.toString().equals("Opencard зарплатная")) {
                count = count + 1;
            }
        }
        System.out.println("Number of salary cards: " + count);


        int count1 = 0;
        for(int a = 0; a < root.cards.size(); a++) {
            if ((root.cards.get(a).cardData.status.statusCode.toString().equals("00"))
                    & root.cards.get(a).cardData.status.plasticStatus.toString().equals("Active")) {
                count1 = count1 + 1;
            }
        }
        System.out.println("Number of active cards: " + count1);
        reader.close();


        FileWriter writer = new FileWriter("src/main/java/org/example/test2.json");
        new Gson().toJson(root, writer);
        writer.close();
        System.out.println(root);

    }

}