package FileMenu;

import Shared.Screen;

import java.util.ArrayList;

public class FileOptions implements Screen {

    private final ArrayList<String> options = new ArrayList<>();
    FileOperations file = new FileOperations();

    public FileOptions() {
        options.add("1. Add A File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
    }
    @Override
    public void Show() {
        System.out.println();
        System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }
    }
    @Override
    public void NavigateOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Adding File...");
                file.AddFile();
                break;
            case 2:
                System.out.println("Deleting File...");
                file.DeleteFile();
                break;
            case 3:
                System.out.println("Searching the file...");
                file.SearchFile();
                break;
        }
    }
    @Override
    public void GetUserInput() {
        //char ch = 'y';
        int sch = 0;
        while (sch != 4) {
            this.Show();
            System.out.print("Enter the choice : ");
            sch = sc.nextInt();
            this.NavigateOption(sch);
        }
    }
}
