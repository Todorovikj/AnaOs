import java.io.*;

public class ReadFromFileAndInputExample {
    public static void main(String[] args) {
        try {
            readAndPrintFileData("src/test.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n\n\n");

        try {
            readFromStandardInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readAndPrintFileData(String path) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        StringBuilder fileContent = new StringBuilder();
        String line = "";
        while ((line = in.readLine()) != null) {
            fileContent.append(line).append("\n");
        }

        System.out.print(fileContent.toString());

        in.close();
    }

    public static void readFromStandardInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter text, press Ctrl+Z to quit? Enter empty line to quit");
        StringBuilder content = new StringBuilder();
        String line = "";
        while ((line = in.readLine()) != null && line.length() > 0) {
            content.append(line).append("\n");
        }
        System.out.println(content.toString());
        in.close();
    }
}
