package residentsupportservice;




/**
 * Graphical interface for the home page if the user is an administrator.
 *
 * @author Dean Rimmer
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminGUI
{   
    public static void main(String args[]){
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("Home");
        JButton openNewCase = new JButton("Open New Case");
        JButton closeCase = new JButton("Close Case");
        JButton viewCases = new JButton("View All Cases");
        JButton outstandingAppointments = new JButton("Outstanding Appointments");
        JButton back = new JButton("Back");
        JButton logOut = new JButton("Log Out");
        
        //Setting panel layout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //setting action listeners for buttons
        logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            } 
        });
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                LoginGUI newgui = new LoginGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        openNewCase.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                OpenNewCaseGUI newgui = new OpenNewCaseGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        closeCase.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                CloseCaseGUI newgui = new CloseCaseGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        viewCases.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                ViewAllCasesGUI newgui = new ViewAllCasesGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        outstandingAppointments.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                ViewAllCasesGUI newgui = new ViewAllCasesGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        
        
        //adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        panel.add(title, gbc);
        
        //open case constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(25,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(openNewCase, gbc);
        
        //close case constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(closeCase, gbc);
        
        //view cases constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(viewCases, gbc);
        
        //outstanding appointments contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(outstandingAppointments, gbc);
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(logOut, gbc);
        
        //setting the frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
