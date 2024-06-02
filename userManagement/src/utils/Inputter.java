package utils;

import java.util.Scanner;

/*
- Inputter là 1 các khuôn nhưng anh không thích dùng inputter để đúc ra Object 
    mà anh dùng để lưu các hàm tiện ích hỗ trợ cho việc nhập.
- nhưng trong java thì lại không có Hàm
 */
public class Inputter {

    //prop
    public static Scanner sc = new Scanner(System.in);

    //những method hỗ trợ việc nhập
    //1. method ép người dùng nhập số nguyên chuẩn
    public static int getAnInteger(String inpMsg, String errMsg) {
        System.out.println(inpMsg);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //2. method ép người dùng nhập số nguyên chuẩn trong khoản
    public static int getAnInteger(String inpMsg, String errMsg,
            int lowerBound, int upperBound) {
        System.out.println(inpMsg);
        if (lowerBound > upperBound) {
            lowerBound += upperBound;
            upperBound = lowerBound - upperBound;
            lowerBound -= upperBound;
        }
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //3. method ép người dùng nhập số thực chuẩn
    public static double getADouble(String inpMsg, String errMsg) {
        System.out.println(inpMsg);
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //4. method ép người dùng nhập số thực chuẩn trong khoản
    public static Double getADouble(String inpMsg, String errMsg,
            double lowerBound, double upperBound) {
        System.out.println(inpMsg);
        if (lowerBound > upperBound) {//dành cho người vô tri
            lowerBound += upperBound;
            upperBound = lowerBound - upperBound;
            lowerBound -= upperBound;
        }
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //5. Hàm nhập chuỗi cấm để trống
    public static String getString(String inpMsg, String errMsg) {
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //6. Hàm nhập chuỗi cấm để trống và phải giống regex
    public static String getString(String inpMsg, String errMsg, String regex) {
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();

                if (str.isEmpty() || !str.matches(regex)) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //7.hàm nhập ngày tháng năm theo chuẩn format
    //f("Nhập ngày tháng năm nhé: ", "ngu", "DD-MM-YYYY", "YYYY-MM-DD");
    public static String getDate(String inpMsg, String errMsg, String regex) {
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty() || !str.matches(regex)) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
}
