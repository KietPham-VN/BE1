package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import utils.Inputter;

public class AccountManager {

    ArrayList<Account> accountList = new ArrayList<>();

    // hàm thêm vào sẵn
    public void initData() {
        accountList.add(new Account("anhkietz", "Kiet", "Pham", "anhkiet123", "0123456789", "a@gmail.com"));
        accountList.add(new Account("anhtuan2005", "Tuan", "Pham", "anhtuan123", "0908829681", "b@gmail.com"));
        accountList.add(new Account("KLinh", "Linh", "Hoang", "KLinh123", "0909909090", "c@gmail.com"));
        accountList.add(new Account("MinhChau", "Chau", "Pham", "PMchau", "7492639573", "d@gmail.com"));
        accountList.add(new Account("NgocBich", "Bich", "Mai", "BichNgoc123", "2738290192", "e@gmail.com"));
    }

    // Method tạo mới 1 tài khoản
    public void addNewAccount() {
        System.out.println("Adding...");
        // nhập username
        boolean isDup = true;
        String username;
        do {
            username = Inputter.getString("Input username: ",
                    "Invaild username!!!",
                    "[^\\\\s]{5,}");
            Account account = searchAccountByUsername(username);
            if (account == null) {
                isDup = false;
            }
        } while (isDup);

        // Nhập password
        String password;
        String confirm;
        do {
            password = Inputter.getString("Input password: ",
                    "Invaild password's format!!!", "[^\\\\s]{6,}");
            confirm = Inputter.getString("Re-input password: ",
                    "That field is required!!!");
            if (!password.equals(confirm)) {
                System.out.println("The later password does not match the former");
            }
        } while (!password.equals(confirm));

        // nhập phoneNumber
        String phoneNumber;
        phoneNumber = Inputter.getString("Input phone number: ",
                "Invalid format", "[\\d]{10}");

        // Nhập firstname
        String firstName = Inputter.getString("Input first name: ",
                "That field is required!!!");

        // Nhập lastName
        String lastName = Inputter.getString("Input last name: ",
                "That field is required!!!");
        // nhập email
        String email = Inputter.getString("Input email: ",
                "Invalid format",
                "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");

        // tạo 
        Account nAccount = new Account(username, firstName, lastName, password,
                phoneNumber, email);
        accountList.add(nAccount);
        System.out.println("Adding successful");
    }

    // Method tìm index dựa trên username
    public int searchIndexByUsername(String key) {
        for (int i = 0; i <= accountList.size() - 1; i++) {
            if (accountList.get(i).getUsername().equals(key)) {
                return i;
            }
        }
        return - 1;

    }

    // Method tìm account dựa trên username
    public Account searchAccountByUsername(String key) {
        int pos = searchIndexByUsername(key);
        return pos == -1 ? null : accountList.get(pos);
    }

    // Method tìm và thông báo
    public void searchAccountByUsername() {
        String key = Inputter.getString("Input the username you wana find",
                "That field is required!!!");
        Account account = searchAccountByUsername(key);

        if (account == null) {
            System.out.println("No Use Found!");
        } else {
            System.out.println("Exist User");
        }
    }

    // tìm 1 phần trong tên
    public void printBaseBrandName() {
        ArrayList<Account> al = new ArrayList<>();

        String key = Inputter.getString("Input a part of first name or last name: ",
                "That field is required!!!");

        // duyệt danh sách
        int count = 0;
        for (Account account : accountList) {
            if (account.getFirstName().contains(key)
                    || account.getLastName().contains(key)) {
                al.add(account);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("No account is detected");
        } else {
            Comparator orderByFirstname = new Comparator<Account>() {
                @Override
                public int compare(Account o1, Account o2) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
            };
            Collections.sort(al, orderByFirstname);
            for (Account account : al) {
                account.showInfor();
            }
        }
    }

    // hàm updaite
    public void updateAccount() {
        String keyUsername = Inputter.getString("Input Account you wana update",
                "That field is required!!!");
        // kiếm cái tài khoản
        Account account = searchAccountByUsername(keyUsername);

        // thông báo kết quả
        if (account == null) {
            System.err.println("The Account is not exist");
        } else {
            System.out.println("The account information before updating");
            account.showInfor();
            System.out.println("Updating...");

            // thông tin mới
            // nhập password
            String nPassword;
            String confirm;
            do {
                nPassword = Inputter.getString("Input password: ",
                        "Invaild password's format!!!", "[^\\\\s]{6,}");
                confirm = Inputter.getString("Re-input password: ",
                        "That field is required!!!");
                if (!nPassword.equals(confirm)) {
                    System.out.println("The later password does not match the former");
                }
            } while (!nPassword.equals(confirm));
            
            // Nhập firstname
            String nFirstName = Inputter.getString("Input first name: ",
                    "That field is required!!!");

            // Nhập LastName
            String nLastName = Inputter.getString("Input last name: ",
                    "That field is required!!!");

            // nhập phoneNumber
            String nPhoneNumber;
            nPhoneNumber = Inputter.getString("Input phone number: ",
                    "Invalid format", "[\\d]{10}");

            // nhập email
            String nEmail = Inputter.getString("Input email: ",
                    "Invalid format",
                    "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");

            // set
            account.setFirstName(nFirstName);
            account.setLastName(nLastName);
            account.setPassword(nPassword);
            account.setPhoneNumber(nPhoneNumber);
            account.setEmail(nEmail);

            System.out.println("Updating is successful!!!");
        }
    }

    // hàm xóa
    public void deleteAccount() {
        String username = Inputter.getString("Input username you wana delete: ",
                "that field is required!!!");
        Account account = searchAccountByUsername(username);
        String password = Inputter.getString("Input password: ",
                "that field is required!!!");
        if (account != null && account.getPassword().equals(password)) {
            accountList.remove(account);
            System.out.println("Delete successful");
        } else {
            System.out.println("Username does not exist");
            System.out.println("Delete unsuccessful");
        }
    }

    // hàm in
    public void printAccountList() {
        if (accountList.isEmpty()) {
            System.out.println("Nothing to print");
            return;
        }
        for (Account account : accountList) {
            account.showInfor();
        }
    }

    // method đọc file
    public boolean loadFromFile(String url) {
        File f = new File(url);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                // xử lý từng dòng
                StringTokenizer st = new StringTokenizer(line, "|");
                String username = st.nextToken().trim();
                String firstName = st.nextToken().trim();
                String lastName = st.nextToken().trim();
                String password = st.nextToken().trim();
                String phoneNumber = st.nextToken().trim();
                String email = st.nextToken().trim();
                // phân tích id thu được
                Account acount = new Account(username, firstName, lastName,
                        password, phoneNumber, email);
                accountList.add(acount);
                line = reader.readLine();// đọc dòng tiếp theo
            }
            System.out.println("File loaded");
            return true;

        } catch (Exception e) {
            System.err.println("File error: " + e);
            return false;
        }
    }

    // method lưu file
    public boolean saveToFile(String url) {
        File f = new File(url);
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Account account : accountList) {
                writer.write(account.toString());
                writer.write("\n");
            }
            writer.flush();
            System.out.println("File save sucessful");
            return true;
        } catch (Exception e) {
            System.out.println("Save file unsucessful " + e);
            return false;
        }
    }
}
