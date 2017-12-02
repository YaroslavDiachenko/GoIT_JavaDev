
import controller.TerminalControl;
import util.HibernateUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        HibernateUtil.buildSessionFactory();
        TerminalControl terminalControl = new TerminalControl();
        terminalControl.beginInteraction();
    }
}
