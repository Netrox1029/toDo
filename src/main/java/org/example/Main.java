package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        boolean working = true;
        while(working) {
            try {
                Scanner scanner = new Scanner(System.in);
                File file = new File("JavaToDo.txt");
                List<String> list = Files.readAllLines(Paths.get("JavaToDo.txt"));
                System.out.println("Co chcesz zrobic(Podaj numer)");
                System.out.println("1.Dodaj nowa rzecz do listy");
                System.out.println("2.Usuń rzecz z listy");
                System.out.println("3.Odpal liste");
                System.out.println("4.Koniec");
                String wybor = scanner.nextLine();


                BufferedReader reader = new BufferedReader(new FileReader("JavaToDo.txt"));
                int lines = 1;
                while (reader.readLine() != null) lines++;
                reader.close();

                if(wybor.equals("1") || wybor.equals("2") ||wybor.equals("3") ||wybor.equals("4") ) {
                    if (wybor.equals("1")) {
                        System.out.println("Napisz jakie zadanie chcesz dodac");
                        String quest = scanner.nextLine();
                        FileWriter myWriter = new FileWriter("JavaToDo.txt", true);
                        if(lines == 1) {
                            myWriter.write(lines + ". " + quest);
                        }else{
                            myWriter.write("\n" + lines + ". " + quest);

                        }
                        myWriter.close();
                        System.out.println("\n[Wciśnij Enter, aby wrócić do menu]");
                        scanner.nextLine();
                    } else if (wybor.equals("2")) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i));
                        }
                        System.out.println("Która linijke chcesz usunac");
                        String delQuest = scanner.nextLine();
                        int index = Integer.parseInt(delQuest) - 1;
                        System.out.println("Została usunieta linijka: " + list.get(index));
                        list.remove(index);
                        FileWriter myWriter = new FileWriter("JavaToDo.txt");
                        for (String line : list) {
                            myWriter.write(line + "\n");
                        }

                        myWriter.close();
                        System.out.println("\n[Wciśnij Enter, aby wrócić do menu]");
                        scanner.nextLine();
                    } else if (wybor.equals("3")) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i));
                        }
                        System.out.println("\n[Wciśnij Enter, aby wrócić do menu]");
                        scanner.nextLine();
                    } else if (wybor.equals("4")) {
                        System.out.println("Koniec programu");
                        working = false;
                    }
                }else{
                    System.out.println("Prosze wpisac poprawne dane");
                    System.out.println("\n[Wciśnij Enter, aby wrócić do menu]");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
//scan.nextLine();