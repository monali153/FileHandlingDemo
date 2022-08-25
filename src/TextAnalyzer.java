import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        //String fileData = textAnalyzer.readFile("C:\\Users\\Lalit Chaudhari\\OneDrive\\Desktop\\NIIT\\Poem.txt");
        String fileData = textAnalyzer.readFile("resource/Poem.txt");
        System.out.println(fileData);

        String fileName = "resource/output.txt";
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("Enter some text");
        String content = scanner.nextLine();*/
        System.out.println("enter file name without space");
        fileName = scanner.nextLine();
        //adding resource path to it
        fileName = "resource/".concat(fileName);
        textAnalyzer.writeFile(fileData, fileName);
    }

    public String readFile(String poemFileName){
        String response = "";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(poemFileName);
            int data = 0;
            while ((data = fileInputStream.read()) != -1){
                char readData = (char) data;
                response = response + readData;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return response;
    }

    public void writeFile(String content, String fileName) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            byte[] data = content.getBytes();
            fileOutputStream.write(data);
            /*for (int i = 0; i < content.length(); i++) {
                char data = content.charAt(i);
                int  writeData = data;
                fileOutputStream.write(writeData);
            }*/
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
