package press.business;

import java.io.Serializable;

public class User implements Serializable {
    private Long userId;
    private String name;
    private String email;
    private String organizationName;
    private String address1;
    private String address2;
    private String city;
    private String st;
    private String zip;
    private String country;
    private String creditCardType;
    private String creditCardNumber;
    private String creditCardExpirationDate;

    public User() {
        name = "";
        email = "";
        organizationName = "";
        address1 = "";
        address2 = "";
        city = "";
        st = "";
        zip = "";
        country = "";
        creditCardType = "";
        creditCardNumber = "";
        creditCardExpirationDate = "";
    }
    
    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    // State is a reserved SQL word, so the field is called "st" instead.
    public void setState(String state) {
        st = state;
    }

    public String getState() {
        return st;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    // this works, but it mixes the Model and the View
    public String getAddressHTMLFormat() {
        String address = name + "<br>";

        if (organizationName == null || organizationName.equals("") || organizationName.equals(" ")) {
            address += "";
        } else {
            address += organizationName + "<br>";
        }

        address += address1 + "<br>";

        if (address2 == null || address2.equals("") || address2.equals(" ")) {
            address += "";
        } else {
            address += address2 + "<br>";
        }

        address += city + ", " + st + " " + zip + "<br>"
                + country;

        return address;
    }

    public void setCreditCardType(String creditCartType) {
        this.creditCardType = creditCartType;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }
}