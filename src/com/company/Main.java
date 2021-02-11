package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static DictionaryIO dictionary = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в каталог словарей.");
        while (true){
            welcomeMessages();
            System.out.println("\n======================================================");
            System.out.print(Main.dictionary.readAllFromDictionary());
            System.out.println("======================================================");
            chooseAction();
        }
    }
    private static void welcomeMessages(){
        while (true) {
            System.out.println("Пожалуйста, выберите исходный язык словаря:");
            System.out.println("1. Английский;\n2. Числовой;\n0. Выход из каталога.");
            int dictNumber = scanner.nextInt();
            switch (dictNumber) {
                case 1:{
                    dictionary = new DictionaryEnToRuIO();
                    return;
                }
                case 2:{
                    dictionary = new DictionaryNumbToRuIO();
                    return;
                }
                case 0: {
                    System.exit(0);
                }
                default:System.out.println("Ошибка: словарь не найден.");
            }
        }
    }
    private static void chooseAction() throws IOException {
        while (true) {
            System.out.println("1. Добавить значение;");
            System.out.println("2. Найти значение по ключу;");
            System.out.println("3. Удалить значение по ключу");
            System.out.println("0. Вернуться к выбору словаря");
            int actNumber = scanner.nextInt();
            scanner.nextLine();
            switch (actNumber) {
                case 1: {
                    System.out.println("Введите слово: ");
                    String word = scanner.nextLine();
                    System.out.println("Введите перевод: ");
                    String translate = scanner.nextLine();
                    Value value = new Value(word, translate);
                    if (!dictionary.writeToDictionary(value)) System.out.println("Ошибка: недопустимое значение.");
                    else System.out.println("Данные успешно добавлены.\n");
                    continue;
                }
                case 2:  {
                    System.out.print("Введите слово: ");
                    String word = scanner.next()+" -";
                    String wordAndDash = word.substring(0, 6);
                    String findedValue = dictionary.findStringFromDictionary(wordAndDash);
                    if (findedValue != null) System.out.println(findedValue);
                    else System.out.println("Значение не найдено");
                    continue;
                }
                case 3:  {
                    System.out.print("Введите слово: ");
                    String word = scanner.next()+" -";
                    String wordAndDash = word.substring(0, 6);
                    if (dictionary.findStringFromDictionary(wordAndDash) != null) {
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
