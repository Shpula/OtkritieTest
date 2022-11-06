package org.example;

import org.example.models.Root;
import org.example.tools.Tools;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WriterToJson extends Tools {

    private final static String JSON_ABSOLUTE_PATH_SECOND_TASK = "src/main/java/org/example/jsons/secondTask.json";
    private final static String JSON_ABSOLUTE_PATH_SECOND_TASK_INPUT = "src/main/java/org/example/jsons/secondTaskAnswer.json";

    static String Write() throws IOException {
        FileReader reader = new FileReader(JSON_ABSOLUTE_PATH_SECOND_TASK);
        Root root = gson.fromJson(reader, Root.class);

        System.out.println("Print cardId: ");
        String cardId = scanner.nextLine();

        if (FindCardId(root, cardId) == true) {
            Map<String, String> map = new HashMap<>();

            System.out.println("Print CardHolderName: ");
            map.put("cardHolderName", PrintCardHolderName(scanner));
            EditCardHolderName(root, map, cardId);

            System.out.println("Print Tariff: ");
            map.put("tariff", PrintTariff(scanner));
            EditTariff(root, map, cardId);


            FileWriter writer = new FileWriter(JSON_ABSOLUTE_PATH_SECOND_TASK_INPUT);
            gson.toJson(root, writer);

            writer.close();
            reader.close();
            return "Edit is complete";
        }
        return "You don't have such a card";
    }

    private static String PrintCardHolderName(Scanner scanner) {
        String cardHolderName = scanner.nextLine();
        return cardHolderName;
    }

    private static String PrintTariff(Scanner scanner) {
        String tariff = scanner.nextLine();
        return tariff;
    }


    private static boolean FindCardId(Root root, String cardId) {
        boolean flag = false;
        for(var card: root.cards){
            if (card.cardData.cardID.equals(cardId)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    private static void EditCardHolderName(Root root, Map map, String cardId) {
        for(var card: root.cards){
            if (card.cardData.cardID.equals(cardId)){
                card.cardData.cardHolderName = (String) map.get("cardHolderName");
            }
        }
    }

    private static void EditTariff(Root root, Map map, String cardId) {
        for(var card: root.cards){
            if (card.cardData.cardID.equals(cardId)){
                card.cardData.tarif = (String) map.get("tariff");
            }
        }
    }


}
