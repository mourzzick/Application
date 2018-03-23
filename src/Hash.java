import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Hash {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        long startTime = System.nanoTime();
        File file = new File("C:\\Users\\Name\\Desktop\\New folder");
        File[] files = file.listFiles();
        ArrayList<String> hashes = new ArrayList<>();
        ArrayList<String> notDupHashes = new ArrayList<>();
        for (File element : files) {
            Path path = Paths.get(element.getAbsolutePath());

            if (path.toString().contains(".jpg")) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(Files.readAllBytes(path));
                byte[] digest = md.digest();
                String myMD5 = DatatypeConverter.printHexBinary(digest).toUpperCase();
                System.out.println(myMD5);
                hashes.add(myMD5);
            }
        }

        for (String str : hashes) {
            if (notDupHashes.contains(str)) {
                System.out.println("Yes");
            } else {
                notDupHashes.add(str);
                System.out.println(str);
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);

    }

}
