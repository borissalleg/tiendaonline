package com.empleado.v1.util;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
    
    public static String guardarArchivo(MultipartFile multipart, String ruta){
        // String nombreOriginal = multipart.getOriginalFilename();
        // nombreOriginal.replace("","-");
        
        try {
            String nombreArchivo = multipart.getOriginalFilename();
            String sinEspacio = nombreArchivo.replace(" ","-");
            byte[] bytes =multipart.getBytes();
             System.out.println(sinEspacio);
             Path rutaAbsoluta = Paths.get(ruta + "//" +sinEspacio);
             
             Files.write(rutaAbsoluta, bytes);
             //String nombreFinal = ramdonAlpha(4) + sinEspacio;
             return sinEspacio;
            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }
    public static String ramdonAlpha(int count){
        String Caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        
        while (count !=0){
            int character = (int) (Math.random()*Caracteres.length());
            builder.append(Caracteres.charAt(character));
        }
        return builder.toString();
    }

}
