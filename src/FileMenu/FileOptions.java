package FileMenu;

import Shared.Screen;

import java.util.ArrayList;

public class FileOptions implements Screen {

    private ArrayList<String> options = new ArrayList<>();
    FileOperations file = new FileOperations();

    public FileOptions() {
        options.add("1. Add A File");
        options.add("2. Delete A File");
        options.add("3. Adding Content in a File");
        options.add("4. Search A File");
        options.add("5. Return to Menu");
    }

    @Override
    public void Show() {
        System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {
            case 1:
                System.out.println("Adding File...");
                file.AddFile();
                break;
            case 2:
                System.out.println("Deleting File...");
                file.DeleteFile();
                break;
            case 3:
                System.out.println("Adding Content in a File...");
                file.AddingContentInFile();
                break;
            case 4:
                System.out.println("Searching the file...");
                file.SearchFile();
                break;
            default:
                break;
        }
    }

    @Override
    public void GetUserInput() {
        char ch = 'y';
        int sch;
        while(ch == 'y' || ch == 'Y')   {
            this.Show();
            System.out.print("Enter the choice : ");
            sch = sc.nextInt();
            this.NavigateOption(sch);
            System.out.println("Do You Want to Continue with File Menu.. ? (Y/N)");
            ch = sc.next().charAt(0);
        }
    }
}
