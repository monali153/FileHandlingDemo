import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonalDetails {

    String name;
    String mobile;
    String email;
    String address;

    public PersonalDetails(String name, String email, String mobile, String address) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public static void main(String[] args) {

        PersonalDetails personalDetails = new PersonalDetails("Monali", "sona123@gmail.com", "9526142366", "Pune");

        personalDetails.writeFile(personalDetails.name, personalDetails.email, personalDetails.mobile, personalDetails.address, "resource/details.txt");

        System.out.println(personalDetails.readFile("resource/details.txt"));
    }

    public void writeFile(String name, String email, String mobile, String address, String fileName) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            byte[] data1 = name.getBytes();
            fileOutputStream.write(data1);
            fileOutputStream.write(10);
            byte[] data2 = email.getBytes();
            fileOutputStream.write(data2);
            fileOutputStream.write(10);
            byte[] data4 = mobile.getBytes();
            fileOutputStream.write(data4);
            fileOutputStream.write(10);
            byte[] data3 = address.getBytes();
            fileOutputStream.write(data3);


        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String readFile(String fileName) {
        String response = "";
        FileInputStream fileInputStream = null;
        try {
            int data = 0;
            fileInputStream = new FileInputStream(fileName);

            while ((data = fileInputStream.read()) != -1) {
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
}
