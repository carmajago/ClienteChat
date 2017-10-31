/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class   Respuestas {
    
    public static final int OK=100;
    public static final int REGISTRO_OK=101;
    public static final int MENSAJE_ENVIADO=102;
    public static final int MENSAJE_BROADCAST=103;
    public static final int MENSAJE_ELIMINADO=104;
    public static final int NUM_USERS=105;
    public static final int GET_USERS=106;
    
    public static final int REGISTRO_ERROR=201;
    public static final int MENSAJE_NO_ENVIADO=202;
    public static final int MENSAJE_NO_BROADCAST=203;
    public static final int USUARIO_NO_VALIDO=204;
    public static final int MENSAJE_NO_BORRADO=205;
    public static final int LIMITE_INTENTOS=206;

 
    
    
    public static String  GetRespuesta(int data){
     
        String mensaje="";
                
        switch(data){
            case(OK):
                mensaje="confirmación ok";
                break;
            case(REGISTRO_OK):
                mensaje="Registro exitoso";
                break;
            case(MENSAJE_ENVIADO):
                mensaje="Mensaje enviado";
                break;
            case(MENSAJE_BROADCAST):
                mensaje="Mensaje enviado a todos";
                break;
            case(MENSAJE_ELIMINADO):
                mensaje="Mensaje Eliminado";
                break;
            case(NUM_USERS):
                mensaje="Numero de usuarios";
                break;
            case(REGISTRO_ERROR):
                mensaje="Error al registrar";
                break;
            case(MENSAJE_NO_ENVIADO):
                mensaje="El mensaje no se a enviado";
                break;
            case(MENSAJE_NO_BROADCAST):
                mensaje="El mensaje no se a enviado";
                break;
            case(USUARIO_NO_VALIDO):
                mensaje="Usuario no valido";
                break;
            case(MENSAJE_NO_BORRADO):
                mensaje="Mensaje no eliminado";
                break;
            case(LIMITE_INTENTOS):
                mensaje="Limite de intentos excedido";
                break;
            default:
                mensaje="Desconocido";
        }
    return mensaje;
    }
    
    public static boolean  Register(int data){
        
        if(data==101)
            return true;
        
        return false;
    }
    
    public static boolean geUsers(int data){
        if(data==106)
            return true;
        
        return false;
    }
    
}
