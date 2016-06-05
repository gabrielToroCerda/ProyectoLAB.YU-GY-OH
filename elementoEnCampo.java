package Modelo;

public class elementoEnCampo 
{
    private String tipo;
    private int vida;
    private int ataque;
    private int defensa;
    private String Nombre;
    
    public elementoEnCampo (String TIPO, int VIDA, int ATAQUE, int DEFENSA, String NOMBRE)
    {
        tipo=TIPO;
        vida=VIDA;
        ataque=ATAQUE;
        defensa=DEFENSA;
        Nombre=NOMBRE;
    }

    //gets
    public String getTipo() 
    {
        return tipo;
    }

    public int getVida() 
    {
        return vida;
    }
    public int getAtaque() 
    {
        return ataque;
    }

    public int getDefensa() 
    {
        return defensa;
    }

    public String getNombre() 
    {
        return Nombre;
    }
    
}
