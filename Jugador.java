package Modelo;


public class Jugador 
{
    
    private String nombre ; 
    private String pass;
    private  Criatura [] criaturas;
    private PuzleDeDados puzleDeDados;

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getPass() 
    {
        return pass;
    }

    public void setPass(String pass) 
    {
        this.pass = pass;
    }

    public Criatura[] getCriaturas() 
    {
        return criaturas;
    }

    public void setCriaturas(Criatura[] criaturas) 
    {
        this.criaturas = criaturas;
    }

    public PuzleDeDados getPuzleDeDados() 
    {
        return puzleDeDados;
    }

    public void setPuzleDeDados(PuzleDeDados puzleDeDados) 
    {
        this.puzleDeDados = puzleDeDados;
    }
    
    //constructor de usuario
    
    public Jugador(String nombre, String pass)
    {
    this.setNombre(nombre);
    this.setPass(pass);
    }
    
    public Jugador(String nombre, String pass,Criatura [] criaturas,PuzleDeDados puzleDeDados)
    {
    this.setNombre(nombre);
    this.setPass(pass);
    this.setCriaturas(criaturas);
    this.setPuzleDeDados(puzleDeDados);
    }
    
    public boolean CrearRegistro(String Jugador, String Pass)
    {
        this.setNombre(Jugador);
        this.setPass(Pass);
        return true;
    }
    
    public boolean ConfirmarRegistro(String Jugador, String Pass)
    {
        boolean confirmacion=false;
        boolean A=Jugador.equals(this.getNombre());
        boolean B=Pass.equals(this.getPass());
        
        if(A && B)
        {
            confirmacion=true;
        }
        return confirmacion;
    }
    
}
