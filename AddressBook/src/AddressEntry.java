import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle menu options
 */
public class AddressEntry {

    /**
     * Arraylists to hold parse data from file/program
     */

    public static ArrayList<String> fnames = new ArrayList<String>();
    public static ArrayList<String> lnames = new ArrayList<String>();
    public static ArrayList<String> streets = new ArrayList<String>();
    public static ArrayList<String> cities = new ArrayList<String>();
    public static ArrayList<String> states = new ArrayList<String>();
    public static ArrayList<String> phones = new ArrayList<String>();
    public static ArrayList<String> emails = new ArrayList<String>();
    public static ArrayList<String> zips = new ArrayList<String>();

    /**Specific variables to hold parse data from file/program*/
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

    /**
     * @return the first name field entered and set from prompt_SetFirstName() method
     */
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
     * prompt_GetCity() - gets the city entered by the user
     * @return city -  the city field entered and set from prompt_SetCity() method
     */
    public static String prompt_GetCity() {
        return city;
    }

    /**
     * prompt_SetCity - generates a standard output prompt for the city to be entered and set
     * setter
     */
    public static void prompt_SetCity() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "City:\n\t>> " );
        city = sc.nextLine();
    }

    /**
     * prompt_GetState() - gets the state entered by the user
     * @return state -  the state field entered and set from prompt_SetState() method
     */
    public static String prompt_GetState() {
        return state;
    }

    /**
     * prompt_SetState - generates a standard output prompt for the state to be entered and set
     * setter
     */
    public static void prompt_SetState() {

        Scanner sc = new Scanner( System.in );
        System.out.print( "State:\n\t>> " );
        state = sc.nextLine();

    }

    /**
     * prompt_GetZip() - gets the zip entered by the user
     * @return zip -  the state field entered and set from prompt_SetZip() method
     */
    public static int prompt_GetZip() {
        return zip;
    }

    /**
     * prompt_SetZip - generates a standard output prompt for the zip to be entered and set
     * setter
     */
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

    /**
     * prompt_GetTelephone() - gets the zip entered by the user
     * @return phone -  the state field entered and set from prompt_SetTelephone() method
     */
    public static String prompt_GetTelephone() {
        return phone;
    }

    /**
     * prompt_SetTelephone - generates a standard output prompt for the telephone to be entered and set
     * setter
     */
    public static void prompt_SetTelephone() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Phone:\n\t>> " );
        phone = sc.nextLine();
    }

    /**
     * prompt_GetEmail() - gets the zip entered by the user
     * @return email -  the state field entered and set from prompt_SetEmail() method
     */
    public static String prompt_GetEmail() {
        return email;
    }

    /**
     * prompt_SetEmail - generates a standard output prompt for the email to be entered and set
     * setter
     */
    public static void prompt_SetEmail() {
        Scanner sc = new Scanner( System.in );
        System.out.print( "Email:\n\t>> " );
        email = sc.nextLine();
    }

    /**
     * Simple override of java’s toString method
     * @return text -  the combination of all the fields into one nice print statement
     */
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
