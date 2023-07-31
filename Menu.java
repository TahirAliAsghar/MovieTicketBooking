
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    protected String movie1,movie2,movie3;
    public static int select;
    Scanner sc = new Scanner(System.in);

    public String getMovie1() {
        return movie1;
    }

    public void setMovie1() {
        System.out.println("Enter movie 1: ");
        movie1 = sc.next();
    }

    public String getMovie2() {
        return movie2;
    }

    public void setMovie2() {
        System.out.println("Enter movie 2: ");
        movie2 = sc.next();
    }

    public String getMovie3() {
        return movie3;
    }

    public void setMovie3() {
        System.out.println("Enter movie 3: ");
        movie3 = sc.next();
    }

    //Initialises the available movies
    public Menu(String movie1,String movie2, String movie3){
        this.movie1 = movie1;
        this.movie2 = movie2;
        this.movie3 = movie3;
    }

    public Menu(){}

    //Main screen of the management system
    public void start() {
        int choice = 0;
        boolean proceed;

        System.out.println();
        System.out.println("-------------------------------   SZABIST ----------------------------------");
        System.out.println("-------------------------- By Tahir & Umaima -------------------------------");
        System.out.println("-------------- Welcome TO Our Movie Ticket Management System ---------------");
        System.out.println("---------------------------------- MENU ------------------------------------");

        do {
            try {
                System.out.println("1. Purchase Ticket\n2. Admin\n3. Exit\nYour choice: ");
                choice = sc.nextInt();
                proceed = true;
            } catch (InputMismatchException e) {
                System.out.println("No such option exists!!");
                proceed = false;
                sc.nextLine();
            }
        }while(!proceed);
        menu(choice);
    }

    public void menu(int choice) {

        if (choice == 1) {
            movies();
        } else if (choice == 2) {
            new Admin(getMovie1(),getMovie2(),getMovie3());
        } else if (choice == 3) {
            System.exit(0);
        }else{
            System.out.println("No such option exists!!");
            start();
        }
    }

    //Movie menu for selecting movies the user wants to buy ticket for
    public void movies() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean proceed;
        String movie = null;
        System.out.println("Please select your choice of movie: " +
                "\n1. " + getMovie1() + " \n2. " + getMovie2() + "\n3. " + getMovie3() + "\n4. Go Back\n");
        choice = sc.nextInt();
        if (choice == 1){
            movie = getMovie1();
        }
        else if(choice == 2){
            movie = getMovie2();
        }
        else if(choice ==3){
            movie = getMovie3();
        }
        else{
            start();
        }

        System.out.println("SELECT YOUR SEAT");
        seat(); //Displaying seats
        System.out.println();
        do {
            try {
                select = sc.nextInt();
                proceed = true;
                if (select > 50 || select < 1) {
                    throw new Exception("Incorrect seat selected!!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                proceed = false;
            }
        }while (!proceed);

        //creating new ticket object
        ticket tik = new ticket(choice,movie);

        System.out.println("Ticket purchased successfully!");
        System.out.println();
        tik.display();
        System.out.println("Heading back to main menu!");
        start();
    }

    //Seat function
    public static void seat() {
        for (int i = 1; i <= 50; i++) {
            if ((i - 1) % 10 == 0) {
                System.out.println();
            }
            if ((i - 1) % 5 == 0) {
                System.out.print("\t\t");
            }
            if (i < 10) {
                System.out.print(0);
            }
            System.out.print(i + " ");
        }
    }
}