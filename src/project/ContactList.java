package project;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

  private List<Contact> contactList;

  public ContactList() {
    this.contactList = populateContactList();
  }

  private List<Contact> populateContactList() {
    List<Contact> populatedContactList = new ArrayList<>();

    Contact stark = new Contact("202-555-0540", "San Francisco");
    stark.setContactName("Anthony Stark");
    populatedContactList.add(stark);

    Contact morales = new Contact("202-555-0392", "New York");
    morales.setContactName("Miles Morales");
    populatedContactList.add(morales);

    return populatedContactList;
  }

  public void getAllContacts() {
    for(int index = 0; index < this.contactList.size(); index++) {
      Contact contact = this.contactList.get(index);

      String contactPattern = "%o. <%s> (mobile=%s, home=%s, work=%s, email=%s, city=%s)";
      String formattedContact = String.format(contactPattern,
          index,
          contact.getContactName(),
          contact.getMobilePhoneNumber(),
          contact.getHomePhoneNumber(),
          contact.getWorkPhoneNumber(),
          contact.getContactEmail(),
          contact.getContactCity());
      System.out.println(formattedContact);
    }
  }

  public Contact getContactById(int contactId) {
    if (contactId <= this.contactList.size()) {
      return this.contactList.get(contactId);
    } else {
      return null;
    }
  }

  public void addContact(Contact contact) {
    this.contactList.add(contact);
  }

  public void removeContact(Contact contact) {
    this.contactList.remove(contact);
  }

  public void updateContact(int indexOfContact, Contact contact) {
    this.contactList.set(indexOfContact, contact);
  }

}
