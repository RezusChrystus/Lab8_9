package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataGenerator {

    public DataGenerator() {
    }

    public List<Person> generatePersonList(int listLength) {
        List<Person> personList = new LinkedList<>();
        while(listLength>=0){
            personList.add(generatePerson());
            listLength--;
        }
        return personList;
    }

    public Person generatePerson() {
        Random random = new Random();
        SEX sex = random.nextBoolean()? SEX.MALE :SEX.FEMALE;
        List<String> namesList = new LinkedList<>();
        List<String> surnamesList = new LinkedList<>();
        List<String> jobNamesList = new LinkedList<>();


        String filePath;
//        if(sex == classes.SEX.FEMALE)
        if (SEX.FEMALE.equals(sex)) {
             filePath = "src\\GeneratorData\\FemaleNames";
        }else{
             filePath = "src\\GeneratorData\\MaleNames";

        }
        try {
            Scanner namesScanner= new Scanner(new File(filePath));
            Scanner surnamesScanner= new Scanner(new File("src\\GeneratorData\\Surnames"));
            Scanner jobnamesScanner= new Scanner(new File("src\\GeneratorData\\JobNames"));

            while(namesScanner.hasNext()){
                namesList.add(namesScanner.nextLine());
            }while(surnamesScanner.hasNext()){
                surnamesList.add(surnamesScanner.nextLine());
            }while(jobnamesScanner.hasNext()){
                jobNamesList.add(jobnamesScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Person(namesList.get(random.nextInt(namesList.size())),
                surnamesList.get(random.nextInt(surnamesList.size())),
                sex,
//                random.nextInt(1960,LocalDate.EPOCH.getYear()),
                random.nextInt(1960,2002),
                jobNamesList.get(random.nextInt(jobNamesList.size())),
                generateCompany(),
                random.nextInt(0,60000),
                generateAddress()
                );
    }

    public Company generateCompany() {
        try {
            Scanner scanner = new Scanner(new File("src\\GeneratorData\\CompanyNames"));
            List<String> companyNames = new LinkedList<>();
            Random random = new Random();
            while(scanner.hasNext()){
                companyNames.add(scanner.nextLine());
            }
            scanner.close();
            return new Company(companyNames.get(random.nextInt(0,companyNames.size())),random.nextInt(1700, LocalDate.now().getYear()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Address generateAddressFromCSV(){
        
        return null;
    }
    public Address generateAddress() {
        Random random = new Random();
        try {
            Scanner cityNamesScanner = new Scanner(new File("src\\GeneratorData\\CityNames"));
            Scanner streetNamesAndPostalCodeScanner = new Scanner(new File("src\\GeneratorData\\StreetNames"));
            Scanner countryNamesScanner = new Scanner(new File("src\\GeneratorData\\CountryNames"));
            List<String> cityNames = new LinkedList<>();
            List<String> streetNamesAndPostalCodes = new LinkedList<>();
            List<String> countryNames = new LinkedList<>();
            while (cityNamesScanner.hasNext()) {
                cityNames.add(cityNamesScanner.nextLine());
            }
            while (streetNamesAndPostalCodeScanner.hasNext()) {
                streetNamesAndPostalCodes.add(streetNamesAndPostalCodeScanner.nextLine());
            }while (countryNamesScanner.hasNext()) {
                countryNames.add(countryNamesScanner.nextLine());
            }

            String street = streetNamesAndPostalCodes.get(random.nextInt(streetNamesAndPostalCodes.size()));
            streetNamesAndPostalCodeScanner.close();
            cityNamesScanner.close();
            countryNamesScanner.close();

            return new Address(
                    street.split(";")[0],
                    Integer.toString(random.nextInt(0,100)),
                    Integer.toString(random.nextInt(0,100)),
                    street.split(";")[1],
                    cityNames.get(random.nextInt(0,cityNames.size())),
                    countryNames.get(random.nextInt(0,countryNames.size()))
                    );



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }


    }


}
