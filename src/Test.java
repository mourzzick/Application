import java.io.File;
import java.util.ArrayList;

public class Test {
    public static int fold = 0;
    public static int fil = 0;
    public static ArrayList<String> size = new ArrayList<>();

    //File[] listOfFiles = folder.listFiles();

    public static void main(String[] args) {
        File folder = new File("D:\\Ruslan\\Photos Go Here");
        listDir(folder);
        System.out.println("There was " + Test.fold + " folders");
        System.out.println("There was " + Test.fil + " files");
        for (int i = 0; i < Test.size.size(); i++) {
            System.out.println(Test.size.get(i));
        }
    }

    public static void listDir(File folder) {

        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Test.size.add(listOfFiles[i].getName());
                System.out.println(listOfFiles[i].getAbsolutePath());
                Test.fil++;
            } else {
                listDir(listOfFiles[i]);
                System.out.println("FOLDER");
                Test.fold++;
            }
        }
    }
}
