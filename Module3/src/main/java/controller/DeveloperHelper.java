package controller;

import model.Developer;
import model.Skill;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static controller.TerminalControl.*;

class DeveloperHelper {

    static void start() {
        System.out.println("Table: DEVELOPERS");
        while (true) {
            System.out.print("\n\tChoose option (1=create, 2=update, 3=delete, 4=getById, 5=getByName, 6=getAll, 0=switch table): ");
            int option = getFromUserIntegerInRange(0, 6);

            thisOption:
            switch (option) {
                case 0: // 0=switch table
                    return;

                case 1: // 1=create
                    System.out.println("\tCREATE (0=cancel):");
                    Developer developer1 = new Developer();
                    System.out.print("\tInput new <first name>: ");
                    String setFirstName = getFromUserString();
                    if (setFirstName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    developer1.setFirstName(setFirstName);
                    System.out.print("\tInput new <last name>: ");
                    developer1.setLastName(getFromUserString());
                    System.out.print("\tInput new <salary>: ");
                    developer1.setSalary(new BigDecimal(getFromUserDouble()));
                    int id = developerDAO.create(developer1);
                    developer1.setId(id);
                    developer1 = developerDAO.getById(id);
                    if (developer1 != null) {
                        System.out.println("\tSuccessfully created:");
                        System.out.print("\t\t");
                        developer1.show();
                    }
                    break;

                case 2: // 2=update
                    System.out.println("\tUPDATE (0=cancel):");
                    Developer developer2;
                    boolean changesMade = false;
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int updatedId = getFromUserInteger();
                        if (updatedId == 0) {
                            System.out.println("\tCanceled.");
                            break thisOption;
                        }
                        developer2 = developerDAO.getById(updatedId);
                        if (developer2 == null) {
                            System.out.println("\tNot found. Please try again.");
                        } else {
                            System.out.println("\tCurrent properties:");
                            System.out.print("\t\t");
                            developer2.show();
                            break;
                        }
                    }
                    modifyObject:
                    while (true) {
                        System.out.print("\tSelect property to update (1=first name, 2=last name, 3=salary, 4=skills, 0=finish): ");
                        int property = getFromUserIntegerInRange(0, 4);
                        switch (property) {
                            case 0: // 0=finish
                                break modifyObject;
                            case 1: // 1=first name
                                System.out.print("\tInput new <first name>: ");
                                developer2.setFirstName(getFromUserString());
                                changesMade = true;
                                break;
                            case 2: // 2=last name
                                System.out.print("\tInput new <last name>: ");
                                developer2.setLastName(getFromUserString());
                                changesMade = true;
                                break;
                            case 3: // 3=salary
                                System.out.print("\tInput new <salary>: ");
                                developer2.setSalary(new BigDecimal(getFromUserDouble()));
                                changesMade = true;
                                break;
                            case 4: // 4=skills
                                while (true) {
                                    System.out.print("\tInput <ids> (separated by comma): ");
                                    int[] skills_ids = getFromUserListOfIntegers();
                                    if (skills_ids[0] == 0) {
                                        System.out.println("\tCanceled.");
                                        break;
                                    }
                                    Set<Skill> skills = skillDAO.getSetByIds(skills_ids);
                                    if (skills != null) {
                                        developer2.setSkills(skills);
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
                        developerDAO.update(developer2);
                        System.out.println("\tSuccessfully updated:");
                        System.out.print("\t\t");
                        developer2.show();
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
                        boolean success = developerDAO.delete(deleteId);
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
                        Developer developer4 = developerDAO.getById(getId);
                        if (developer4 != null) {
                            System.out.print("\t\t");
                            developer4.show();
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
                        Developer developer5 = developerDAO.getByName(getName);
                        if (developer5 != null) {
                            System.out.print("\t\t");
                            developer5.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 6: // 6=getAll
                    System.out.println("\tGET ALL:");
                    List<Developer> developers = developerDAO.listAll();
                    if (developers.size() > 0) {
                        System.out.println("\tAll items in table:");
                        for (Developer i : developers) {
                            System.out.print("\t\t");
                            i.show();
                        }
                    }else System.out.println("Selected table is empty.");
                    break;
            }
        }

    }
}
