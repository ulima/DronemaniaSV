package pe.edu.ulima.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorLog {
    private static GestorLog singleton = null;
    
    private List<OnLogWritten> observers;
    
    public static GestorLog getInstance(){
        if (singleton == null){
            singleton = new GestorLog();
        }
        return singleton;
    }
    
    private GestorLog(){
        Logger logger = Logger.getLogger("MyLog");
        
    }
    
    public void addObserver(OnLogWritten onLogWritter){
        if (observers == null){
            observers = new ArrayList<OnLogWritten>();
        }
        observers.add(onLogWritter);
    }
    
    public void escribirLog(String etiqueta, String mensaje){
        try {
            System.out.println("[ " + etiqueta + "]: " + mensaje);
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (OnLogWritten observer : observers){
            observer.onLogWritten();
        }
        
    }
    
    public interface  OnLogWritten{
        public void onLogWritten();
    }
}
