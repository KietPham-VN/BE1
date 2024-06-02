package runtime;

import data.AccountManager;
import ui.Menu;

public class Program {

    public static void main(String[] args) {
        String url = "D:\\Learning_material\\FPT\\F-code\\userManagement\\accounts.txt";
        AccountManager am = new AccountManager();
        am.loadFromFile(url);
        Menu menu1 = new Menu("___Account Management System___");
        menu1.addNewOption("Create user account");
        menu1.addNewOption("Check exits user");
        menu1.addNewOption("Search user information by name");
        menu1.addNewOption("Update user");
        menu1.addNewOption("Save account to file");
        menu1.addNewOption("Print list user from file");

        Menu menu2 = new Menu("___Update Menu___");
        menu2.addNewOption("Update user");
        menu2.addNewOption("Delete user");

        Menu menu3 = new Menu("Do you want to continue?");
        menu3.addNewOption("Yes(back to menu)");
        menu3.addNewOption("No(Quite)");

        while (true) {
            menu1.print();
            int choice = menu1.getChoice();
            switch (choice) {
                case 1: {
                    am.addNewAccount();
                    break;
                }
                case 2: {
                    am.searchAccountByUsername();
                    break;
                }
                case 3: {
                    am.printBaseBrandName();
                    break;
                }
                case 4: {
                    menu2.print();
                    int decision = menu2.getChoice();
                    switch (decision) {
                        case 1: {
                            am.updateAccount();
                            break;
                        }
                        case 2: {
                            am.deleteAccount();
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    am.saveToFile(url);
                    break;
                }
                case 6: {
                    am.printAccountList();
                    break;
                }
            }
            //hỏi coi có in menu tiếp ko
            menu3.print();
            int quite = menu3.getChoice();
            switch (quite) {
                case 1: {
                    break;
                }
                case 2:{
                    am.saveToFile(url);
                    System.out.println("See you again");                   
                    return;
                }
            }
        }
    }
}
