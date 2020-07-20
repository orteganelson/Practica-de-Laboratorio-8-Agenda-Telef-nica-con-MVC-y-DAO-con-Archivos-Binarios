/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Usuario;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Anahi
 */
public class UsuarioDao implements IUsuarioDao{
    private RandomAccessFile archivo;
    private Usuario usuario;
    private int registro;

    public UsuarioDao() {
        registro = 128;
        try {
           
            archivo = new RandomAccessFile("datos/usuario.dat", "rw");
        } catch (IOException ex) {
            System.out.println("error de escritura y lectura");
            ex.printStackTrace();
        }
    }
    @Override
    public void create(Usuario cliente) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(cliente.getCedula());
            archivo.writeUTF(cliente.getNombre());
            archivo.writeUTF(cliente.getApellido());
            archivo.writeUTF(cliente.getCorreo());
            archivo.writeUTF(cliente.getContraseña());
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura(create usuario)");
            ex.printStackTrace();
        }
    }
    @Override
    public Usuario read(String cedula) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {
                    Usuario usuario1 = new Usuario(cedula, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim());
                    return usuario1;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(readUsuario)");
        }
        return null;
    }

    @Override
    public Usuario readCorreo(String correo) {
        int salto = 66;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);

                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();

                System.out.println(correoArchivo);
                System.out.println(contraseñaArchivo);

                System.out.println(correo);

                if (correo.equals(correoArchivo.trim())) {

                    archivo.seek(salto - 66);
                    usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), correoArchivo, contraseñaArchivo);
                    return usuario;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error read Correo");
        }
        return null;
    }
    @Override
    public void update(Usuario cliente) {

        int salto = 0;
        String cedula = cliente.getCedula();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {
                    archivo.writeUTF(cliente.getNombre());
                    archivo.writeUTF(cliente.getApellido());
                    archivo.writeUTF(cliente.getCorreo());
                    archivo.writeUTF(cliente.getContraseña());
                    break;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDateUsuario)");
        }

    }

    @Override
    public void delete(Usuario cliente) {
        try {
            String cedula = cliente.getCedula();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();
                if (cedula.trim().equals(cedulaArchivo.trim())) {
                    archivo.writeUTF(llenarEspacios(10));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(50));
                    archivo.writeUTF(llenarEspacios(8));
                    break;
                }
                salto += registro;
            }

        } catch (IOException ex) {
            System.out.println("Error delete usuario");
        }
    }

    public String llenarEspacios(int espacios) {
        String aux = "";
        return String.format("%-" + espacios + "s", aux);
    }

    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
       
        try {
            int salto = 66;

            byte[] correoArreglo = new byte[50];
            byte[] contraseñaArreglo = new byte[8];

            while (salto < archivo.length()) {
                archivo.seek(salto);

                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();

                System.out.println(correoArchivo);
                System.out.println(contraseñaArchivo);

                System.out.println(correo + " " + contraseña);

                if (correo.equals(correoArchivo.trim()) && contraseña.equals(contraseñaArchivo.trim())) {

                    archivo.seek(salto - 66);
                    usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), correoArchivo, contraseñaArchivo);
                    return usuario;
                }
                salto += registro;
            }

        } catch (IOException ex) {
            System.out.println("Error escritu o lectura (iniciar sesion) ");
        }

        return null;
    }
    @Override
    public Map<String, Usuario> findAll() {
        return null;
    }
}
