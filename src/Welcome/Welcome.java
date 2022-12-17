package Welcome;

import Services.DirectoryService;
import Services.ScreenService;
import Shared.Screen;

import java.util.ArrayList;

public class Welcome implements Screen {

    private String welcomeText = "Welcome to JAVA FSV : Project 1";
    private String developerText = "Developed By Anurag Sharma";

    private ArrayList<String> options = new ArrayList<>();


    public Welcome() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    public void introScreen() {
        System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println();
        System.out.println("Directory : " + DirectoryService.Path());
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
            default:
                break;
        }

    }
    @Override
    public void GetUserInput() {
        char ch = 'y';
        int sch = 0;
        while(sch != 3) {
            this.Show();
            System.out.print("Enter the choice : ");
            sch = sc.nextInt();
            this.NavigateOption(sch);
        }
    }
}
