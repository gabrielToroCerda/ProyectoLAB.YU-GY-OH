package Modelo;

public class Criatura extends elementoEnCampo
{
    private int nivel;
    
    public Criatura(String TIPO, int VIDA, int ATAQUE, int DEFENSA, String NOMBRE, int NIVEL) 
    {
        super(TIPO, VIDA, ATAQUE, DEFENSA, NOMBRE);
        nivel=NIVEL;
    }

    public int getNivel() 
    {
        return nivel;
    }
}
