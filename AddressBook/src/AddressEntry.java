import java.util.ArrayList;
import java.util.Scanner;

public class AddressEntry {

    public static ArrayList<String> fnames = new ArrayList<String>();
    public static ArrayList<String> lnames = new ArrayList<String>();
    public static ArrayList<String> streets = new ArrayList<String>();
    public static ArrayList<String> cities = new ArrayList<String>();
    public static ArrayList<String> states = new ArrayList<String>();
    public static ArrayList<String> phones = new ArrayList<String>();
    public static ArrayList<String> emails = new ArrayList<String>();
    public static ArrayList<String> zips = new ArrayList<String>();
    private static String fName = "";
    private static String lName = "";
    private static String st = "";
    private static String city = "";
    private static String state = "";
    private static String phone = "";
    private static String email = "";
    private static int zip = 0;

    /**
     * default constructor
     */
    public AddressEntry() {
        System.out.println( "Default constructor" );
    }


    /**
     * @param fName first name of person
     * @param lName last name of person
     * @param st    street of person
     * @param city  city of person
     * @param state state of person
     * @param phone phone of person
     * @param email email of person
     * @param zip   zip of person
     */
    public AddressEntry(String fName, String lName, String st, String city, String state, String phone, String email, int zip) {
        System.out.println( "This is a constructor constructor" );
    }

    public static String prompt_GetFirstName() {
        return fName;
    }

    /**
     * prompt_SetFirstName generates a standard output prompt for the First Name to be entered and set
     * setter
     */
    public static void prompt_SetFirstName() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "First Name:\n\t>> " );
        fName = sc.nextLine();
    }

    /**
     * prompt_GetLastName outputs the Last Name set from user input
     * getter
     *
     * @return lname - the last name field entered and set from prompt_SetLastName() method
     */
    public static String prompt_GetLastName() {
        return lName;
    }

    /**
     * prompt_SetLastName() generates a standard output prompt for the Last Name to be entered and set
     * setter
     */
    public static void prompt_SetLastName() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Last Name:\n\t>> " );
        lName = sc.nextLine();
    }

    /**
     * prompt_GetStreet()
     * getter
     *
     * @return st - the street field entered and set from prompt_SetStreet() method
     */
    public static String prompt_GetStreet() {
        return st;
    }

    /**
     * prompt_SetStreet - generates a standard output prompt for the street to be entered and set
     * setter
     */
    public static void prompt_SetStreet() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Street:\n\t>> " );
        st = sc.nextLine();
    }

    /**
     * prompt_GetCity() -
     *
     * @return city -  the city field entered and set from prompt_SetCity() method
     */
    public static String prompt_GetCity() {
        return city;
    }

    public static void prompt_SetCity() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "City:\n\t>> " );
        city = sc.nextLine();
    }

    public static String prompt_GetState() {
        return state;
    }

    public static void prompt_SetState() {

        Scanner sc = new Scanner( System.in );
        System.out.print( "State:\n\t>> " );
        state = sc.nextLine();

    }

    public static int prompt_GetZip() {
        return zip;
    }

    public static void prompt_SetZip() {
        Scanner sc = new Scanner( System.in );

        System.out.print( "Zip:\n\t>> " );
        String urZip = sc.nextLine();


        //checking for zip 5 digit pattern
        while (urZip.length() != 5) {
            System.out.print( "Zip must be 5 digits\n\t>> " );
            urZip = sc.nextLine();
        }
        //Check for 5 ints only
        try {

            int zipToInt = Integer.parseInt( urZip );
            //zip is now vaild. Assign it to the global variable
            zip = zipToInt;

        } catch (Exception NumberFormatException) {

            System.out.println( "An error occurred. Make sure you entered 5 integers only\n" );
            prompt_SetZip();

        }


    }

    public static String prompt_GetTelephone() {
        return phone;
    }

    public static void prompt_SetTelephone() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Phone:\n\t>> " );
        phone = sc.nextLine();
    }

    public static String prompt_GetEmail() {
        return email;
    }

    public static void prompt_SetEmail() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Email:\n\t>> " );
        email = sc.nextLine();

    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        int counterfornames = 0;
        for (int i = 0; i < fnames.size(); i++) {
            counterfornames++;
            builder.append( "\n" + counterfornames + ": " + fnames.get( i ) + " " + lnames.get( i ) + " \n" + streets.get( i ) + "\n" +
                    cities.get( i ) + ", " + states.get( i ) + " " + zips.get( i ) + "\n" + emails.get( i ) + "\n" + phones.get( i ) + "\n" );
        }
        String text = builder.toString();
        return text;


    }
}
