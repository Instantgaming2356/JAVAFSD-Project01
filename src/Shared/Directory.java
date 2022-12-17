package Shared;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Directory {

    public String name = "src/Shared/";
    private final ArrayList<File> files = new ArrayList<File>();

    public Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    File Dfiles = path.toFile();

    public ArrayList<File> fillFiles() {
        File[] directoryFiles = Dfiles.listFiles();

        files.clear();
        for (int i = 0; i < directoryFiles.length; i++)
            if (directoryFiles[i].isFile())
                files.add(directoryFiles[i]);

        Collections.sort(files);
        return files;
    }

    public ArrayList<File> getFiles() {
        fillFiles();
        return files;
    }
}
