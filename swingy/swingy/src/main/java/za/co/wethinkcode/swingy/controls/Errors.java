package za.co.wethinkcode.swingy.controls;

public class Errors {
    public String gui_con = "";

    public void ErrorInput(int nbr){
        switch (nbr){
            case 0:System.out.println("Please Enter Hero Name or avater name");
                System.exit(1);
                break;
            case 1: System.out.println("Error : Unknown Avatar, Please choose one of the Avatar listed below");
                System.exit(1);
                break;
            case 2: gui_con.equals("console");
                System.out.println("Error : Please Enter Alphabet Only");
                System.exit(1);
                break;
            case 3: gui_con.equals("console");
                System.out.println("Error : Name already exist try another name");
                System.exit(1);
                break;
            case 4: System.out.println("Error : Enter 1 OR 2 Please");
                System.exit(1);
                break;
            case 5: gui_con.equals("console");
                System.out.println("The File Is Empty");
                System.exit(1);
                break;
            case 6: gui_con.equals("console");
                System.out.println("Level cannot be less than 1 or Experience cannot be less than 1000");
                System.exit(1);
                break;
            case 7: gui_con.equals("console");
                System.out.println("Error : Avatar That You Selected Has Invalid Data");
                System.exit(1);
                break;
            default:
                System.exit(1);
        }
    }
}

