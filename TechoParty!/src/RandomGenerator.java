import java.util.Random;


public class RandomGenerator {
    
    public static double randomDouble()
    {
        Random random = new Random();
        double randomDouble = random.nextDouble();
        return randomDouble;
    }






    public static int sleepTime(int k)
    {
        Random random = new Random();
        int minValue = Math.round((k)/2);
        int maxValue = Math.round((k*3)/2);
        int time = random.nextInt(maxValue - minValue + 1) + minValue;

        return time;
    }
}
