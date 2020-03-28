import java.io.File;
import java.io.FilenameFilter;

public class FileClassWorkAround {

    public static void main(String[] args) {
        File fileForDelete = new File("resources/myFiles/folderForDelete");
        File myFile = new File("resources/myFiles");
        System.out.println("Creating myFile using mkdirs: " + myFile.mkdirs());
        System.out.println("Creating fileForDelete using mkdir: " + fileForDelete.mkdir());
        /*
         *  mkdirs makes all the directories in the specified path
         *  mkdir makes only the last specified directory in the path, if the ones before exist
         *  Last modified returns time in ms after some date in 1970, to be more convenient with different time zones
         */
        System.out.println("myFile lastModfied: " + myFile.lastModified());

        System.out.println("fileForDelete exists: " + fileForDelete.exists());
        System.out.println("Deleting fileForDelete: " + fileForDelete.delete());
        /*
         * the result exists in next line depends on the result from mkdir and delete
         */
        System.out.println("fileForDelete exists after delete: " + fileForDelete.exists());

        System.out.println("myFile is an directory?: " + myFile.isDirectory());
        System.out.println("myFile is a file?: " + myFile.isFile());
        System.out.println("myFile has absolute path?: " + myFile.isAbsolute());

        /*
         * this test file is used just to create folder newFolder inside myfiles path, so we
         * can test list.
         */
        File testFile = new File(myFile.getPath()+"/newFolder");
        testFile.mkdir();

        File newFileName = new File("resources/newDirectory");
        System.out.println(myFile.renameTo(newFileName));
        String[] files = newFileName.list();

        System.out.println("Files in: " + newFileName.getAbsolutePath());
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.contains("new");
            }
        };
        System.out.println("Files with fileNameFilter in:  "+ newFileName.getAbsolutePath());
        files = newFileName.list(filenameFilter);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
        System.out.println("Parrent of : "+newFileName.getName()+" is "+newFileName.getParent());
    }
}
