package controller;


import model.Skill;
import java.util.List;
import static controller.TerminalControl.*;

public class SkillHelper {
    static void start() {
        System.out.print("Table: SKILLS");
        while (true) {
            System.out.print("\n\tChoose option (1=create, 2=update, 3=delete, 4=getById, 5=getByName, 6=getAll, 0=switch table): ");
            int action = getFromUserIntegerInRange(0, 6);

            thisOption:
            switch (action) {
                case 0: // 0=switch table
                    return;

                case 1: // 1=create
                    System.out.println("\tCREATE (0=cancel):");
                    Skill skill1 = new Skill();
                    System.out.print("\tInput <name>: ");
                    String setName = getFromUserString();
                    if (setName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    skill1.setName(setName);
                    int id = skillDAO.create(skill1);
                    skill1.setId(id);
                    skill1 = skillDAO.getById(id);
                    if (skill1 != null) {
                        System.out.println("\tSuccessfully created:");
                        System.out.print("\t\t");
                        skill1.show();
                    }
                    break;

                case 2: // 2=update
                    System.out.println("\tUPDATE (0=cancel):");
                    Skill skill2;
                    while (true) {
                        System.out.print("\tInput <id>: ");
                        int updatedId = getFromUserInteger();
                        if (updatedId == 0) {
                            System.out.println("\tCanceled.");
                            break thisOption;
                        }
                        skill2 = skillDAO.getById(updatedId);
                        if (skill2 == null) {
                            System.out.println("\tNot found. Please try again.");
                        } else {
                            System.out.println("\tCurrent properties:");
                            System.out.print("\t\t");
                            skill2.show();
                            break;
                        }
                    }
                    System.out.print("\tInput new <name>: ");
                    String newName = getFromUserString();
                    if (newName.equals("0")) {
                        System.out.println("\tCanceled.");
                        break;
                    }
                    skill2.setName(newName);
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
                        boolean success = skillDAO.delete(deleteId);
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
                        Skill skill4 = skillDAO.getById(getId);
                        if (skill4 != null) {
                            System.out.print("\t\t");
                            skill4.show();
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
                        Skill skill5 = skillDAO.getByName(getName);
                        if (skill5 != null) {
                            System.out.print("\t\t");
                            skill5.show();
                            break;
                        } else {
                            System.out.println("\tNot found. Please try again.");
                        }
                    }
                    break;

                case 6: // 6=getAll
                    System.out.println("\tGET ALL:");
                    List<Skill> skills = skillDAO.listAll();
                    if (skills.size() > 0) {
                        System.out.println("\tAll items in table:");
                        for (Skill i : skills) {
                            System.out.print("\t\t");
                            i.show();
                        }
                    }else System.out.println("Selected table is empty.");
                    break;
            }
        }
    }
}
