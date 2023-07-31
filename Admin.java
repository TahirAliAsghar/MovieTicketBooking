
import java.util.InputMismatchException;
import java.util.Scanner;

//interface for admin
public class Admin extends Menu implements login {

    private String name;
    private String pass;
    private boolean proceed;
    private int count = 2;

    Scanner sc = new Scanner(System.in);


    public void setName() {
        System.out.println("Enter username: ");
        name = sc.next();
    }

    public void setPass() {
        System.out.println("Enter password: ");
        pass = sc.next();
    }

    //Admin constructor which whenever the admin object is called asks for username and password
    public Admin(String movie1, String movie2, String movie3){
        this.movie1 = movie1;
        this.movie2 = movie2;
        this.movie3 = movie3;
        do {
            setName();
            setPass();
            check();
        }while(!proceed || count<0);
    }

    //check function which checks weather the username and password entered are correct or not
    //gives user 2 retries in case of incorrect
    //directs user to home screen in case all retries exhausted.
    public void check(){
        String upass = "umaima123";
        String uname = "Tahir";

            if (name.equals(uname) && pass.equals(upass)) {
                System.out.println("LOGIN SUCCESSFUL");
                start();
                proceed = true;
            } else {
                proceed = false;
                count--;
                if(count < 0){
                    System.out.println();
                    System.out.println("Too many login attempts try again later!");
                    System.out.println();
                    start();
                }
                System.out.println("Incorrect username or pass " + (count+1) + " attempts left");
                System.out.println();
            }

    }

    //The menu for admin
    //Try catch block added incase of incorrect input
    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean proceed;

        do {
            try {
                System.out.println("--------------ADMIN MENU------------");
                System.out.println("1. Start movie\n 2. Set movies\n 3. Go back to main menu\nYour choice:\s");
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

    //Function the redirects the user choice to its particular function
    @Override
    public void menu(int choice) {

        if (choice == 1) {
            start_movie();
        }
        else if (choice == 2) {
            change_movies();
        }
        else if (choice == 3) {
            Menu m = new Menu(getMovie1(),getMovie2(),getMovie3());
            m.start();
        }
        else{
            System.out.println("No such option exists!!");
            start();
        }
    }

    //Function for starting a particular movie, when the movie is started the record is deleted.
    public void start_movie(){
        int start;
        boolean proceed;
        do {
            try {
                System.out.println("Enter the movie you want to start!\n1."+super.getMovie1()+
                        "\n2."+super.getMovie2()+"\n3."+super.getMovie3());
                start = sc.nextInt();
                System.out.println("Movie started successfully");
                if (start > 3) {
                    throw new Exception("No such option exists!");
                }
                proceed = true;
            }catch(InputMismatchException e){
                System.out.println("No such option exists!");
                proceed = false;
                sc.nextLine();
            }catch(Exception e) {
                System.out.println(e.getMessage());
                proceed = false;
                sc.nextLine();
            }
        }while(!proceed);
        start();
    }

    //Function for setting movie names by admin

    public void change_movies(){

        setMovie1();
        setMovie2();
        setMovie3();
        System.out.println("Movies set successfully!");
        System.out.println();
        start();

    }
}