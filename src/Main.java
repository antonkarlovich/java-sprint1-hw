import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();


        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTracker.saveSteps(scanner);

            } else if (userInput == 2) {
                stepTracker.printStatistics(scanner);

            } else if (userInput == 3) {
                stepTracker.changeTargetSteps(scanner);

            } else if (userInput == 4) {
                break;
            } else {
                System.out.println("Такой команды нет");
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
