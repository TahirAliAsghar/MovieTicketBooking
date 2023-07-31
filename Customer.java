import java.util.Scanner;

public class Customer{

    private String name;
    private long phone;
    private int age;

    Scanner sc = new Scanner(System.in);

    public Customer(){
        setName();
        setAge();
        setPhone();
    }


    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Enter your name: ");
        name = sc.nextLine();
    }

    public long getPhone() {
        return phone;
    }

    //try catch for set phone in case wrong input is provided
    public void setPhone() {
        boolean proceed;
        System.out.println("Enter your phone: ");
        do {
            try {
                phone = sc.nextLong();
                proceed = true;
            } catch (Exception e) {
                System.out.println("You have entered an invalid number!");
                sc.nextLine();
                proceed = false;
            }
        }while(!proceed);
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        boolean proceed;
        System.out.println("Enter your age: ");
        do {
            try {
                age = sc.nextInt();
                proceed = true;
            } catch (Exception e) {
                System.out.println("Invalid age entered!");
                proceed = false;
                sc.nextLine();
            }
        }while(!proceed);
    }

}