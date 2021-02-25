package oblom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


public class MainClass {
    private static DictionaryIO dictionary;
    private static final Scanner scanner = new Scanner(System.in);
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DictConfig.class);

    public static void main(String[] args) throws IOException {
        dictionary = applicationContext.getBean(DictionaryIO.class);
        System.out.println("Добро пожаловать в каталог словарей.");
        while (true){
            welcomeMessages();
            System.out.println("\n======================================================");
            System.out.print(dictionary.readAllFromDictionary());
            System.out.println("======================================================");
            chooseAction();
        }

    }
    private static void welcomeMessages(){
        while (true) {
            System.out.println("Пожалуйста, выберите исходный язык словаря:");
            System.out.println("1. Английский;\n2. Числовой;\n0. Выход из каталога.");
            String choice = scanner.next();
            if(choice.equals("0")) System.exit(0);
            try {
                FileInputStream fileInputStream = new FileInputStream("src/main/resources/dictionaryProps.properties");
                Properties dictProps = new Properties();
                dictProps.load(fileInputStream);
                String[] properties = dictProps.getProperty(choice).split(";");
                dictionary.setValidCheckString(properties[0]);
                dictionary.setValueLength(Integer.parseInt(properties[1]));
                dictionary.setPathToDictionary(properties[2]);
                break;
            }
            catch (Exception e) {
                System.out.println("Ошибка: неверный номер действия.");
            }
        }

    }
    private static void chooseAction() throws IOException {
        while (true) {
            ValueModel value = applicationContext.getBean(ValueModel.class);
            System.out.println("1. Добавить значение;");
            System.out.println("2. Найти значение по ключу;");
            System.out.println("3. Удалить значение по ключу");
            System.out.println("0. Вернуться к выбору словаря");
            int actNumber = scanner.nextInt();
            scanner.nextLine();
            switch (actNumber) {
                case 1: {
                    System.out.println("Введите слово: ");
                    value.setOriginal(scanner.nextLine());
                    System.out.println("Введите перевод: ");
                    value.setTranslate(scanner.nextLine());
                    if (!dictionary.writeToDictionary(value)) System.out.println("Ошибка: недопустимое значение.");
                    else System.out.println("Данные успешно добавлены.\n");
                    continue;
                }
                case 2:  {
                    System.out.print("Введите слово: ");
                    String word = scanner.next();
                    String findedValue = dictionary.findStringFromDictionary(word);
                    if (findedValue != null) System.out.println(findedValue);
                    else System.out.println("Значение не найдено");
                    continue;
                }
                case 3:  {
                    System.out.print("Введите слово: ");
                    String word = scanner.next();
                    if (dictionary.findStringFromDictionary(word) != null) {
                        dictionary.deleteStringFromDictionary(word);
                        System.out.println("Данные удалены.");
                    } else System.out.println("Значение не найдено");
                    continue;
                }
                case 0:  {
                    return;
                } default: {
                    System.out.println("Ошибка: неверный номер действия.");
                }
            }
        }
    }
}
