package Shared;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Directory {

    public String name = "src/Storage/";
    private final ArrayList<File> files = new ArrayList<>();

    public Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    File Dfiles = path.toFile();

    public void fillFiles() {
        File[] directoryFiles = Dfiles.listFiles();

        files.clear();
        if (directoryFiles != null) {
            for (File directoryFile : directoryFiles)
                if (directoryFile.isFile())
                    files.add(directoryFile);
        }

        Collections.sort(files);
    }

    public ArrayList<File> getFiles() {
        fillFiles();
        return files;
    }
}
