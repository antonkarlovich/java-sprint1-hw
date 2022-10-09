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
        System.out.println("Введите месяц");
        int inputMonth = scanner.nextInt();
        System.out.println("Введите день");
        int inputDay = scanner.nextInt();
        System.out.println("Введите количество шагов");
        int inputSteps = scanner.nextInt();

        monthToData[inputMonth].days[inputDay - 1] += inputSteps;
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
            System.out.println(i+1 + " день: " + monthToData[month].days[i]);
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
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        return result;
    }

    public void changeTargetSteps(Scanner scanner) {
        System.out.println("Введите целевое количетсво шагов");
        int inputSteps = scanner.nextInt();
        if (inputSteps > 0) {
            target = inputSteps;
        }
    }

    class MonthData {
        int[] days = new int[30];
    }
}