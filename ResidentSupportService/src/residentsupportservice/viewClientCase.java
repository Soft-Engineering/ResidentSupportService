package residentsupportservice;




/**
 * Graphical interface for view of a specific case worker's client cases.
 *
 * @author Dean Rimmer
 * @version 1.8
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class viewClientCase
{   
    public static void main(String args[]){
        //Casts local arguments from args[] to local ArrayList for ease of use.
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]); 
        localArguments.add(args[3]);
        
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - View Notes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,1200);
        
        //Component Generation
        JLabel title = new JLabel("Assign Case Worker");
        JButton cancel = new JButton("Cancel");
        
        //Setting panel layout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //Setting panel layout
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.setBackground(Color.gray);

        //Set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 1000));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        cancel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            } 
        });
        
        //Instanciation and loop to get and display details of the client cases
        OutstandingAppointmentsCaseWorker os = new OutstandingAppointmentsCaseWorker();
        os.getPastAppointments(localArguments.get(3));
        int gy = 1;
        gbc.gridwidth = 1;
        for(int i =0; i<os.labelArray.size();i++){
            JLabel appointmentDate = new JLabel();
            JLabel appointmentTime = new JLabel();
            JButton select = new JButton("Ammend Notes");
            JLabel appointmentNotes = new JLabel();
            JLabel n = os.labelArray.get(i);
            String r = n.getText();
            String[] parts = r.split(" ");
            
            appointmentDate.setText(parts[0]);
            appointmentTime.setText(parts[2]);
            appointmentNotes.setText(parts[3]);
            
            select.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                AmmendClientAppointmentNotes cf = new AmmendClientAppointmentNotes();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2), parts[3], parts[1]};
                cf.main(arguments);
            } 
            });
            
            gbc.gridx = 0;
            gbc.gridy = gy;
            panel.add(appointmentDate, gbc);
            gbc.gridx = 1;
            gbc.gridy = gy;
            panel.add(appointmentTime, gbc);
            gbc.gridx = 2;
            gbc.gridy = gy;
            panel.add(appointmentNotes, gbc);
            gbc.gridx = 3;
            gbc.gridy = gy;
            panel.add(select, gbc);
            gy++;
            if(i>4){
                break;
            }
        }
     
        //Back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(cancel, gbc);
        
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