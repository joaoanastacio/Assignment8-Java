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

    Contact stark =
        new Contact("Anthony Stark", "202-555-0540");
    populatedContactList.add(stark);

    Contact morales =
        new Contact("Miles Morales", "202-555-0392");
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

  public void removeContact(Contact contact) {
    this.contactList.remove(contact);
    System.out.println("Successfully removed " + contact.getContactName());
  }

  public void addContact(Contact contact) {
    if(validateContact(contact)) {
      this.contactList.add(contact);
      System.out.println("Successfully added a new contact!");
    }
  }

  public void updateContact(int indexOfContact, Contact contact) {
    this.contactList.set(indexOfContact, contact);
    System.out.println("Successfully updated contact!");
  }

  private boolean validateContact(Contact contact) {
    for(Contact storedContact : this.contactList) {
      if (storedContact.getContactName().equals(contact.getContactName())) {
        throw new IllegalArgumentException("Unable to add contact. "
            + "You already have a contact with the same name");
      }

      if(storedContact.getMobilePhoneNumber().equals(contact.getMobilePhoneNumber())) {
        throw new IllegalArgumentException("Unable to add contact. "
            + "You already have a contact with the same mobile phone number");
      }
    }
    return true;
  }

}
