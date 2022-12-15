package Shared;

import java.util.Scanner;

public interface Screen {

    Scanner sc = new Scanner(System.in);
    public void Show();
    public void NavigateOption(int option);
    public void GetUserInput();
}
