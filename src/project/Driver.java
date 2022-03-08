package project;

public class Driver {

  private static final String LIST_ALL_CONTACTS = "1";
  private static final String ADD_CONTACT = "2";
  private static final String REMOVE_CONTACT = "3";
  private static final String UPDATE_CONTACT = "4";
  private static final String QUITE_PROGRAM = "5";

  private static final String INPUT_ENTER_OPTION = "Enter your option: ";
  private static final String INPUT_ENTER_USERNAME = "Enter a name: ";
  private static final String INPUT_ENTER_EMAIL = "Enter an email: ";
  private static final String INPUT_ENTER_MOBILE_NUMBER = "Enter a mobile number: ";
  private static final String INPUT_ENTER_WORK_NUMBER = "Enter a work number: ";
  private static final String INPUT_ENTER_HOME_NUMBER = "Enter a home number: ";
  private static final String INPUT_ENTER_CITY_NAME = "Enter a city: ";
  private static final String INPUT_ENTER_CONTACT_ID = "\nEnter a contact index: ";

  public static void main(String[] args) {

    ContactList contactList = new ContactList();
    boolean stillRunning = true;

    while (stillRunning) {
      String input = InputCollector.getUserInput(INPUT_ENTER_OPTION);

      switch (input) {
        case LIST_ALL_CONTACTS:
          contactList.getAllContacts();
          InputCollector.setAsOptionTurn();
          continue;

        case ADD_CONTACT:
          Contact contact = new Contact();

          String contactName = InputCollector.getUserInput(INPUT_ENTER_USERNAME);
          contact.setContactName(contactName);

          String contactEmail = InputCollector.getUserInput(INPUT_ENTER_EMAIL);
          contact.setContactEmail(contactEmail);

          String mobileNumber = InputCollector.getUserInput(INPUT_ENTER_MOBILE_NUMBER);
          contact.setMobilePhoneNumber(mobileNumber);

          String workNumber = InputCollector.getUserInput(INPUT_ENTER_WORK_NUMBER);
          contact.setWorkPhoneNumber(workNumber);

          String homeNumber = InputCollector.getUserInput(INPUT_ENTER_HOME_NUMBER);
          contact.setHomePhoneNumber(homeNumber);

          String city = InputCollector.getUserInput(INPUT_ENTER_CITY_NAME);
          contact.setContactCity(city);

          contactList.addContact(contact);
          InputCollector.setAsOptionTurn();
          continue;

        case REMOVE_CONTACT:
          contactList.getAllContacts();
          String idRemove =
              InputCollector.getUserInput(INPUT_ENTER_CONTACT_ID);

          if (!Character.isDigit(idRemove.charAt(0))) {
            System.err.println("Invalid contact id. You must enter a number");
            InputCollector.setAsOptionTurn();
            continue;
          } else {
            Contact contactToRemove = contactList.getContactById(Integer.parseInt(idRemove));

            if(contactToRemove == null) {
              System.err.printf("Contact at index %s does not exists.%n", idRemove);
              InputCollector.setAsOptionTurn();
              continue;
            }
            contactList.removeContact(contactToRemove);
          }
          InputCollector.setAsOptionTurn();
          continue;

        case UPDATE_CONTACT:
          contactList.getAllContacts();
          String idUpdate = InputCollector.getUserInput(INPUT_ENTER_CONTACT_ID);
          Contact contactToUpdate = contactList.getContactById(Integer.parseInt(idUpdate));

          if(!Character.isDigit(idUpdate.charAt(0))) {
            System.err.println("Invalid contact id. You must enter a number");
            InputCollector.setAsOptionTurn();
            continue;
          } else {
            if(contactToUpdate == null) {
              System.err.printf("Contact at index %s does not exists.%n", idUpdate);
              InputCollector.setAsOptionTurn();
              continue;
            }

            Contact updatedContact = new Contact();
            String updatedContactName = InputCollector.getUserInput(INPUT_ENTER_USERNAME);
            updatedContact.setContactName(updatedContactName);

            String updatedContactEmail = InputCollector.getUserInput(INPUT_ENTER_EMAIL);
            updatedContact.setContactEmail(updatedContactEmail);

            String updatedContactMobileNumber = InputCollector.getUserInput(INPUT_ENTER_MOBILE_NUMBER);
            updatedContact.setMobilePhoneNumber(updatedContactMobileNumber);

            String updatedContactWorkNumber = InputCollector.getUserInput(INPUT_ENTER_WORK_NUMBER);
            updatedContact.setWorkPhoneNumber(updatedContactWorkNumber);

            String updatedContactHomeNumber = InputCollector.getUserInput(INPUT_ENTER_HOME_NUMBER);
            updatedContact.setHomePhoneNumber(updatedContactHomeNumber);

            String updatedContactCity = InputCollector.getUserInput(INPUT_ENTER_CITY_NAME);
            updatedContact.setContactCity(updatedContactCity);

            contactList.updateContact(Integer.parseInt(idUpdate), updatedContact);
          }

          InputCollector.setAsOptionTurn();
          continue;

        case QUITE_PROGRAM:
          stillRunning = false;
          System.out.println("See you later...");
          break;

        default:
          System.err.println("Invalid Input. Enter a number between 1 and 5.");
      }
    }
  }

}
