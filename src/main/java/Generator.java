import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
    private static final int SIZE = 50000;

    public static void main(String[] args) throws IOException {
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("nums_1.txt"));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("nums_2.txt"));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("nums_3.txt"));
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            writer1.write(random.nextInt(5000) + " ");
        }
        writer1.close();

        for (int i = 0; i < SIZE; i++) {
            writer2.write(random.nextInt(5000) + " ");
        }
        writer2.close();

        for (int i = 0; i < SIZE; i++) {
            writer3.write(random.nextInt(5000) + " ");
        }
        writer3.close();

        System.out.println("Done!");
    }
}
