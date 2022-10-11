import java.util.Scanner;

public class StepTracker {
    int target = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void saveSteps(Scanner scanner) {

        int month = 0;
        int day = 0;
        int steps = 0;

        while (true) {
            System.out.println("Введите месяц в формате от 0 до 11");
            int input = scanner.nextInt();
            if (input >= 0 && input < 12) {
                month = input;
                break;
            } else {
                System.out.println("Нужно ввести месяц в формате от 0 до 11");
            }
        }

        while (true) {
            System.out.println("Введите день в формате от 1 до 30");
            int input = scanner.nextInt();
            if (input > 0 && input <= 30) {
                day = input;
                break;
            } else {
                System.out.println("Нужно ввести день в формате от 1 до 30");
            }
        }

        while (true) {
            System.out.println("Введите количество шагов");
            int input = scanner.nextInt();
            if (input > 0) {
                steps = input;
                break;
            } else {
                System.out.println("Количество шагов не может быть отрицательным");
            }
        }

        monthToData[month].days[day - 1] += steps;
    }

    public void printStatistics(Scanner scanner) {
        System.out.println("Введите номер месяца, за который хотите получить статистику");
        int inputMonth = scanner.nextInt();
        Converter converter = new Converter();
        stepsInDay(inputMonth);
        System.out.println("Общее количество шагов за " + inputMonth + " месяц: " + totalStepsInMonth(inputMonth));
        System.out.println("Максимальное количество шагов в " + inputMonth + " месяце: " + maxStepsInMonth(inputMonth));
        System.out.println("Среднее количество шагов в " + inputMonth + " месяце: " + totalStepsInMonth(inputMonth) / 30);
        converter.convertDistance(totalStepsInMonth(inputMonth));
        converter.convertCalorie(totalStepsInMonth(inputMonth));
        System.out.println("Лучшая серия дней, когда была достигнута цель: " + bestSeriesSteps(inputMonth));
    }

    public void stepsInDay(int month) {
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (i == monthToData[month].days.length - 1) {
                System.out.print(i + 1 + " день: " + monthToData[month].days[i]);
                System.out.println();
            } else {
                System.out.print(i + 1 + " день: " + monthToData[month].days[i] + ", ");
            }

        }
    }

    public int totalStepsInMonth(int month) {
        int count = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            count += monthToData[month].days[i];
        }
        return count;
    }

    public int maxStepsInMonth(int month) {
        int max = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (max < monthToData[month].days[i]) {
                max = monthToData[month].days[i];
            }
        }
        return max;
    }

    public int bestSeriesSteps(int month) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] >= target) {
                count++;
                if (result < count) {
                    result = count;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }


    public void changeTargetSteps(Scanner scanner) {
        while (true) {
            System.out.println("Введите целевое количетсво шагов");
            int input = scanner.nextInt();
            if (input > 0) {
                target = input;
                break;
            } else {
                System.out.println("Количество шагов не может быть отрицательным");
            }
        }
    }

    class MonthData {
        int[] days = new int[30];
    }
}
