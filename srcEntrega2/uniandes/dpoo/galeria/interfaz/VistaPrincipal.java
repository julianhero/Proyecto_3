package uniandes.dpoo.galeria.interfaz;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class VistaPrincipal extends JFrame implements ActionListener{
	private JPanel vistaTarjetas;
	public VistaPrincipal() {
		vistaTarjetas = new JPanel();
		vistaTarjetas.setLayout(new CardLayout());
		this.add(vistaTarjetas);
		
		FormLogin login = new FormLogin(this);
		RegisterPanel register = new RegisterPanel();
		CompradorPanel comprador = new CompradorPanel();
		
		vistaTarjetas.add(login, "LOGIN");
		vistaTarjetas.add(register, "REGISTER");
		vistaTarjetas.add(comprador, "COMPRADOR");
		
		
		
		
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	public static void main(String args[]) {
		//VistaPrincipal vistaPrincipal = new VistaPrincipal();
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaPrincipal vistaPrincipal = new VistaPrincipal();
            }
        });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String siguienteVista = e.getActionCommand();
		CardLayout cl = (CardLayout)(vistaTarjetas.getLayout());
		cl.show(vistaTarjetas, siguienteVista);
	}
}
