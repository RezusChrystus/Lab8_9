import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person person;
//        person = new DataGenerator().generatePerson();
//        System.out.println(person);
        List<Person> personList = new DataGenerator().generatePersonList(10);
        for(Person p : personList){
            System.out.println(p);
        }
    }
}