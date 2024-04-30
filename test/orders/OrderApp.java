package beta.test.orders;

import java.util.Scanner;

/**
 * Εμφανίζει τα διαθέσιμα φαγητά ενός καταστήματος σε διαφορετικές κατηγορίες
 * και επιτρέπει στον χρήστη να επιλέξει αυτά που επιθυμεί και να τα προσθέσει στην παραγγελία του.
 * Κατα την παραγγελία του χρήστη δημιουργείται μια λίστα παραγγελίας και υπολογίζεται το συνολικό κόστος της.
 */
public class OrderApp {
    // Global Scanner για την ανάγνωση τον εισαγωγών του χρήστη
    static Scanner input = new Scanner(System.in);
    // Δήλωση και αρχικοποίηση βασικών Global μεταβλητών
   static double orderSum = 0;
   static String[] orderList = new String[20];
   static int orderListID = 0;
   static int errorCode = 0;
   static boolean isActive = true;


    public static void main(String[] args) {
        System.out.println("Καλωσορίσατε στο Faetouskasmou.gr");
        showMenu();
        do{
            mainSelectionReturn();
        } while (isActive);

    }
/**
 * Εμφανίζει το κεντρικό μενού της εφαρμογής
 * και δίνει στον χρήστη την επιλογή κατηγορίας φαγητού
 * για παραγγελία
 */
    public static void showMenu(){
        System.out.println("Παρακαλώ επιλέξτε απο τις κατηγορίες φαγητού, ή πατήστε 0 για έξοδο");
        System.out.println("1. Ορεκτικά");
        System.out.println("2. Σαλάτες");
        System.out.println("3. Τυλιχτά");
        System.out.println("4. Μαγειρευτά");
        System.out.println("5. Παιδικό μενού");
        System.out.println("6. Αναψυκτικά/Μπύρες");
        System.out.println("7. Περιεχόμενα παραγγελίας");
        System.out.println("8. Ολοκλήρωση παραγγελίας");
        System.out.println("0. Έξοδος");

    }

    public static void mainSelectionReturn(){
        int selection = input.nextInt();
    switch (selection) {
        case 1:
            showOrektika();
            break;
        case 2:
            showSalates();
            break;
        case 3:
            showTilixta();
            break;
        case 4:
            showMageireuta();
            break;
        case 5:
            showPaidiko();
            break;
        case 6:
            showDrinks();
            break;
        case 7:
            showOrder();
            break;
        case 8:
            checkout();
            break;
        case 0:
            validation(1);
            break;
        default:
            validation(2);
            break;

    }
    }
public static int validation (int errorCode){

        switch (errorCode){
            case 1: quitProgram();
                break;
            case 2: wrongSelection();
                break;
            case 3:{

            }
            default: errorCode = 2;
                break;
        }
        return errorCode;
}
    /**
     * Εμφανίζει τη λίστα με τα διαθέσιμα ορεκτικά, στον χρήστη
     * και τον αφήνει να επιλέξει ποια θέλει να προσθέσει στην παραγγελία του
     */
public static void showOrektika() {
    double[] prices = {4.6,4.6,4.5,4.8,5.5,4.5};
    String[] foodnames = {"Xωριάτικη Σαλάτα","Ανάμικτη Σαλάτα","Ceasar's Salad","Τονοσαλάτα","Σαλάτα Μαρούλι","Σαλάτα του Chef" };
    int selection = -1;
    showFoodMenu(foodnames,prices);
    selection = input.nextInt();
    if(selection < prices.length + 1){
    switch (selection) {
        case 1:
            addToCart( foodnames[selection - 1], prices[selection-1]);
           break;
        case 2: addToCart( foodnames[selection - 1], prices[selection-1]);
            break;
        case 3: addToCart( foodnames[selection - 1], prices[selection-1]);
            break;
        case 4: addToCart( foodnames[selection - 1], prices[selection-1]);
            break;
        case 5: addToCart( foodnames[selection - 1], prices[selection-1]);
            break;
        case 6: addToCart( foodnames[selection - 1], prices[selection-1]);
            break;
        case 0: showMenu();break;
        default:
            System.out.println("Δεν έχετε επιλέξει σωστό κωδικό φαγητού");
            break;

    }
    cartUpdate();
    checkoutOrContinue();
}else{
        validation(2);
    }
}



    /**
     * Εμφανίζει τη λίστα με τις διαθέσιμες σαλάτες, στον χρήστη
     * και τον αφήνει να επιλέξει ποια θέλει να προσθέσει στην παραγγελία του
     */
    public static void showSalates(){
        double[] prices = {7d ,5.3,8.6,7.6,5,8.1};
        String[] foodnames = {"Xωριάτικη Σαλάτα","Ανάμικτη Σαλάτα","Ceasar's Salad","Τονοσαλάτα","Σαλάτα Μαρούλι","Σαλάτα του Chef" };
        int selection = -1;
        showFoodMenu(foodnames,prices);
        selection = input.nextInt();
        if(selection < prices.length + 1){
        switch (selection) {
            case 1:
                addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 2: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 3: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 4: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 5: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 6: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 0: showMenu();break;
            default:
                validation(2);
                break;

        }
            cartUpdate();
            checkoutOrContinue();
        }else{
            validation(2);
        }
    }
    /**
     * Εμφανίζει τη λίστα με τα διαθέσιμα τυλιχτά, στον χρήστη
     * και τον αφήνει να επιλέξει ποια θέλει να προσθέσει στην παραγγελία του
     */
    public static void showTilixta(){
        double[] prices = {5.2,5.2, 5.2, 5.2,5.2,5.2};
        String[] foodnames = {"Γύρος χοιρινός σε πίτα","Γυρος κοτόπουλο σε πίτα", "Σουβλάκι χοιρινό σε πίτα","Σουβλάκι κοτόπουλο σε πίτα","Μπιφτέκι σε πίτα","Πανσέτα σε πίτα"};
        int selection = -1;
        showFoodMenu(foodnames, prices);
        selection = input.nextInt();
        if(selection < prices.length + 1){
        switch (selection) {
            case 1:
                addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 2: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 3: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 4: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 5: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 6: addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 0: showMenu();break;
            default:
                validation(2);
                break;

        }
        cartUpdate();
        checkoutOrContinue();
    }else{
        validation(2);
    }
    }
    /**
     * Εμφανίζει τη λίστα με τα διαθέσιμα μαγειρευτά φαγητά, στον χρήστη
     * και τον αφήνει να επιλέξει ποια θέλει να προσθέσει στην παραγγελία του
     */
    public static void showMageireuta(){
        double[] prices = {6.6, 6.6, 6d, 6.6,6.8};
        String[] foodnames = {"Γεμιστά","Μουσακάς", "Μακαρόνια με μοσχαρίσιο κιμά","Παστίτσιο","Σουτζουκάκια με κόκκινη σάλτσα"};
        int selection = -1;
        showFoodMenu(foodnames, prices);
        selection = input.nextInt();
        if(selection < prices.length + 1){
        switch (selection) {
            case 1:
                addToCart( foodnames[selection - 1], prices[selection-1]);
                break;
            case 2: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 3: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 4: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 5: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 0: showMenu();break;
            default:
                validation(2);
                break;

        }
            cartUpdate();
            checkoutOrContinue();
        }else{
            validation(2);
        }
    }
    /**
     * Εμφανίζει τη λίστα με τα διαθέσιμα προιόντα στο παιδικό μενού, στον χρήστη
     * και τον αφήνει να επιλέξει ποια θέλει να προσθέσει στην παραγγελία του
     */
    public static void showPaidiko(){
        double[] prices = {6d, 5d, 6.6, 6.8};
        String[] foodnames = {"Κοτομπουκιές με πατάτες", "Club Sandwich με πατάτες", "Μακαρόνια με μοσχαρίσιο κιμά","Διπλό Χάμπουργκερ με πατάτες"};
        int selection = 1;
        showFoodMenu(foodnames, prices);

        selection = input.nextInt();
        if(selection < prices.length + 1){
        switch (selection) {
            case 1:
                addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 2: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 3: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 4: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 5: addToCart( foodnames[selection-1], prices[selection-1]);
                break;
            case 0: showMenu();break;
            default:
                validation(2);
                break;

        }
            cartUpdate();
            checkoutOrContinue();
        }else{
            validation(2);
        }

    }

    /**
     * Εμφανίζει τη λίστα με τα διαθέσιμα αναψυκτικά και αλκοολούχα ποτά στον χρήστη
     * και τον αφήνει να επιλέξει ποια θέλει να προσθέσει στην παραγγελία του
     */
    public static void showDrinks(){

        double[] prices = {2d,2d,2d,2d,2.5,2d,4.5,4.5,4.5,3.9};
        String[] drinknames = {"Coca Cola 330ml","Fanta πορτοκάλι 330ml","Sprite 330ml","Schweppes Λεμόνι 330ml","Monster Energy 500ml","Μπύρα Αλφα 500ml","Μπύρα ΕΖΑ 500ml","Μπύρα ΜΑΜΟΣ 500ml","Μπύρα Amstel Raddler 500ml","Ρετσίνα 500ml"};
        int selection = -1;
        showFoodMenu(drinknames, prices);

        selection = input.nextInt();
if(selection < prices.length + 1){
        switch (selection) {
            case 1:
                addToCart( drinknames[selection-1], prices[selection-1]);
                break;
            case 2: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
            case 3: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
            case 4: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
            case 5: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
                case 6: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
                case 7: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
                case 8: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
                case 9: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
                case 10: addToCart( drinknames[selection-1], prices[selection-1]);
                break;
            case 0: showMenu();break;
            default:
                validation(2);
                break;


        }
    cartUpdate();
    checkoutOrContinue();
    }else{
    validation(2);
        }

    }

    /**
     * Βγαίνει απο το πρόγραμμα αν το επιλέξει ο χρήστης
     * εμφανίζοντας ένα ευχαριστήριο μήνυμα
     * @return το boolean isActive γίνεται false;
     */
    public static void quitProgram(){
        System.out.println("Ευχαριστούμε που χρησιμοποιήσατε το σύστημα παραγγελιών μας");
 System.exit(0);

    }
    public static void wrongSelection(){
        int selection =-1;
        System.out.println("Δεν έχετε επιλέξει σωστό κωδικό φαγητού. Πατήστε 0 για να επιστρέψετε στο αρχικό μενού");
        selection = input.nextInt();

        if (selection == 0){
            showMenu();
        }else {
            System.out.println("Δεν έχετε επιλέξει σωστό κωδικό φαγητού. Πατήστε 0 για να επιστρέψετε στο αρχικό μενού");
        }

    }

    /**
     * Προσθέτει στην παραγγελία το επιλεγμένο αντικείμενο
     * και ενημερώνει το συνολικό κόστος της παραγγελίας
     * @param name  Το όνομα του φαγητού/ποτού που επέλεξε ο χρήστης
     * @param price η τιμή του επιλεγμένου φαγητού/ποτού.
     */
    public static void addToCart(String name, double price) {
        orderSum += price;
        orderList[orderListID] = name;
        orderListID++;

    }

    /**
     *  Ενημερώνει τον χρήστη για τα προιόντα που πρόσθεσε την παραγγελία του
     *  και το συνολικό κόστος της παραγγελίας
     *  Επίσης δίνει μια περίληψη της παραγγελίας του.
     */
    public static void cartUpdate() {
        if (errorCode != 2 && orderListID >=1) {
            System.out.printf("\n\n\n Προσθέσατε στην παραγγελία σας %s. Ο λογαριασμός σας είναι στα %.2f\n", orderList[orderListID - 1], orderSum);
            System.out.println("Η παραγγελία σας περιλαμβάνει");
            for (int i = 0; i < orderList.length; i++) {
                if (orderList[i] != null) {
                    System.out.println(orderList[i]);
                }
            }
            System.out.println("\n");
        }
    }

    /**
     * Ολοκληρώνει την παραγγελία συνοψίζοντας τα περιεχόμενα,
     * το κόστος, και τον χρόνο προετοιμασίας. Στη συνέχεια τερματίζει την εφαρμογή.
     */
    public static void checkout(){
        int selection = -1;
        if(orderSum > 0) {
            System.out.println("Ευχαριστούμε για την παραγγελία σας!\n");
            showOrder();
            System.out.printf("Ο λογαριασμός σας είναι στα %.2f€\n\n", orderSum);
            System.out.println("Ο χρόνος προετοιμασίας υπολογίζεται σε περίπου 30 λεπτα");
            quitProgram();
        } else {

            System.out.println("H παραγγελία σας είναι κενή πατήστε 0 για να επιστρέψετε στο αρχικού μενού");
            selection = input.nextInt();
            if(selection == 0){
                showMenu();
            } else{
                System.out.println("Πατήστε 0 για να επιστρέψετε στο αρχικού μενού");
            }
        }
    }
    /**
     * Ρωτάει τον χρήση αν θέλει να συνεχίσει ή να ολοκληρώσει την παραγγελία του, μετά
     * την προσθήκη κάποιου φαγητού στην παραγγελία
     */
    public static void checkoutOrContinue(){
        int selection = -1;
    System.out.println("Πατήστε 1 για να προσθέσετε κάτι στην παραγγελία σας, ή 2 για να την ολοκληρώσετε");
    System.out.println("Πατήστε 0 για να ακυρώσετε την παραγγελία σας");
    selection = input.nextInt();
    if(selection == 1){
        showMenu();
    }
    if(selection == 2){
        checkout();
        }
    if (selection == 0){
        reset();
    }

}


    /**
     *  Φορτώνει τη λίστα με τα φαγητά/ποτά συγκεκριμένης κατηγορίας
     * @param namesArray Πίνακας με τα διαθέσιμα φαγητά στην εκάστοτε κατηγορία
     * @param pricesAray πίνακας με τις τιμές του κάθε φαγητού. Η θέση του φαγητού στον
     *                   πίνακα namesArray πρέπει να είναι αντίστοιχη με την τιμή του
     *                   στο PricesArray
     */
    public static void showFoodMenu(String[] namesArray, double[] pricesAray) {
        if (orderListID >= 0) {
            int id = 0;
            int selection = -1;
            System.out.println("Επιλέξτε τι θέλετε να προσθέσετε στο καλάθι, η πατήστε 0 για επιστροφή");
            for (String food : namesArray) {
                System.out.printf("%d. %s %.2f€\n", id + 1, namesArray[id], pricesAray[id]);
                id++;
            }

            System.out.println("0. Επιστροφή στο αρχικό μενού");
        }
    }

public static void showOrder() {
    if (orderListID >= 1){
    System.out.println("Η παραγγελία σας περιλαμβάνει");
        for (int i = 0; i < orderList.length; i++) {
                if (orderList[i] != null) {
                    System.out.println(orderList[i]);
                }
            }
        System.out.println("");
        }else {
        System.out.println("Η παραγγελία σας είναι κενή");
        checkoutOrContinue();
        System.out.println("");
    }

    };

public static void reset(){
    System.out.println("Η παραγγελία σας έχει ακυρωθεί.");
        quitProgram();
    }
}
