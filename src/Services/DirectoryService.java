package Services;

import Shared.Directory;

import java.io.File;

public class DirectoryService {
    private static final Directory fileDirectory = new Directory();

    public static void PrintFiles() {
        fileDirectory.fillFiles();
        for (File file : DirectoryService.getFileDirectory().getFiles())
            System.out.println(file.getName());
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }
    public static String Path() {
        return fileDirectory.path.toString();        // return fileDirectory.name;
    }
}
