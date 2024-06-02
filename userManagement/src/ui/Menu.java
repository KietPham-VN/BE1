package ui;

import java.util.ArrayList;
import utils.Inputter;

/*
menu: là 1 cái khuôn chuyên đúc ra anh quản lý danh sách các option
có: danh sách các lựa chọn optionList
có: title: tên của menu
có: các method giúp xử lý optionList
addNewOption: thêm các option và optionList
print: in ra danh sách các option kèm số cho người dùng chọn
getChoice: thu thập lựa chọn của người dùng
 */
public class Menu {

    //danh sách các option
    public ArrayList<String> optionList = new ArrayList<>();
    public String title;

    //consturctors
    public Menu(String title) {
        this.title = title;
    }

    //addNewOption: hàm thêm option vào optionList
    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void print() {
        int count = 1;
        System.out.println("_______" + title + "_______");
        for (String op : optionList) {
            System.out.println(count + ". " + op);
            count++;
        }
    }
    //getChoice: hàm thu thập lựa chọn
    public int getChoice() {
        int choice = Inputter.getAnInteger("Input your choice:", 
                "Your choice must be between 1 and "+ optionList.size());
        return choice;
    }
}
