package module_3.lesson_4.homework.TelephoneDirectory;

import module_3.lesson_4.homework.TelephoneDirectory.Exeption.ContactNotFoundException;
import module_3.lesson_4.homework.TelephoneDirectory.Exeption.DuplicatePhoneNumberException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TelephoneDirectory {

    private Map<String, HashSet<String>> telephoneDirectory;

    public TelephoneDirectory() {
        this.telephoneDirectory = new HashMap<>();
    }

    public void add (String lastName, String phone) throws DuplicatePhoneNumberException {

        if (telephoneDirectory.containsKey(lastName)) {
            HashSet<String> phoneNumbers = telephoneDirectory.get(lastName);

            if (phoneNumbers.contains(phone)){
                throw new DuplicatePhoneNumberException(lastName);
            }

        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phone);
            telephoneDirectory.put(lastName, phoneNumbers);
        }
    }

    public HashSet<String> get (String lastName) throws ContactNotFoundException {

        if(telephoneDirectory.containsKey(lastName)){
            return telephoneDirectory.get(lastName);
        } else {
            throw new ContactNotFoundException(lastName);
        }
    }
}




