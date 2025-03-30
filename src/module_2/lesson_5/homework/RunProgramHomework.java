package module_2.lesson_5.homework;
import java.util.Random;

public class RunProgramHomework {

    public static Random random = new Random();

    public static void main(String[] args) {

        int numberOfEmployees = 5;
        Employee[] employees = new Employee[numberOfEmployees];      //Объявил массив объектов

        for (int i = 0; i < employees.length; i++){                                                                                                                    //Задал объект каждой ячейке массива, с рандомными полями
            employees[i] = new Employee(getRandomFullName(), getRandomPosition(), getRandomEmail(), getRandomPhoneNumber(), getRandomSalary(), getRandomAge());
        }

        for (int i = 0; i < employees.length; i++){                 //С помощью цикла вывожу информацию только о сотрудниках старше 40 лет
            if (employees[i].getAge() > 40){
                EmployeePrinter.printEmployee(employees[i]);
            }
        }

    }

    public static String getRandomFullName() {
        String[] femaleNames = {
                "Анна", "Мария", "Екатерина", "Ольга", "Наталья",
                "Ирина", "Татьяна", "Елена", "Светлана", "Алиса",
                "Полина", "Вероника", "Виктория", "Анастасия", "Дарья"
        };

        String[] femaleSurnames = {
                "Иванова", "Смирнова", "Кузнецова", "Попова", "Васильева",
                "Петрова", "Соколова", "Михайлова", "Новикова", "Фёдорова",
                "Морозова", "Волкова", "Алексеева", "Лебедева", "Семёнова"
        };

        String[] femalePatronymics = {
                "Александровна", "Максимовна", "Дмитриевна", "Ивановна", "Артёмовна",
                "Никитична", "Егоровна", "Михайловна", "Андреевна", "Владимировна",
                "Сергеевна", "Павловна", "Алексеевна", "Константиновна", "Олеговна"
        };

        String[] maleNames = {
                "Александр", "Максим", "Дмитрий", "Иван", "Артём",
                "Никита", "Егор", "Михаил", "Андрей", "Владимир",
                "Сергей", "Павел", "Алексей", "Константин", "Олег"
        };

        String[] maleSurnames = {
                "Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев",
                "Петров", "Соколов", "Михайлов", "Новиков", "Фёдоров",
                "Морозов", "Волков", "Алексеев", "Лебедев", "Семёнов"
        };

        String[] malePatronymics = {
                "Александрович", "Максимович", "Дмитриевич", "Иванович", "Артёмович",
                "Никитич", "Егорович", "Михайлович", "Андреевич", "Владимирович",
                "Сергеевич", "Павлович", "Алексеевич", "Константинович", "Олегович"
        };

        int isFemale = getRandomValue(0, 1);

        if (isFemale == 0) {
            return maleSurnames[getRandomValue(0, maleSurnames.length - 1)] + " "
                   + maleNames[getRandomValue(0, maleNames.length - 1)] + " "
                   + malePatronymics[getRandomValue(0, malePatronymics.length - 1)];
        } else {
            return femaleSurnames[getRandomValue(0, femaleSurnames.length - 1)] + " "
                   + femaleNames[getRandomValue(0, femaleNames.length - 1)] + " "
                   + femalePatronymics[getRandomValue(0, femalePatronymics.length - 1)];
        }
    }

    public static String getRandomPosition(){
        String[] positions = {
                "QA Automation", "QA Engineer", "Frontend Developer", "Backend Developer", "Fullstack Developer",
                "DevOps Engineer", "System Administrator", "Product Manager",
                "Database Administrator"
        };

        return positions[getRandomValue(0, 8)];
    }

    public static String getRandomEmail(){
        String[] domains = {"loodsen.ru", "mail.ru", "yandex.ru", "rambler.ru", "gmail.com", "outlook.com"};
        return "" + (char)getRandomValue(97, 122) + (char)getRandomValue(97, 122) + (char)getRandomValue(97, 122) + "@" + domains[getRandomValue(0, 5)];
    }

    public static String getRandomPhoneNumber(){
        return "+79" + getRandomValue(10, 99) + getRandomValue(100, 999) + getRandomValue(1000, 9999);
    }

    public static int getRandomSalary(){
        return getRandomValue(120000, 1000000);
    }

    public static int getRandomAge(){
        return getRandomValue(21, 75);
    }

    public static int getRandomValue(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }

}
