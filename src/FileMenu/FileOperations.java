package FileMenu;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

    Scanner sc = new Scanner(System.in);
    String filename;
    char ch;
    public void AddFile()   {
        System.out.print("Please Enter the file name with extension to Create : ");
        filename = sc.nextLine();

        File file = new File("src/Shared/" + filename);
        try {
            boolean val = file.createNewFile();
            if(val) {
                System.out.println("File Created!!!");
                System.out.println("Do You Want to add Content");
                ch = sc.next().charAt(0);
                if(ch == 'Y' || ch == 'y') {
                    System.out.print("Enter the Overwrite Content : ");
                    sc.nextLine();
                    String fileData = sc.nextLine();
                    try {
                        FileWriter writeData = new FileWriter("src/Shared/" + filename);
                        writeData.write(fileData);
                        System.out.println("Data is successfully added to the file.");
                        writeData.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            else System.out.println("Unable to create");
        } catch(Exception e)	{
            e.printStackTrace();
        }
    }

    public void DeleteFile()    {
        System.out.print("Please Enter the file name with extension to Delete : ");
        filename = sc.nextLine();

        File file = new File("src/Shared/" + filename);
        try {
            boolean val = file.delete();
            if(val) System.out.println("File Deleted!!!");
            else System.out.println("Unable to Delete");

        } catch(Exception e)	{
            e.printStackTrace();
        }
    }

    public void AddingContentInFile()    {
        System.out.println("Please Enter the Filename:");
        String name = "src/Shared";
        String fileName = sc.nextLine();
        System.out.print("Enter the Overwrite Content : ");
        String fileData = sc.nextLine();

        try {
            FileWriter writeData = new FileWriter("src/Shared/" + fileName);
            writeData.write(fileData);
            System.out.println("Data is successfully added to the file.");
            writeData.close();
        } catch(Exception e)	{
            e.printStackTrace();
        }
    }

    public void SearchFile()    {
        Boolean found = false;

        System.out.println("Please Enter the Filename:");
        String fileName = sc.nextLine();
        System.out.println("You are searching for a file named: " + fileName);

        String name = "src/Shared/";
        ArrayList<File> files = new ArrayList<File>();

        Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
        File Dfiles = path.toFile();

        File[] directoryFiles = Dfiles.listFiles();

        for(int i = 0; i < directoryFiles.length; i++)
            if(directoryFiles[i].getName().equals(fileName)) {
                System.out.println("Found " + fileName);
                found = true;
            }
        if (found == false) {
            System.out.println("File not found");
        }
    }
}
