package residentsupportservice;




/**
 * Graphical interface for the home page if the user is a case worker.
 *
 * @author Dean Rimmer
 * @version 1.1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CaseWorkerGUI
{   
    public static void main(String args[]){
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("Home");
        JButton viewAppointments = new JButton("View My Appointments");
        JButton followUpAppointment = new JButton("Create Follow-up Appointment");
        JButton cancelAppointment = new JButton("Cancel Appointment");
        JButton editAppointment = new JButton("Edit Appointment");
        JButton back = new JButton("Back");
        JButton logOut = new JButton("Log Out");
        
         //setting action listeners for buttons
        logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                LoginGUI loginScreen = new LoginGUI();
                String[] arguments = new String[] {"123"};
                loginScreen.main(arguments);
                frame.dispose();
            } 
        });
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                CaseWorkerGUI newgui = new CaseWorkerGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        viewAppointments.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                ViewAllCasesGUI newgui = new ViewAllCasesGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        followUpAppointment.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                CreateFollowUpGUI newgui = new CreateFollowUpGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        cancelAppointment.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                CancelAppointmentGUI newgui = new CancelAppointmentGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        editAppointment.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                EditAppointmentGUI newgui = new EditAppointmentGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        
        //Setting panel layout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //Setting panel layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.gray);

        // set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        //view appointments constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(25,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(viewAppointments, gbc);
        
        //cancel appointment constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(cancelAppointment, gbc);
        
        //edit appointment constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(editAppointment, gbc);
        
        //follow up appointment contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(followUpAppointment, gbc);
        
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