package controller;


import model.Customer;
import java.util.List;
import static controller.TerminalControl.*;

class CustomerHelper {
    static void start() {
        System.out.print("Table: CUSTOMERS");
        while (true) {
            System.out.print("\n\tChoose option (1=create, 2=update, 3=delete, 4=getById, 5=getByName, 6=getAll, 0=switch table): ");
            int option = getFromUserIntegerInRange(0, 6);

            thisOption:
            switch (option) {
                case 0: // 0=switch table
                    return;

                case 1: // 1=create
                    System.out.println("\tCREATE (0=cancel):");
                    Customer customer1 = new Customer();
                    System.out.print("\tInput <name>: ");
                    String setName = getFromUserString();
                    if (setName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    customer1.setName(setName);
                    int id = customerDAO.create(customer1);
                    customer1.setId(id);
                    customer1 = customerDAO.getById(id);
                    if (customer1 != null) {
                        System.out.println("\tSuccessfully created:");
                        System.out.print("\t\t");
                        customer1.show();
                    }
                    break;

                case 2: // 2=update
                    System.out.println("\tUPDATE (0=cancel):");
                    Customer customer2;
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int updatedId = getFromUserInteger();
                        if (updatedId == 0) {
                            System.out.println("\tCanceled.");
                            break thisOption;
                        }
                        customer2 = customerDAO.getById(updatedId);
                        if (customer2 == null) {
                            System.out.println("\tNot found. Please try again.");
                        } else {
                            System.out.println("\tCurrent properties:");
                            System.out.print("\t\t");
                            customer2.show();
                            break;
                        }
                    }
                    System.out.print("\tInput new <name>: ");
                    String newName = getFromUserString();
                    if (newName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    customer2.setName(newName);
                    System.out.println("\tSuccessfully updated.");
                    break;

                case 3: // 3=delete
                    System.out.println("\tDELETE (0=cancel):");
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int deleteId = getFromUserInteger();
                        if (deleteId == 0) {
                            System.out.println("\tCanceled.");
                            break;
                        }
                        boolean success = customerDAO.delete(deleteId);
                        if (success) {
                            System.out.println("\tSuccessfully deleted.");
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 4: // 4=getById
                    System.out.println("\tGET BY ID (0=cancel):");
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int getId = getFromUserInteger();
                        if (getId == 0) {
                            System.out.println("\tCanceled.");
                            break;
                        }
                        Customer customer4 = customerDAO.getById(getId);
                        if (customer4 != null) {
                            System.out.print("\t\t");
                            customer4.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 5: // 5=getByName
                    System.out.println("\tGET BY NAME (0=cancel):");
                    while (true) {
                        System.out.print("\tInput <name>: ");
                        String getName = getFromUserString();
                        if (getName.equals("0")) {
                            System.out.println("\tCanceled.");
                            break;
                        }
                        Customer customer5 = customerDAO.getByName(getName);
                        if (customer5 != null) {
                            System.out.print("\t\t");
                            customer5.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 6: // 6=getAll
                    System.out.println("\tGET ALL:");
                    List<Customer> customers = customerDAO.listAll();
                    if (customers.size() > 0) {
                        System.out.println("\tAll items in table:");
                        for (Customer i : customers) {
                            System.out.print("\t\t");
                            i.show();
                        }
                    }else System.out.println("Selected table is empty.");
                    break;
            }
        }
    }
}
