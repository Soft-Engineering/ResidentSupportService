package residentsupportservice;




/**
 * Graphical interface for the home page if the user is a case worker.
 *
 * @author Dean Rimmer
 * @version 2.1 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class CaseWorkerGUI
{
    public static void main(String args[]){
        //Casts local arguments from args[] to local ArrayList for ease of use.
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]);
        
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
        JButton availability = new JButton("My Availability");
        JButton logOut = new JButton("Log Out");

        //Setting action listeners for buttons
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginScreen = new LoginGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                loginScreen.main(arguments);
                frame.dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CaseWorkerGUI newgui = new CaseWorkerGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            }
        });
        viewAppointments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                OutstandingAppointmentsCaseWorker os = new OutstandingAppointmentsCaseWorker();
                os.createFrame(localArguments.get(0), localArguments.get(1), localArguments.get(2));
            }
        });
        followUpAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CreateFollowUpGUI newgui = new CreateFollowUpGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            }
        });
        cancelAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CancelAppointmentGUI newgui = new CancelAppointmentGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            }
        });
        editAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                EditAppointmentGUI newgui = new EditAppointmentGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            }
        });
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginGUI loginScreen = new LoginGUI();
                String[] arguments = new String[] {"123"};
                loginScreen.main(arguments);
            }
        });
        availability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CaseWorkerAvailabilityGUI newgui = new CaseWorkerAvailabilityGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
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

        //Set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 750));
        frame.pack();
        frame.setLocationRelativeTo(null);

        //Adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);

        //View appointments constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(25,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(viewAppointments, gbc);

        //Cancel appointment constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(cancelAppointment, gbc);


        //Follow up appointment contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(followUpAppointment, gbc);

        //Back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);

        //Availabulity button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(availability, gbc);

        //Log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(logOut, gbc);

        //Creating the personalised information frame for the user at the bottom of the page.
        JPanel p = new JPanel();
        infoPanel ip = new infoPanel(localArguments.get(0), localArguments.get(1), localArguments.get(2));
        p = ip.getPanel();
        
        //Add both panels to the frame, one for main gui of the frame and the other for the personalised user information panel at the bottom of the page.
        frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
