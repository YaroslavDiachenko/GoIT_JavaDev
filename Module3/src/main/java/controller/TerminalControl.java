package controller;

import dao.*;
import dao.hibernate.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalControl {

    static ProjectDAO projectDAO = new HibernateProjectDAOImpl();
    static CompanyDAO companyDAO = new HibernateCompanyDAOImpl();
    static CustomerDAO customerDAO = new HibernateCustomerDAOImpl();
    static DeveloperDAO developerDAO = new HibernateDeveloperDAOImpl();
    static SkillDAO skillDAO = new HibernateSkillDAOImpl();

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public TerminalControl() {
    }

    // begins interaction with a user - calls helper start method for corresponding object type
    public void beginInteraction() {
        System.out.println("Database has been successfully initialized.");

        while (true) {
            System.out.print("\nChoose table (1=projects, 2=developers, 3=companies, 4=customers, 5=skills, 0=exit): ");
            int tableChoice = getFromUserIntegerInRange(0, 5);
            switch (tableChoice) {
                case 0:
                    System.exit(0);
                case 1:
                    ProjectHelper.start();
                    break;
                case 2:
                    DeveloperHelper.start();
                    break;
                case 3:
                    CompanyHelper.start();
                    break;
                case 4:
                    CustomerHelper.start();
                    break;
                case 5:
                    SkillHelper.start();
                    break;
            }
        }
    }

    // additional methods intended to get and validate data from user
    static String getFromUserString() {
        do {
            try {
                String line = bufferedReader.readLine();
                if (line != null && !line.equals("")) {
                    return line;
                } else {
                    System.out.print("\tInvalid input. Please try again: ");
                }
            } catch (IOException e) {
                System.out.print("\tInvalid input. Please try again: ");
            }
        } while (true);
    }
    static double getFromUserDouble() {
        do {
            try {
                String line = bufferedReader.readLine();
                double number = Double.parseDouble(line);
                return number;
            } catch (IOException e) {
                System.out.print("\tInvalid input. Please try again: ");
            } catch (NumberFormatException e2) {
                System.out.print("\tInvalid input: number required. Please try again: ");
            }

        } while (true);
    }
    static int getFromUserInteger() {
        do {
            try {
                String line = bufferedReader.readLine();
                int number = Integer.parseInt(line);
                return number;
            } catch (IOException e) {
                System.out.print("\tInvalid input. Please try again: ");
            } catch (NumberFormatException e2) {
                System.out.print("\tInvalid input: integer required. Please try again: ");
            }
        } while (true);
    }
    static int getFromUserIntegerInRange(int min, int max) {
        do {
            try {
                String line = bufferedReader.readLine();
                int number = Integer.parseInt(line);
                if (number >= min && number <= max){ return number;}
                else {
                    System.out.print("\tNo available option chosen. Please try again: ");
                }
            } catch (IOException e) {
                System.out.print("\tInvalid input. Please try again: ");
            } catch (NumberFormatException e2) {
                System.out.print("\tInvalid input: number required. Please try again: ");
            }
        } while (true);
    }
    static int[] getFromUserListOfIntegers() {
        do {
            String line = getFromUserString();
            String[] parts = line.split(",");
            int[] integers = new int[parts.length];
            try {
                for (int i = 0; i < parts.length; i++) {
                    integers[i] = Integer.parseInt(parts[i]);
                }
                return integers;
            } catch (NumberFormatException e) {
                System.out.println("\t\tInvalid input: list of integers required. Please try again: ");
            }
        } while (true);
    }
}
