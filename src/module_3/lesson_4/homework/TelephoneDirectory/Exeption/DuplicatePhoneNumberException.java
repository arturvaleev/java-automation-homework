package module_3.lesson_4.homework.TelephoneDirectory.Exeption;

public class DuplicatePhoneNumberException extends RuntimeException {
    public DuplicatePhoneNumberException(String lastname) {
        super("Ошибка: Данный номер уже добавлен для контакта " + lastname + "!");
    }
}
