package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    public FileHelper() {
    }

    public void saveListToFile(List<Person> personList){
        try {
            FileWriter writer = new FileWriter("src\\Output\\result.txt");
            for (Person person : personList){
                writer.write(person.personToFileMapper()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<String> readFromFile(){
        List<String> personsStringData = new LinkedList<>();
        try {
            Scanner sc = new Scanner(new File("src\\Output\\result.txt"));
            while(sc.hasNext())  {
                personsStringData.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return personsStringData;

    }
}
