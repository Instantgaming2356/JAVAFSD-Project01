package FileMenu;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Scanner;

import Services.DirectoryService;

public class FileOperations {

    Scanner sc = new Scanner(System.in);
    String filename;
    char ch;

    public void AddFile()   {
        System.out.print("Please Enter the file name with extension to Create : ");
        filename = sc.nextLine();

        File file = new File(DirectoryService.Path() + "/" + filename);
        try {
            boolean val = file.createNewFile();
            if(val) {
                System.out.println("File Created!!!");
                System.out.println("Do You Want to add Content");
                ch = sc.next().charAt(0);
                if(ch == 'Y' || ch == 'y') {
                    System.out.print("Enter the New Content : ");
                    sc.nextLine();
                    String fileData = sc.nextLine();
                    try {
                        FileWriter writeData = new FileWriter(DirectoryService.Path() + "/" + filename);
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

        File file = new File(DirectoryService.Path() + "/" + filename);
        try {
            boolean val = file.delete();
            if(val) System.out.println("File Deleted!!!");
            else System.out.println("Unable to Delete");

        } catch(Exception e)	{
            e.printStackTrace();
        }
    }
    public void SearchFile() {
        boolean found = false;

        System.out.println("Please Enter the Filename:");
        String fileName = sc.nextLine();
        System.out.println("You are searching for a file named: " + fileName);

        Path path = DirectoryService.getFileDirectory().path;
        File Dfiles = path.toFile();

        File[] directoryFiles = Dfiles.listFiles();

        if (directoryFiles != null) {
            for (File directoryFile : directoryFiles)
                if (directoryFile.getName().equals(fileName)) {
                    System.out.println("Found " + fileName);
                    found = true;
                }
        }
        if (!found)
            System.out.println("File not found");
    }
}