/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import javax.swing.JFrame;
import view.Inicio;
import view.InicioSesion;
import view.Menu;
import view.Registro;


public class Redirect {
    
    public static void redireccion(int idvista){
        switch (idvista) {
            //Vista Inicio
            case 1:
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                inicio.setLocationRelativeTo(null);
                inicio.setSize(400,300);
                break;
            case 2:
                Registro registro = new Registro();
                registro.setVisible(true);
                registro.setLocationRelativeTo(null);
                registro.setSize(400,300);
                break;
            case 3:
                InicioSesion iniciosesion= new InicioSesion();
                iniciosesion.setVisible(true);
                iniciosesion.setLocationRelativeTo(null);
                iniciosesion.setSize(400,300);
                break;
            case 4:
                Menu menu= new Menu();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                menu.setSize(400,300);
                break;
            default:
                throw new AssertionError();
        }
        
        

//para.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
