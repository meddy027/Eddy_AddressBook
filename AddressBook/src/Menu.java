import java.io.*;
import java.util.Scanner;

/**
 * The type Menu.
 */
public class Menu {

    /**
     * The Ab.
     */
    static AddressBook ab = new AddressBook();

    /**
     * void myMenu - Creates main menu for user to Load, add to, remove from, find in, list, and exit the file.
     * Loops backs depending on input
     */
    public static void myMenu() {

        System.out.println( "\n*****************************" + "\nPlease enter in your menu selection" );
        System.out.println( "\n a) Loading From File" + "\n b) Addition" + " \n c) Removal" + "\n d) Find" );
        System.out.println( " e) Listing" + "\n\n\n f) Quit" + " \n*****************************" );

        System.out.print( "\t>>  " );
        Scanner sc = new Scanner( System.in );
        String choice = sc.next();

        if (choice.equalsIgnoreCase( "a" )) {

            Scanner redinFilenameScanner = new Scanner( System.in );
            System.out.print( "\nEnter Filename >> " );
            String redFilename = redinFilenameScanner.nextLine();

            File file = new File( redFilename );
            AddressBook.init( file );

            myMenu();
        }
        else if (choice.equalsIgnoreCase( "b" )) {

            AddressBook.add();
            myMenu();
        }
        else if (choice.equalsIgnoreCase( "c" )) {

            String AddressEntryname;
            Scanner findingScanner = new Scanner( System.in );
            System.out.print( "\nEnter in all or the begining of the Last Name of the contact you wish to remove:\n\t >> " );
            AddressEntryname = findingScanner.nextLine();

            AddressBook.remove( AddressEntryname );
            myMenu();
        }
        else if (choice.equalsIgnoreCase( "d" )) {

            String AddressEntryname;
            Scanner findingScanner = new Scanner( System.in );
            System.out.print( "\nEnter in all or the begining of the Last Name of the contact you wish to find:\n\t >> " );

            AddressEntryname = findingScanner.nextLine();
            boolean found = AddressBook.find( AddressEntryname );
            if (found) {
                ab.displayFindResults( AddressEntryname );
            }
            else {
                System.out.println(AddressEntryname + " not found in this address book");
            }
            myMenu();
        }
        else if (choice.equalsIgnoreCase( "e" )) {

            AddressBook.list();
            myMenu();
        }
        else if (choice.equalsIgnoreCase( "f" )) {

            System.out.println( "\n..................... Exiting Program ....................." );
            System.out.println( "                   !!! [: Bye Bye :] !!!                     " );
            System.exit( 0 );
        }
        else {
            System.out.println( "\nINVALID INPUT" );
            System.out.println( "\n\tPLEASE SELECT A VALID OPTION" );
            myMenu();
        }
    }
}
