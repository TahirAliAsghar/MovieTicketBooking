import java.util.Date;

public class ticket extends Customer{

    private int price;
    private final String movie;

    Date t = new Date();

    public void setPrice(int price) {
        this.price = price;
    }

    public ticket(int choice,String movie){
        if(choice ==1){
            this.movie = movie;
            setPrice(5);
        }
        else if(choice == 2){
            this.movie = movie;
            setPrice(7);
        }
        else{
            this.movie = movie;
            setPrice(10);
        }
    }

    //function for storing the users data into the file

    public void display () {

        System.out.print("--------------------------------------------------\n");
        System.out.print("||  MOVIE NAME: " + movie + "                       \n");
        System.out.print("||  DATE PURCHASED: " + t + "                       \n");
        System.out.print("||  CUSTOMER NAME: " + super.getName() + "                    \n");
        System.out.print("||  CUSTOMER AGE: " + super.getAge() + "                             \n");
        System.out.print("||  CUSTOMER CONTACT: " + super.getPhone() + "                             \n");
        System.out.print("||                                               \n");
        System.out.print("||                                     PRICE: $" + price + " \n");
        System.out.print("||                                     SEAT:   " + Menu.select + " \n");
        System.out.print("--------------------------------------------------\n");

    }


}