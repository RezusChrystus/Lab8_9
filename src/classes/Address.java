package classes;

public class Address {
    private String street;
    private String flatNo;
    private String houseNo;
    private String postalCode;
    private String city;
    private String country;

    public Address(String street, String flatNo, String houseNo, String postalCode, String city, String country) {
        this.street = street;
        this.flatNo = flatNo;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "street='" + street + '\'' +
                        ", flatNo='" + flatNo + '\'' +
                        ", houseNo='" + houseNo + '\'' +
                        ", postalCode='" + postalCode + '\'' +
                        ", city='" + city + '\'' +
                        ", country='" + country + '\'' ;
    }

    public String addressToFileMapper() {
        StringBuilder sb = new StringBuilder();
        sb.append(country).append(";").append(city).append(";").append(street).append(";").append(flatNo).append(";").append(houseNo).append(";")
                .append(flatNo).append(";").append(postalCode).append(";");
        return sb.toString();
    }
}
