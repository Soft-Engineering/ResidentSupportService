package residentsupportservice;



/**
 * Graphical interface for the login screen.
 *
 * @author Dean Rimmer
 * @version 1.9
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class LoginGUI
{   
    public static void main(String args[]){
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        
        //Component Generation
        JButton login = new JButton("Login");
        JTextField username = new JTextField(20);
        JTextField password = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
                
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
        login.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                DatabaseFunctions databaseFunctions = new DatabaseFunctions();
                User loggedInUser = databaseFunctions.logIn(username.getText(), password.getText());
                if (loggedInUser == null){
                    JOptionPane.showMessageDialog(frame, "Username or password is incorrect. Please try again");
                }
                else{
                    if(loggedInUser.getType().equals("Case worker")){
                        CaseWorkerGUI newGui = new CaseWorkerGUI();
                        String[] arguments = new String[] {Integer.toString(loggedInUser.getId()), loggedInUser.getForename(), loggedInUser.getSurname()};
                        newGui.main(arguments);
                        
                       
                    }
                    else{
                        AdminGUI newGui = new AdminGUI();
                        String[] arguments = new String[] {Integer.toString(loggedInUser.getId()), loggedInUser.getForename(), loggedInUser.getSurname()};
                        newGui.main(arguments);
                    }
                }
                frame.dispose();
            } 
        });
        
        
        //Adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;        
        panel.add(username, gbc);
 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(password, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(login, gbc);
       
        //Setting the frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
