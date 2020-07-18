/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.modelo.Telefono;
/**
 *
 * @author Anahi
 */
public class ControladorTelefono {
    private Telefono telefono;
    private TelefonoDao telefonoDAO;

    public ControladorTelefono(TelefonoDao telefonoDAO) {
       
        this.telefonoDAO = telefonoDAO;
    }
    
    public void crearTelefono(Telefono telefono){
        telefonoDAO.create(telefono);
    }
    
    public Telefono encontrarTelefono(int codigo){
        
        telefono = telefonoDAO.read(codigo);
        
        return telefono;
    }
}
