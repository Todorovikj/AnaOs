import java.io.*;

public class ReadAndWriteFiles {
    public static void main(String[] args) {

        try {
            System.out.println("reading from src/test and writing \n");
            readAndPrintFileData("src/test.txt");

            System.out.println("\n\n\n");

            System.out.println("writing to some file, with append");
            writeDataToFile("Testing output", "src/testoutput.txt", true);

            System.out.println("\n\n\n");

            System.out.println("Copying test.txt to some other file");
            copyFileContent("src/test.txt", "src/copiedTest.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void copyFileContent(String source, String destination) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-8"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination, false), "UTF-8"));
        String line = "";
        while ((line = in.readLine()) != null) {
            out.write(line + "\n");
        }
        out.flush();
        in.close();
        out.close();
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

    public static void writeDataToFile(String content, String path, Boolean append) throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(path, append));
        bf.write(content);
        bf.flush();
        bf.close();
    }
}
