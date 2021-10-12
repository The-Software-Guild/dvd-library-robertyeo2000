package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        print(prompt);
        return scanner.nextLine();
    }
    @Override
    public int readInt(String prompt) {
        int inputInt;
        do {
            String inputStr = readString(prompt);
            try {
                inputInt = Integer.parseInt(inputStr);
                return inputInt;
            } catch (Exception e) {
                System.out.println("Was expecting an integer: '" + inputStr + "' is not an integer");
            }
        } while (true);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input;
        do {
            input = readInt(prompt);
            if (min > input || max < input) {
                print("Integer out of bounds");
            } else {
                return input;
            }
        } while (true);
    }

    @Override
    public double readDouble(String prompt) {
        double inputNum;
        do {
            String inputStr = readString(prompt);
            try {
                inputNum = Double.parseDouble(inputStr);
                return inputNum;
            } catch (Exception e) {
                System.out.println("Was expecting a number: '" + inputStr + "' is not a number");
            }
        } while (true);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double input;
        do {
            input = readDouble(prompt);
            if (min > input || max < input) {
                print("Number out of bounds");
            } else {
                return input;
            }
        } while (true);
    }

    @Override
    public float readFloat(String prompt) {
        float inputNum;
        do {
            String inputStr = readString(prompt);
            try {
                inputNum = Float.parseFloat(inputStr);
                return inputNum;
            } catch (Exception e) {
                System.out.println("Was expecting a number: '" + inputStr + "' is not a number");
            }
        } while (true);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float input;
        do {
            input = readFloat(prompt);
            if (min > input || max < input) {
                print("Number out of bounds");
            } else {
                return input;
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt) {
        long inputInt;
        do {
            String inputStr = readString(prompt);
            try {
                inputInt = Long.parseLong(inputStr);
                return inputInt;
            } catch (Exception e) {
                System.out.println("Was expecting an integer: '" + inputStr + "' is not an integer");
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long input;
        do {
            input = readLong(prompt);
            if (min > input || max < input) {
                print("Integer out of bounds");
            } else {
                return input;
            }
        } while (true);
    }

    @Override
    public Date readDate(String prompt) {
        UserIO io = new UserIOConsoleImpl();
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date input;
        do {
            String inputStr = io.readString(prompt);
            try {
                input = formatter.parse(inputStr);
                return input;
            }
            catch (Exception e) {
                io.print("Was expecting a date: " + inputStr + " is not in " + DATE_FORMAT + " format.");
            }
        } while (true);
    }

}