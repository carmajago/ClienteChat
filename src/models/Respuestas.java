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
    
    public static final String OK="100";
    public static final String REGISTRO_OK="101";
    public static final String MENSAJE_ENVIADO="102";
    public static final String MENSAJE_BROADCAST="103";
    public static final String MENSAJE_ELIMINADO="104";
    public static final String NUM_USERS="105";
    public static final String GET_USERS="106";
    
    public static final String REGISTRO_ERROR="201";
    public static final String MENSAJE_NO_ENVIADO="202";
    public static final String MENSAJE_NO_BROADCAST="203";
    public static final String USUARIO_NO_VALIDO="204";
    public static final String MENSAJE_NO_BORRADO="205";
    public static final String LIMITE_INTENTOS="206";

 
    
    
    public static String  GetRespuesta(String data){
     
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
                mensaje="El usuario ya se encuentra registrado";
                break;
            case(MENSAJE_NO_ENVIADO):
                mensaje="El mensaje no se a enviado";
                break;
            case(MENSAJE_NO_BROADCAST):
                mensaje="El mensaje no se a enviado";
                break;
            case(USUARIO_NO_VALIDO):
                mensaje="Ingrese minimo 8 caracteres";
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
    
    public static boolean  Register(String data){
        
        if(data.equals(REGISTRO_OK))
            return true;
        
        return false;
    }
    public static boolean numerouser(String data){
     if(data.equals(NUM_USERS))  
         return true;
     
     return false;
    }
    
    public static boolean geUsers(String data){
        if(data.equals(GET_USERS))
            return true;
        
        return false;
    }
    public static boolean isMsg(String data){
        if(data.equals(MENSAJE_ENVIADO) || data.equals(MENSAJE_BROADCAST)){
            return true;
        }
        return false;
    }
    public static boolean isMsgError(String data){
        if(data.equals(MENSAJE_NO_ENVIADO) || data.equals(MENSAJE_NO_BROADCAST)){
            return true;
        }
        return false;
    }
    
}
