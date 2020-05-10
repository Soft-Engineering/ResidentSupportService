/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 * Main support service to start the program.
 * @author Dean
 */
public class ResidentSupportService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginGUI loginScreen = new LoginGUI();
        String[] arguments = new String[] {"123"};
        loginScreen.main(arguments);
    }
    
}
