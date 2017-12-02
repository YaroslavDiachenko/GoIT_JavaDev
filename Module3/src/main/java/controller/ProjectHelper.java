package controller;

import model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static controller.TerminalControl.*;

public class ProjectHelper {
    static void start() {
        System.out.println("Table: PROJECTS");
        while (true) {
            System.out.print("\n\tChoose option (1=create, 2=update, 3=delete, 4=getById, 5=getByName, 6=getAll, 0=switch table): ");
            int option = getFromUserIntegerInRange(0, 6);

            thisOption:
            switch (option) {
                case 0: // 0=switch table
                    return;

                case 1: // 1=create
                    System.out.println("\tCREATE (0=cancel):");
                    Project project1 = new Project();
                    System.out.print("\tInput <name>: ");
                    String setName = getFromUserString();
                    if (setName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    project1.setName(setName);
                    System.out.print("\tInput <cost>: ");
                    project1.setCost(new BigDecimal(getFromUserDouble()));
                    int id = projectDAO.create(project1);
                    project1.setId(id);
                    project1 = projectDAO.getById(id);
                    if (project1 != null) {
                        System.out.println("\tSuccessfully created:");
                        System.out.print("\t\t");
                        project1.show();
                    }
                    break;

                case 2: // 2=update
                    System.out.println("\tUPDATE (0=cancel):");
                    Project project2;
                    boolean changesMade = false;
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int updatedId = getFromUserInteger();
                        if (updatedId == 0) {
                            System.out.println("\tCanceled.");
                            break thisOption;
                        }
                        project2 = projectDAO.getById(updatedId);
                        if (project2 == null) {
                            System.out.println("\tNot found. Please try again.");
                        } else {
                            System.out.println("\tCurrent properties:");
                            System.out.print("\t\t");
                            project2.show();
                            break;
                        }
                    }
                    modifyObject:
                    while (true) {
                        System.out.print("\tSelect property to update (1=name, 2=cost, 3=companies, 4=customers, 5=developers, 0=finish): ");
                        int property = getFromUserIntegerInRange(0, 5);
                        switch (property) {
                            case 0: // 0=finish
                                break modifyObject;
                            case 1: // 1=name
                                System.out.print("\tInput new <name>: ");
                                project2.setName(getFromUserString());
                                changesMade = true;
                                break;
                            case 2: // 2=cost
                                System.out.print("\tInput new <cost>: ");
                                project2.setCost(new BigDecimal(getFromUserDouble()));
                                changesMade = true;
                                break;
                            case 3: // 3=companies
                                while (true) {
                                    System.out.print("\tInput companies' <ids> (separated by comma): ");
                                    int[] companies_ids = getFromUserListOfIntegers();
                                    if (companies_ids[0] == 0) {
                                        System.out.println("\tCanceled.");
                                        break;
                                    }
                                    Set<Company> companies = companyDAO.getSetByIds(companies_ids);
                                    if (companies != null) {
                                        project2.setCompanies(companies);
                                        changesMade = true;
                                        break;
                                    } else {
                                        System.out.println("\tNot all found. Please try again.");
                                    }
                                }
                            case 4: // 4=customers
                                while (true) {
                                    System.out.print("\tInput customers' <ids> (separated by comma): ");
                                    int[] customers_ids = getFromUserListOfIntegers();
                                    if (customers_ids[0] == 0) {
                                        System.out.println("\tCanceled.");
                                        break;
                                    }
                                    Set<Customer> customers = customerDAO.getSetByIds(customers_ids);
                                    if (customers != null) {
                                        project2.setCustomers(customers);
                                        changesMade = true;
                                        break;
                                    } else {
                                        System.out.println("\tNot all found. Please try again.");
                                    }
                                }
                            case 5: // 5=developers
                                while (true) {
                                    System.out.print("\tInput developers' <ids> (separated by comma): ");
                                    int[] developers_ids = getFromUserListOfIntegers();
                                    if (developers_ids[0] == 0) {
                                        System.out.println("\tCanceled.");
                                        break;
                                    }
                                    Set<Developer> developers = developerDAO.getSetByIds(developers_ids);
                                    if (developers != null) {
                                        project2.setDevelopers(developers);
                                        changesMade = true;
                                        break;
                                    } else {
                                        System.out.println("\tNot all found. Please try again.");
                                    }
                                }
                                break;
                        }
                    }
                    if (changesMade) {
                        projectDAO.update(project2);
                        System.out.println("\tSuccessfully updated:");
                        System.out.print("\t\t");
                        project2.show();
                    } else {
                        System.out.println("No changes made");
                    }
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
                        boolean success = projectDAO.delete(deleteId);
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
                        Project project4 = projectDAO.getById(getId);
                        if (project4 != null) {
                            System.out.print("\t\t");
                            project4.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 5: // 5=getByName
                    System.out.println("\tGET BY NAME (0=cancel):");
                    while (true) {
                        System.out.print("\tInput <last name>: ");
                        String getName = getFromUserString();
                        if (getName.equals("0")) {
                            System.out.println("\tCanceled.");
                            break;
                        }
                        Project project5 = projectDAO.getByName(getName);
                        if (project5 != null) {
                            System.out.print("\t\t");
                            project5.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 6: // 6=getAll
                    System.out.println("\tGET ALL:");
                    List<Project> projects = projectDAO.listAll();
                    if (projects.size() > 0) {
                        System.out.println("\tAll items in table:");
                        for (Project i : projects) {
                            System.out.print("\t\t");
                            i.show();
                        }
                    }else System.out.println("Selected table is empty.");
                    break;
            }
        }

    }
}

