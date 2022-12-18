package Shared;

import java.util.Scanner;

public interface Screen {

    Scanner sc = new Scanner(System.in);
    void Show();
    void NavigateOption(int option);
    void GetUserInput();
}