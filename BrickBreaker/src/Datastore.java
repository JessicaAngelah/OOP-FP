import java.io.*;

public class Datastore {
    public static int highScore = 0;
// saves high score in the data.txt file
    public static void saveHighScore(int score) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            outputStream.writeObject(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// resets highscore
    public static void resetHighScore() {
        saveHighScore(0);
    }
// responsible for loading the high score from the data.txt file
    public static void loadHighScore() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.txt"))) {
            highScore = (int) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            highScore = 0;
        }
    }
//retrieves and returns the current value of the highScore (allows other parts of the program to access and use the high score value stored in the variable)
    public static int getHighScore() {
        return highScore;
    }
}
