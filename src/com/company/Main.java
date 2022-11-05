package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<File> dir = Arrays.asList(
                new File("C://Games//src//main", "//Main.java"),
                new File("C://Games//src//main", "//Utils.java"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons"),
                new File("C://Games//savegames"),
                new File("C://Games//temp")
        );
        List<File> file1 = List.of(
                new File("C://Games//temp//temp.txt"));
        StringBuilder SB = new StringBuilder();
        dir.forEach(list -> {
            if (list.mkdirs()) SB.append("Каталог создан " + list + '\n');
            else SB.append("Каталог не создан" + list + '\n');
        });
        file1.forEach(file -> {
            try {
                if (file.createNewFile()) SB.append("Файл создан " + file + '\n');
                else SB.append("Файл не создан " + file + '\n');
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
            try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", false)) {
                writer.write(SB.toString());
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            try (BufferedReader br = new BufferedReader(new FileReader("C://Games//temp//temp.txt"))) {
                String s;
                while ((s = br.readLine()) != null)
                    System.out.println(s);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
