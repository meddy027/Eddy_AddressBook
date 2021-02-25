/**
 * Main class of this addressbook program
 */
public class AddressBookApplication {

    /**
     * @param args contains the supplied command-line arguments as an array of String objects.
     */
    public static void main(String[] args) {

        Menu mnu = new Menu();
        Menu.myMenu();

        System.exit( 0 );
    }
}