/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static timer.NewJFrame.lblMensaje;
import static timer.NewJFrame.lblTime;
import static timer.NewJFrame.time;

/**
 *
 * @author user6
 */
public class Tiempo extends Thread   {

	@Override
	public void run() {

            
            lblTime.setText(time + "");
            try {
                int t = time;
                while (t >= 0){
                    t = Integer.parseInt(lblTime.getText());
                    lblTime.setText(--t + "");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }            
            lblMensaje.setText("Apagando...");
            String comando= ""; 
//            if(System.getProperty("os.name").equals("Windows")) 
            comando= "shutdown -s -t 1 "; 
//            if(System.getProperty("os.name").equals("Linux")) 
//            comando= "halt"; 
            try { 
                Runtime.getRuntime().exec(comando);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
}
