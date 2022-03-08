package project;

public class Contact {

  private String contactName;
  private String contactEmail;
  private String mobilePhoneNumber;
  private String workPhoneNumber;
  private String homePhoneNumber;
  private String contactCity;

  public Contact(String contactName, String mobilePhoneNumber) {
    setContactName(contactName);
    setMobilePhoneNumber(mobilePhoneNumber);
  }

  public Contact() {}

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    boolean isValidInput = false;
    while (!isValidInput) {
      if(contactName.isEmpty()) {
        System.err.println("You must enter a valid name. It cannot be empty or null");
        contactName = InputCollector.getUserInput("Enter a name: ");
      } else {
        this.contactName = contactName;
        isValidInput = true;
      }
    }
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail.isEmpty() ? null : contactEmail;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public void setMobilePhoneNumber(String mobilePhoneNumber) {
    boolean isValidInput = false;

    while (!isValidInput) {
      if(mobilePhoneNumber.isEmpty()) {
        System.err.println("You must enter a valid mobile number. It cannot be empty or null");
        mobilePhoneNumber =
            InputCollector.getUserInput("Enter a mobile number: ");
      } else {
        this.mobilePhoneNumber = mobilePhoneNumber;
        isValidInput = true;
      }
    }
  }

  public String getWorkPhoneNumber() {
    return workPhoneNumber;
  }

  public void setWorkPhoneNumber(String workPhoneNumber) {
    this.workPhoneNumber = workPhoneNumber.isEmpty() ? null : workPhoneNumber;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public void setHomePhoneNumber(String homePhoneNumber) {
    this.homePhoneNumber = homePhoneNumber.isEmpty() ? null : homePhoneNumber;
  }

  public String getContactCity() {
    return contactCity;
  }

  public void setContactCity(String contactCity) {
    this.contactCity = contactCity.isEmpty() ? null : contactCity;
  }

}
