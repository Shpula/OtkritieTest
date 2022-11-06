package org.example;

import org.example.models.NumberOfUserCards;
import org.example.models.Root;
import org.example.tools.Tools;

import java.io.FileReader;
import java.io.IOException;

public class ReaderFromJson extends Tools {
    private final static String JSON_ABSOLUTE_PATH_FIRST_TASK = "src/main/java/org/example/jsons/firstTask.json";

    static NumberOfUserCards Read() throws IOException {
            NumberOfUserCards numberOfUserCards = new NumberOfUserCards();
            FileReader reader = new FileReader(JSON_ABSOLUTE_PATH_FIRST_TASK);
            Root root = gson.fromJson(reader, Root.class);

            numberOfUserCards.setCountSalaryCard(GetCountSalaryCard(root));
            numberOfUserCards.setCountActiveCard(GetCountActiveCard(root));

            return numberOfUserCards;
    }

    private static int GetCountSalaryCard(Root root) {
        int count = 0;
        for(var card : root.cards) {
            if (card.cardData.tarif.toString().equals("Opencard зарплатная")) {
                count++;
            }
        }
        return count;
    }

    private static int GetCountActiveCard(Root root) {
        int count = 0;
        for (var card : root.cards) {
            if ((card.cardData.status.statusCode.toString().equals("00"))
                    & card.cardData.status.plasticStatus.toString().equals("Active")) {
                count++;
            }
        }
        return count;
    }
}

