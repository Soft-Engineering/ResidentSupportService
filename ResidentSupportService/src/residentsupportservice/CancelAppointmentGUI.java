package residentsupportservice;


/**
 * Graphical interface for the cancel appointment functionality, only to be accessed by case workers.
 * @author Dean Rimmer
 * @version 1.3
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class CancelAppointmentGUI
{   
    public static void main(String args[]){
        //Casts local arguments from args[] to local ArrayList for ease of use.
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]); 
        
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Cancel Appointment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("Cancel Appointment");
        JLabel caseIDLabel = new JLabel("Case ID:");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel dobLabel = new JLabel("D.O.B:");
        JTextField caseID = new JTextField(20);
        JTextField firstName = new JTextField(20);
        JTextField lastName = new JTextField(20);
        JTextField dob = new JTextField(20);
        JButton submit = new JButton("Submit");
        JLabel or = new JLabel("OR");
        JButton back = new JButton("Back");
        JButton logOut = new JButton("Log Out");
        
        //Setting panel layout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //Setting panel layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.gray);

        //Set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //Setting action listeners for buttons
        logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                LoginGUI loginScreen = new LoginGUI();
                String[] arguments = new String[] {"123"};
                loginScreen.main(arguments);
            } 
        });
        
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                AdminGUI newgui = new AdminGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            } 
        });
        
        submit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if(caseID.getText().equals("")){
                    CancelAppointment ca = new CancelAppointment(firstName.getText(), lastName.getText(), dob.getText());
                }
                if(!caseID.getText().equals("")){
                    System.out.println("Hello");
                    CancelAppointment ca = new CancelAppointment(caseID.getText());
                }                
            } 
        });
        
        //Adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        //Case ID label constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(caseIDLabel, gbc);
        
        //Case ID constraints
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(caseID, gbc);
        
        //Or constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(or, gbc);
        
        //First name label constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(firstNameLabel, gbc);
        //Fist name constraints
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(firstName, gbc);
        
        //Last name label constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(lastNameLabel, gbc);
        //Last name constraints
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(lastName, gbc);
        
        //Dob label contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(dobLabel, gbc);
        //Dob constraints
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(dob, gbc);
        
        //Submit button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(submit, gbc);
        
        //Back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipady = 20;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,20,20,20);
        panel.add(back, gbc);
        
        //Log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,20,20);
        panel.add(logOut, gbc);
        
        //Creating the personalised information frame for the user at the bottom of the page.
        JPanel p = new JPanel();
        infoPanel ip = new infoPanel(args[0], args[1], args[2]);
        p = ip.getPanel();

        //Add both panels to the frame, one for main gui of the frame and the other for the personalised user information panel at the bottom of the page.
        frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}