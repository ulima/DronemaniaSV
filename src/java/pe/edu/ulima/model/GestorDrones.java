
package pe.edu.ulima.model;

import java.util.ArrayList;
import java.util.List;
import pe.edu.ulima.model.beans.Drone;

public class GestorDrones {
    private static GestorDrones singleton = null;
    
    public static GestorDrones getInstance(){
        if (singleton == null){
            singleton = new GestorDrones();
        }
        return singleton;
    }
    
    public List<Drone> obtenerDrones(){
        Drone drone1 = new Drone(1, "Nano Drone QX RTF", "Horizon", 95, 4);
        Drone drone2 = new Drone(2, "Blade Nano QX 3D RTF", "Horizon", 160, 3);
        Drone drone3 = new Drone(3, "Drone Phantom", "DJI", 470, 1);
        Drone drone4 = new Drone(4, "Minidrone Jumping Sumo", "Parrot", 129, 9);
        Drone drone5 = new Drone(5, "AR.Drone 2.0 Elite Edition", "Parrot", 230, 0);
        
        List<Drone> lista = new ArrayList<Drone>();
        lista.add(drone1);
        lista.add(drone2);
        lista.add(drone3);
        lista.add(drone4);
        lista.add(drone5);
        
        return lista;
    }
}
