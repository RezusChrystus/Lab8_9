public class Person {
    private String name;
    private String surname;
    private SEX sex;
    private int bornYear;
    String job;
    Company company;
    double salary;
    Address address;

    public Person(String name, String surname, SEX sex, int bornYear, String job, Company company, double salary, Address address) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.bornYear = bornYear;
        this.job = job;
        this.company = company;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SEX getSex() {
        return sex;
    }

    public void setSex(SEX sex) {
        this.sex = sex;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", bornYear=" + bornYear +
                ", job='" + job + '\'' +
                ", company=" + company +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}
