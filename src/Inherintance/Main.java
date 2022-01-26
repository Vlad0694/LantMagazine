package Inherintance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        String before = null;

        boolean retine = false;
        while (true) {

            if (before == null || Integer.parseInt(before) == 1) {
               if(retine == false) {
                   System.out.println("1 - Meniu afisare");
               }
                if(before != null){
                    System.out.println("2 - Meniu Cumparare");
                    System.out.println("3 - Meniu Returnare");
                    System.out.println("4 - Meniu KFC");
                }
            }
            if (before == null || Integer.parseInt(before) == 2) {
                if(retine == false) {
                    System.out.println("2 - Meniu cumparare");
                }
                if(before != null){
                    System.out.println("1 - Meniu Afisare");
                    System.out.println("3 - Meniu Returnare");
                    System.out.println("4 - Meniu KFC");
                }
            }
            if (before == null || before.equals("3")) {
                System.out.println("3 - Meniu Returnare");
            }
            if (before == null || before.equals("4")) {
                System.out.println("4 - Meniu KFC");
            }
            System.out.println("5 - Exit");

            retine = true;
            String comandataTastatura = key.nextLine();
            if (comandataTastatura.equals("1")) {
                System.out.println("Meniu Afisare");
                System.out.println("---------------");
                System.out.println("---------------");
                System.out.println("---------------");
                before = comandataTastatura;
            }

            if (comandataTastatura.equals("2")) {
                System.out.println("Meniu cumparare");
                System.out.println("---------------");
                System.out.println("---------------");
                System.out.println("---------------");
                before = comandataTastatura;
            }
            if (comandataTastatura.equals("3")) {
                System.out.println("Meniu Returnare");
                System.out.println("---------------");
                System.out.println("---------------");
                System.out.println("---------------");
                before = comandataTastatura;
            }
            if (comandataTastatura.equals("4")) {
                System.out.println("Meniu KFC");
                System.out.println("---------------");
                System.out.println("---------------");
                System.out.println("---------------");
                before = comandataTastatura;
            }

            if (comandataTastatura.equals("5")) {
                break;
            }
        }

    }
}
