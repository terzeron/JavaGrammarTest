package try_with_resources;

import java.io.*;

public class TryWithResourcesTest {
    public static void main(String[] args) throws FileNotFoundException {

        try (
                FileReader fr = new FileReader("input.txt");
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line;
            while (null != (line = br.readLine())) {
                // processing each line of file
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
