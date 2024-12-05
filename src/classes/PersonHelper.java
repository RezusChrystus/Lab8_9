package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PersonHelper {
    public List<Person> convertListOfStringsToListOfPeople(List<String> list){
        List<Person> personList = new LinkedList<>();
        for (String s : list){
            personList.add(convertStringToPersonList(s));
        }
        return personList;
    }
    public Person convertStringToPersonList(String infoLine){
        String [] info = infoLine.split(";");
        SEX sex = Objects.equals(info[2], "MALE") ?SEX.MALE :SEX.FEMALE;
        return new Person(info[0],
                info[1],
                sex,
                Integer.parseInt(info[3]),
                info[4],new Company(info[12],
                Integer.parseInt(info[13])),
                Double.parseDouble(info[14]),
                new Address(info[7],info[8],info[9],info[11],info[6],info[5]));
    }
    //Sophia;Underwood;FEMALE;1967;Human Resources Specialist;Isylor;Ashbourne;Pinecrest Path;67;49;67;10134;InfinityWorks;1989
}
