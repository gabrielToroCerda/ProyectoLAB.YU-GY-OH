package Modelo;

import java.awt.Font;
import javax.swing.JButton;

public class Posicion 
{
    private JButton boton;
    private boolean toque;
    private boolean uso;
    private int fila;
    private int columna;
    private int numeroDeCasilla;
    private String TipoDeUso;
    private JefeDeTerreno JDT;
    private Criatura monstruo;
    
    public Posicion(int FILA, int COLUMNA, int NUMERODECASILLA)
    {
        Font fuente= new Font("TimesRoman", Font.BOLD, 10);
        boton= new JButton();
        boton.setFont(fuente);
        boton.setText(String.valueOf(NUMERODECASILLA));
        toque=false;
        uso=false;
        fila=FILA;
        columna=COLUMNA;
        numeroDeCasilla=NUMERODECASILLA;
    }

    public Posicion()
    {
        boton= new JButton();
        toque=false;
        uso=false;
    }
    public JButton getBoton() 
    {
        return boton;
    }

    public int getColumna() 
    {
        return columna;
    }

    public int getFila() 
    {
        return fila;
    }

    public int getNumeroDeCasilla() 
    {
        return numeroDeCasilla;
    }
    
    public boolean getUso() 
    {
        return uso;
    }

    public Criatura getMonstruo() 
    {
        return monstruo;
    }

    public JefeDeTerreno getJDT() 
    {
        return JDT;
    }

    public String getTipoDeUso() 
    {
        return TipoDeUso;
    }
    
    public void setColumna(int columna) 
    {
        this.columna = columna;
    }

    public void setFila(int fila) 
    {
        this.fila = fila;
    }

    public void setToque(boolean toque) 
    {
        this.toque = toque;
    }

    public void setUso(boolean uso) 
    {
        this.uso = uso;
    }

    public void setNumeroDeCasilla(int numeroDeCasilla) 
    {
        this.numeroDeCasilla = numeroDeCasilla;
    }

    public void setTipoDeUso(String TipoDeUso) {
        this.TipoDeUso = TipoDeUso;
    }

    public void setJDT(JefeDeTerreno JDT) 
    {
        this.JDT = JDT;
    }

    public void setMonstruo(Criatura monstruo) 
    {
        this.monstruo = monstruo;
    }

}
