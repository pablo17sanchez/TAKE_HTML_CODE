/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.go.ww;

/**
 *
 * @author psanchez
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class URLexample extends JFrame{
  JTextArea area = new JTextArea("Area de texto....");
public static String directorio = "https://youtube.com";

    public URLexample() throws HeadlessException {
    super("Prueba URL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600,400));
        //Prefiero este size para la aplicacion 
      JScrollPane pane = new JScrollPane(area);
        add(pane);
        try {
            //Mi lookandfeel favorito es nimbus
              UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        setVisible(true);
    }
    
    public void ObtenerDatos(String direccion)throws MalformedURLException{
    
    URL url = new URL(direccion);
    StringBuffer linea= new StringBuffer(); 
//StringBuffer para acoplar las lineas 
    
        try {
            
            //Obtener respuesta de la pagina web 
            HttpURLConnection httconection = (HttpURLConnection) url.openConnection();
            httconection.connect();
           InputStreamReader inputr = new InputStreamReader((InputStream)httconection.getContent());
           BufferedReader buff = new BufferedReader(inputr);
           String directo;
            do {                
                directo=buff.readLine();
                linea.append(directo+"\n");
            } while (directo!=null);
           area.setText(linea.toString());
        } catch (Exception e) {
        System.out.println("Error: "+e.getMessage());
        
        }
        
 
    
    }
    public static void main(String[] args) {
        
       URLexample ejemplo = new URLexample();
       
        if (directorio!=null|| directorio!="") {
            try {
                ejemplo.ObtenerDatos(directorio);
            } catch (MalformedURLException e) {
                System.out.println("Error en la url" +e.getMessage());
                
               }
                  
          
            
        }
        
    }
}
