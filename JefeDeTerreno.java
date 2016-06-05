package Modelo;

public class JefeDeTerreno extends elementoEnCampo
{
    private int habilidad;
    
    public JefeDeTerreno(String TIPO, int VIDA, int ATAQUE, int DEFENSA, String NOMBRE) 
    {
        super(TIPO, VIDA, ATAQUE, DEFENSA, NOMBRE);
    }

    public int getHabilidad() 
    {
        return habilidad;
    }

    public void setHabilidad(int habilidad) 
    {
        this.habilidad = habilidad;
    }
}
