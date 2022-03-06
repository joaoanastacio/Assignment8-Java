package project;

public class Contact {

  private String contactName;
  private String contactEmail;
  private String mobilePhoneNumber;
  private String workPhoneNumber;
  private String homePhoneNumber;
  private String contactCity;

  public Contact(String mobilePhoneNumber, String contactCity) {
    setMobilePhoneNumber(mobilePhoneNumber);
    setContactCity(contactCity);
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    if(contactName.isEmpty()) {
      System.out.println("You must enter this field.");
    } else {
      this.contactName = contactName;
    }
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public void setMobilePhoneNumber(String mobilePhoneNumber) {
    if(mobilePhoneNumber.isEmpty()) {
      System.out.println("You must enter this field.");
    } else {
      this.mobilePhoneNumber = mobilePhoneNumber;
    }
  }

  public String getWorkPhoneNumber() {
    return workPhoneNumber;
  }

  public void setWorkPhoneNumber(String workPhoneNumber) {
    this.workPhoneNumber = workPhoneNumber;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public void setHomePhoneNumber(String homePhoneNumber) {
    this.homePhoneNumber = homePhoneNumber;
  }

  public String getContactCity() {
    return contactCity;
  }

  public void setContactCity(String contactCity) {
    this.contactCity = contactCity;
  }

}
