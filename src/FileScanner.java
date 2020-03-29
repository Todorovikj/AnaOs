import java.io.File;

public class FileScanner extends Thread {

    private String fileToScan;
    //TODO: Initialize the start value of the counter
    private static Long counter = 0L;

    public FileScanner(String fileToScan) {
        this.fileToScan = fileToScan;
        //TODO: Increment the counter on every creation of FileScanner object
        //may end up with a lock
        this.counter++;
    }

    public static void printInfo(File file) {
        /*
         * TODO: Print the info for the @argument File file, according to the requirement of the task
         */

        StringBuilder sb = new StringBuilder();
        if (file.isDirectory()) {
            sb.append("dir: ");
        } else {
            sb.append("file: ");
        }
        sb.append(file.getAbsolutePath()).append(" ").append(file.length());
        System.out.println(sb.toString());
    }

    public static Long getCounter() {
        return counter;
    }


    public void run() {
//TODO Create object File with the absolute path fileToScan.
        File file = new File(fileToScan);

        //TODO Create a list of all the files that are in the directory file.
        File[] files = file.listFiles();


        for (File f : files) {
            /*
             * TODO If the File f is not a directory, print its info using the function printInfo(f)
             *
             * */

            /*
             * TODO If the File f is a directory, create a thread from type FileScanner and start it.
             *
             *
             */
            //TODO: wait for all the FileScanner-s to finish
            if (!f.isDirectory()) {
                printInfo(f);
            } else {
                // this printing iS NOT A REQUEST FROM THE TASK IT IS ONLY FOR DEMONSTRATION!!!
                printInfo(f);

                FileScanner fs = new FileScanner(f.getAbsolutePath());
                fs.start();
                try {
                    fs.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public static void main(String[] args) {
        String FILE_TO_SCAN = "C:\\Users\\189075\\Desktop\\lab";

        //TODO Construct a FileScanner object with the fileToScan = FILE_TO_SCAN
        FileScanner fileScanner = new FileScanner("/home/neco/Desktop/neco_fakultet/projects/AnaOS/FileScannerTest");

        //TODO Start the thread from type FileScanner
        fileScanner.start();
        //TODO wait for the fileScanner to finish
        try {
            fileScanner.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        //TODO print a message that displays the number of thread that were created
        System.out.println(FileScanner.getCounter());

    }
}
