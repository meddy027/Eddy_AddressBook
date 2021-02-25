import java.io.*;
import java.util.Scanner;

/**
 * Class to allow user to select desired menu option
 */
public class AddressBook {
    private static int counter = 0;
    static AddressEntry abe = new AddressEntry();
    static File filenameForTransfer;


    /**
     * Reads in the user specified file
     * @param filename the file name entered by the user
     */
    public static void init(File filename) {

        System.out.println( "\n................. Opening " + filename + " .................\n" );

        filenameForTransfer = filename;
        counter = 0;


        try {
            Scanner s;
            if (filename.exists()) {
                s = new Scanner( filename );
                while (s.hasNextLine()) {
                    String fname = s.nextLine();
                    String lName = s.nextLine();
                    String st = s.nextLine();
                    String city = s.nextLine();
                    String state = s.nextLine();
                    String phone = s.nextLine();
                    String email = s.nextLine();
                    String zip = s.nextLine();

                    counter += 1;

                    AddressEntry.fnames.add( fname );
                    AddressEntry.lnames.add( lName );
                    AddressEntry.streets.add( st );
                    AddressEntry.cities.add( city );
                    AddressEntry.states.add( state );
                    AddressEntry.zips.add( phone );
                    AddressEntry.emails.add( email );
                    AddressEntry.phones.add( zip );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( "****** Read in " + counter + " new Addresses, successfully loaded, currently " + counter + " Addresses ****** \n" );

    }


    /**
     * Lists the entries in the addressbook
     */
    public static void list() {
        counter = 0;
        String x = abe.toString();
        System.out.println( x );
    }


    /**
     * Boolean method to find if user inputted last name is in the addressbook
     * @param name name to find
     * @return true if the last name is in the list false if not
     */
    public static boolean find(String name) {

        return AddressEntry.lnames.contains( name );
    }

    /**
     * Extra method to display the results of find method
     * Used because I wanted this method and remove to have different
     * input and output messages
     * @param name name to find/found
     */
    public void displayFindResults(String name) {

        int entryCounter = 0;

        for (int i = 0; i < AddressEntry.lnames.size(); i++) {

            if (name.equalsIgnoreCase( AddressEntry.lnames.get( i ) )) {
                entryCounter++;
            }

        }

        int current = -1;
        int last = AddressEntry.lnames.lastIndexOf( name );

        System.out.println( "\nThe following " + entryCounter + " entries were found in the address book for a last name starting with \"" + name + "\"" );
        int indexCounter = 1;
        while (current != last) {
            current++;

            if (name.equalsIgnoreCase( AddressEntry.lnames.get( current ) )) {
                StringBuilder builder = new StringBuilder();
                builder.append( "\n" + indexCounter + ": " + AddressEntry.fnames.get( current ) + " " + AddressEntry.lnames.get( current ) + " \n" + AddressEntry.streets.get( current ) + "\n" +
                        AddressEntry.cities.get( current ) + ", " + AddressEntry.states.get( current ) + " " + AddressEntry.zips.get( current ) + "\n" + AddressEntry.emails.get( current ) + "\n" + AddressEntry.phones.get( current ) + "\n" );

                System.out.println( builder.toString() );

            }
            indexCounter++;
        }

    }

    /**
     * uses the find method to find the name. Then calls on
     * the remove built in method to remove the entry from the addressbook
     * @param name name to remove from addressbook
     */
    public static void remove(String name) {
        int entryCounter = 0;
        boolean removal = find( name );

        for (int i = 0; i < AddressEntry.lnames.size(); i++) {
            if (name.equalsIgnoreCase( AddressEntry.lnames.get( i ) )) {
                entryCounter++;
            }
        }


        if (removal) {

            int current = -1;
            int last = AddressEntry.lnames.lastIndexOf( name );
            int choice;

            Scanner babe = new Scanner( System.in );
            System.out.print( "\nThe following " + entryCounter + " entries were found in the address book, select number of entry you wish to remove: \n" );


            int indexCounter = 1;
            while (current != last) {
                current++;

                if (name.equalsIgnoreCase( AddressEntry.lnames.get( current ) )) {
                    StringBuilder builder = new StringBuilder();
                    builder.append( "\n" + indexCounter + ": " + AddressEntry.fnames.get( current ) + " " + AddressEntry.lnames.get( current ) + " \n" + AddressEntry.streets.get( current ) + "\n" +
                            AddressEntry.cities.get( current ) + ", " + AddressEntry.states.get( current ) + " " + AddressEntry.zips.get( current ) + "\n" + AddressEntry.emails.get( current ) + "\n" + AddressEntry.phones.get( current ) + "\n" );

                    System.out.println( builder.toString() );

                }
                indexCounter++;
            }
            System.out.print( "\t >> " );
            choice = babe.nextInt();

            int choiceIndex = choice - 1;

            AddressEntry.fnames.remove( choiceIndex );
            AddressEntry.lnames.remove( choiceIndex );
            AddressEntry.streets.remove( choiceIndex );
            AddressEntry.cities.remove( choiceIndex );
            AddressEntry.states.remove( choiceIndex );
            AddressEntry.zips.remove( choiceIndex );
            AddressEntry.emails.remove( choiceIndex );
            AddressEntry.phones.remove( choiceIndex );

            //System.out.println("\n" + name + " Removed from list !. ");

        } else {
            System.out.println( "\n" + name + " Could not be removed, because it was not found. " );
        }
    }

    /**
     * adds an entry to the addressbook
     */
    public static void add() {
        System.out.println( "\n ................. Adding to Address Book ................... \n" );


        AddressEntry.prompt_SetFirstName();
        AddressEntry.fnames.add( AddressEntry.prompt_GetFirstName() );
        AddressEntry.prompt_SetLastName();
        AddressEntry.lnames.add( AddressEntry.prompt_GetLastName() );
        AddressEntry.prompt_SetStreet();
        AddressEntry.streets.add( AddressEntry.prompt_GetStreet() );
        AddressEntry.prompt_SetCity();
        AddressEntry.cities.add( AddressEntry.prompt_GetCity() );
        AddressEntry.prompt_SetState();
        AddressEntry.states.add( AddressEntry.prompt_GetState() );
        AddressEntry.prompt_SetZip();
        AddressEntry.zips.add( String.valueOf( (AddressEntry.prompt_GetZip()) ) );
        AddressEntry.prompt_SetTelephone();
        AddressEntry.phones.add( AddressEntry.prompt_GetTelephone() );
        AddressEntry.prompt_SetEmail();
        AddressEntry.emails.add( AddressEntry.prompt_GetEmail() );


    }


}
