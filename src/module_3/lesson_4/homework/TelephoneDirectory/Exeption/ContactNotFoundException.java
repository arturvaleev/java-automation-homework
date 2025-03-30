package module_3.lesson_4.homework.TelephoneDirectory.Exeption;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String lastName) {
        super("Ошибка: Контакт с фамилией " + lastName + " отсутствует в телефонном справочнике!");
    }
}
