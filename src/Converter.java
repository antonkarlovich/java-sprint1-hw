public class Converter {

    double step = 75;
    double calorie = 50;

    public void convertDistance(double steps) {
        System.out.println("Пройдено: " + steps * step / 100_000 + " км.");
    }

    public void convertCalorie(double steps) {
        System.out.println("За это время вы сожгли " + steps * calorie / 10000 + " килокалорий");
    }
}
