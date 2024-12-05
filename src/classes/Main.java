package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        StatisticHelper statisticHelper = new StatisticHelper();
        System.out.println("\n\n\n");
        statisticHelper.longestWorkingEmployee(personList1);
        System.out.println("Male Count: "+statisticHelper.maleAndFemaleCount(personList)[0]+" Female Count: "+statisticHelper.maleAndFemaleCount(personList)[1]);
        System.out.println("Male avg sallary: "+statisticHelper.avgSallaryMaleAndFemaleInPersonList(personList)[0]+" Female avg sallary: "+statisticHelper.avgSallaryMaleAndFemaleInPersonList(personList)[1]);
        System.out.println("Min sallary: "+statisticHelper.salaryRange(personList)[0]+"  Max sallary: "+statisticHelper.salaryRange(personList)[1]);

        System.out.println("City        :        AvgSalary");
        for (Map.Entry<String, Double> entry : statisticHelper.avgSallaryPerCity(personList).entrySet())
        {
            System.out.println(entry.getKey()+"    "+entry.getValue());
        }
    }

}