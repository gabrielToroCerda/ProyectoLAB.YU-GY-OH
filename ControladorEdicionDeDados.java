package Controlador;
import Modelo.Tablero;
import Modelo.Posicion;

public class ControladorEdicionDeDados 
{
    private Tablero TabEditor;

    public ControladorEdicionDeDados() 
    {
        TabEditor = new Tablero();
    }
    
    public Tablero matrizDeCriaturasEdicion()
    {
        return TabEditor;
    }

    
    
    
}
