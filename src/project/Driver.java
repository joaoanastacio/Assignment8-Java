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
      String input = InputCollector.getInputCollector().getUserInput(INPUT_ENTER_OPTION);

      switch (input) {
        case LIST_ALL_CONTACTS:
          contactList.getAllContacts();
          InputCollector.setAsOptionTurn();
          continue;

        case ADD_CONTACT:
          String contactName =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_USERNAME);
          String contactEmail =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_EMAIL);
          String mobileNumber =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_MOBILE_NUMBER);
          String workNumber =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_WORK_NUMBER);
          String homeNumber =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_HOME_NUMBER);
          String city =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_CITY_NAME);

          Contact contact = new Contact(mobileNumber, city);
          contact.setContactName(contactName);
          contact.setContactEmail(contactEmail);
          contactList.addContact(contact);
          InputCollector.setAsOptionTurn();
          continue;

        case REMOVE_CONTACT:
          contactList.getAllContacts();

          String idRemove = InputCollector.getInputCollector().getUserInput(INPUT_ENTER_CONTACT_ID);
          Contact contactToRemove = contactList.getContactById(Integer.parseInt(idRemove));

          if(contactToRemove == null) {
            System.out.println(String.format("Contact at index %s does not exists.", idRemove));
            InputCollector.setAsOptionTurn();
            continue;
          }

          contactList.removeContact(contactToRemove);
          InputCollector.setAsOptionTurn();
          continue;

        case UPDATE_CONTACT:
          contactList.getAllContacts();

          String idUpdate = InputCollector.getInputCollector().getUserInput(INPUT_ENTER_CONTACT_ID);
          Contact contactToUpdate = contactList.getContactById(Integer.parseInt(idUpdate));

          if(contactToUpdate == null) {
            System.out.println(String.format("Contact at index %s does not exists.", idUpdate));
            InputCollector.setAsOptionTurn();
            continue;
          }

          String updatedContactName =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_USERNAME);
          String updatedContactEmail =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_EMAIL);
          String updatedContactMobileNumber =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_MOBILE_NUMBER);
          String updatedContactWorkNumber =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_WORK_NUMBER);
          String updatedContactHomeNumber =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_HOME_NUMBER);
          String updatedContactCity =
              InputCollector.getInputCollector().getUserInput(INPUT_ENTER_CITY_NAME);

          Contact updatedContact = new Contact(updatedContactMobileNumber, updatedContactCity);
          updatedContact.setContactName(updatedContactName);
          updatedContact.setContactEmail(updatedContactEmail);

          contactList.updateContact(Integer.parseInt(idUpdate), updatedContact);
          InputCollector.setAsOptionTurn();
          continue;

        case QUITE_PROGRAM:
          stillRunning = false;
          System.out.println("See you later...");
          break;

        default:
          System.out.println("Invalid Input. Enter a number between 1 and 5.");
          continue;
      }
    }
  }

}
