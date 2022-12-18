package Welcome;

import Services.DirectoryService;
import Services.ScreenService;
import Shared.Screen;

import java.util.ArrayList;

public class Welcome implements Screen {

    final String welcomeText = "***LOCKEDME.COM***";
    final String developerText = "->Developed By Anurag Sharma";

    private final ArrayList<String> options = new ArrayList<>();


    public Welcome() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    public void introScreen() {
        System.out.println();
        System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("============================");
        System.out.println();
        System.out.println("Directory : " + DirectoryService.getFileDirectory().name);
    }
    @Override
    public void Show() {
        System.out.println();
        System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }
    }
    @Override
    public void NavigateOption(int option) {
        switch(option) {
            case 1:
                DirectoryService.PrintFiles();
                break;
            case 2:
                ScreenService.setCurrentScreen();
                break;
            case 3:
                System.out.println("\nThank You!!!");
            default:
                break;
        }
    }
    @Override
    public void GetUserInput() {
        int sch = 0;
        char ch;
        while(sch != 3) {
            this.Show();
            System.out.print("Enter the choice : ");
            ch = sc.next().charAt(0); //sch = sc.nextInt();
            sch = (int)ch - 48;
            this.NavigateOption(sch);
        }
    }
}