package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Person person;
        person = new DataGenerator().generatePerson();
        List<Person> personList = new DataGenerator().generatePersonList(10);

        FileHelper fileHelper = new FileHelper();
        fileHelper.saveListToFile(personList);
        System.out.println("Persons count in file: "+personList.size());
        PersonHelper personHelper = new PersonHelper();
        personHelper.convertListOfStringsToListOfPeople(fileHelper.readFromFile());

        List<Person> personList1 = new PersonHelper().convertListOfStringsToListOfPeople( fileHelper.readFromFile());
        for (Person el : personList1){
            System.out.println(el);
        }
    }

}