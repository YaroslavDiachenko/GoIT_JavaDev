package controller;


import model.Company;
import java.util.List;
import static controller.TerminalControl.*;

class CompanyHelper {
    static void start() {
        System.out.print("Table: COMPANIES");
        while (true) {
            System.out.print("\n\tChoose option (1=create, 2=update, 3=delete, 4=getById, 5=getByName, 6=getAll, 0=switch table): ");
            int option = getFromUserIntegerInRange(0, 6);

            thisOption:
            switch (option) {
                case 0: // 0=switch table
                    return;

                case 1: // 1=create
                    System.out.println("\tCREATE (0=cancel):");
                    Company company1 = new Company();
                    System.out.print("\tInput <name>: ");
                    String setName = getFromUserString();
                    if (setName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    company1.setName(setName);
                    int id = companyDAO.create(company1);
                    company1.setId(id);
                    company1 = companyDAO.getById(id);
                    if (company1 != null) {
                        System.out.println("\tSuccessfully created:");
                        System.out.print("\t\t");
                        company1.show();
                    }
                    break;

                case 2: // 2=update
                    System.out.println("\tUPDATE (0=cancel):");
                    Company company2;
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int updatedId = getFromUserInteger();
                        if (updatedId == 0) {
                            System.out.println("\tCanceled.");
                            break thisOption;
                        }
                        company2 = companyDAO.getById(updatedId);
                        if (company2 == null) {
                            System.out.println("\tNot found. Please try again.");
                        } else {
                            System.out.println("\tCurrent properties:");
                            System.out.print("\t\t");
                            company2.show();
                            break;
                        }
                    }
                    System.out.print("\tInput new <name>: ");
                    String newName = getFromUserString();
                    if (newName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    company2.setName(newName);
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
                        boolean success = companyDAO.delete(deleteId);
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
                        Company company4 = companyDAO.getById(getId);
                        if (company4 != null) {
                            System.out.print("\t\t");
                            company4.show();
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
                        Company company5 = companyDAO.getByName(getName);
                        if (company5 != null) {
                            System.out.print("\t\t");
                            company5.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 6: // 6=getAll
                    System.out.println("\tGET ALL:");
                    List<Company> companies = companyDAO.listAll();
                    if (companies.size() > 0) {
                        System.out.println("\tAll items in table:");
                        for (Company i : companies) {
                            System.out.print("\t\t");
                            i.show();
                        }
                    }else System.out.println("Selected table is empty.");
                    break;
            }
        }
    }
}