import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileReader {

    public static char[][] readFile(String path) {
        List<String> list = new ArrayList<>();

        try{

            File txtfile = new File(path);
            Scanner reader = new Scanner(txtfile);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                list.add(line);
            }
            reader.close();
        }

        catch (FileNotFoundException e){
            System.err.println("File not found");
        }

        return list.stream().map(String::toCharArray).toArray(char[][]::new);
    }

}
