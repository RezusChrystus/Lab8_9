package classes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StatisticHelper {
    public StatisticHelper() {
    }

    public void longestWorkingEmployee(List<Person> personList) {
        List<Person> result = new LinkedList<>();
        List<Company> oldestCompanies = oldestCompanies(personList);
        for (Person p : personList){
            if(oldestCompanies.contains(p.getCompany())){
                System.out.println(p);
            }
        }
    }
    int [] maleAndFemaleCount(List<Person> personList){
        int []result = {0,0};
        for (Person p : personList){
            if(p.getSex() == SEX.MALE){
                result[0]++;
            }else result[1]++;
        }
        return result;
    }
    double avgAgeInPersonList(List<Person> personList){
        double result = 0;
        for (Person p : personList){
            result+= LocalDate.now().getYear()-p.getBornYear();
        }
        return result/personList.size();
    }
    double avgSallaryInPersonList(List<Person> personList){
        double result = 0;
        for (Person p : personList){
            result+= p.getSalary();
        }
        return result/personList.size();
    }
    double[] avgSallaryMaleAndFemaleInPersonList(List<Person> personList) {
        double[] result = {0,0};
        int maleCount = 0;
        int femaleCount = 0;
        for (Person p : personList) {
            if(p.getSex() == SEX.MALE){
                result[0] += p.getSalary();
                maleCount++;
            }else{
                result[1]+= p.getSalary();
                femaleCount++;
            }
        }
        result[0]/=maleCount;
        result[1]/=femaleCount;
        return result ;
    }
    public double [] salaryRange(List<Person> personList){
        double []minMax ={Double.MAX_VALUE,Double.MIN_VALUE};
        for (Person p : personList){
            if(p.salary<minMax[0]){
                minMax[0] = p.salary;
            }if(p.salary>minMax[1]){
                minMax[1] = p.salary;
            }
        }
        return minMax;
    }
    public Map<String , Double> avgSallaryPerCity(List <Person> personList){
        Map<String , List<Double>> citySallaries = new HashMap<>();
        for (Person p: personList){
            if(citySallaries.containsKey(p.address.getCity())){
                citySallaries.get(p.address.getCity()).add(p.salary);
            }else{
                List<Double> l = new LinkedList<>();
                l.add(p.getSalary());
                citySallaries.put(p.getAddress().getCity(),l );
            }
        }
        Map<String , Double> res = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : citySallaries.entrySet())
        {
            double avgSalary = 0;
            for (double el: entry.getValue()){
                avgSalary+=el;
            }
            res.put(entry.getKey(),avgSalary/entry.getValue().size());
        }
        return res;
    }

    public List<Company> oldestCompanies(List<Person> personList) {
        Company oldestCompany = personList.get(0).company;
        List<Company> oldestCompanies = new LinkedList<>();
        oldestCompanies.add(oldestCompany);
        for (Person el : personList) {
            if (el.getCompany().getYear() < oldestCompanies.get(0).getYear()) {
                oldestCompanies.clear();
                oldestCompanies.add(el.getCompany());
            } else if (oldestCompany.getYear() == el.getCompany().getYear()) {
                oldestCompanies.add(el.getCompany());
            } else if (oldestCompanies.contains(el.getCompany())) {
                continue;
            }
        }
        return oldestCompanies;
    }
}
