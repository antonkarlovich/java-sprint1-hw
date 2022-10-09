import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();


        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                stepTracker.saveSteps(scanner);
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 2) {
                stepTracker.printStatistics(scanner);
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 3) {
                stepTracker.changeTargetSteps(scanner);
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 4) {
                break;
            } else {
                System.out.println("Такой команды нет");
                printMenu();
                userInput = scanner.nextInt();
            }
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выйти из приложения");
    }
}
