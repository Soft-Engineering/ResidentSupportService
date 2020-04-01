package residentsupportservice;




/**
 * Graphical interface for the open case interface, will be used by administrators.
 *
 * @author Dean Rimmer
 * @version 1.1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class OpenNewCaseGUI
{   
    public static void main(String args[]){
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Open New Case");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        
        //Component Generation
        JLabel title = new JLabel("Create Case");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel dobLabel = new JLabel("D.O.B:");
        JLabel emailLabel = new JLabel("Email Address:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel reasonLabel = new JLabel("Reason for Case:");
        JTextField caseID = new JTextField(20);
        JTextField firstName = new JTextField(20);
        JTextField lastName = new JTextField(20);
        JTextField email = new JTextField(20);
        JTextField phoneNumber = new JTextField(20);
        JTextField dob = new JTextField(20);
        JTextField reason = new JTextField(20);
        JButton check = new JButton("Check");
        JButton createNew = new JButton("Create New");
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

        // set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //setting action listeners for buttons
        logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            } 
        });
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                AdminGUI newgui = new AdminGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        check.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                CreateNewCase ca = new CreateNewCase(firstName.getText(), lastName.getText(), email.getText(), phoneNumber.getText(), dob.getText(), reason.getText());
            } 
        });
        
        //adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        //first name constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(firstNameLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(firstName, gbc);
        
        //last name constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(lastNameLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(lastName, gbc);
        
        //dob contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(dobLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(dob, gbc);
        
        //email constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(emailLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(email, gbc);
        
        //phone number constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(phoneNumberLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(phoneNumber, gbc);
        
        //reason constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(reasonLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(reason, gbc);
        
        //check button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(check, gbc);
        
        //create button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(createNew, gbc);
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.ipady = 20;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,20,20,20);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,20,20);
        panel.add(logOut, gbc);
        
        //setting the frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}