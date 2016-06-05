package Modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tablero implements ActionListener
{
    //ATRIBUTOS
    private Posicion[][] MatrizTABLERO= new Posicion[15][15];//define el tablero
    private Posicion[][] MatrizACTUALIZADORA= new Posicion[15][15];//define la matriz que actualiza al tablero
    private Posicion[][] MatrizEdicionCRIATURA=new Posicion[3][5];
    private int filaBotonTocado;//indica la fila del botón tocado
    private int columnaBotonTocado;//indica la columna del botón tocado
    private boolean ToqueDeBoton;//indica si el botón fue tocado o no 

    public Tablero() 
    {
        /*
        Recorre el arreglo MatrizTablero lugar por lugar y por cada lugar, crea una nueva posicion
        a esa nueva posicion, obiene el botón asociado, le da ubicacion y dimension y luego le agrega un 
        ActionListener
        */
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                MatrizTABLERO[i][j]= new Posicion(i,j,((i+1) + 15*j));//instncia una coordenada del tablero como una posicion específica
                MatrizTABLERO[i][j].getBoton().setBounds(i*52,j*40,52,40);//al objeto posicion le otorga una ubicacion y dimension dentro del JPanel
                MatrizTABLERO[i][j].getBoton().setBackground(Color.GRAY);
                MatrizTABLERO[i][j].getBoton().addActionListener(this);//al objeto posicion, le llama su atributo JButton y a este objeto de tipo JButton le otorga un ActionListener
                
            }
        }
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<5; j++)
            {
                MatrizEdicionCRIATURA[i][j]= new Posicion(i,j,(i+1)+3*j);
                MatrizEdicionCRIATURA[i][j].getBoton().setBounds(i*115,j*80,115,80);//al objeto posicion le otorga una ubicacion y dimension dentro del JPanel
                MatrizEdicionCRIATURA[i][j].getBoton().setBackground(Color.BLUE);
                MatrizEdicionCRIATURA[i][j].getBoton().addActionListener(this);//al objeto posicion, le llama su atributo JButton y a este objeto de tipo JButton le otorga un ActionListener
            }
        }
        

     
    
        /*
        JEFES DE TERRENO
        
        Las posiciones de los jefes de terreno las marca de color rojo y les otorga uso (se le aigna un valor 
        true para identificar la casilla del jefe de terreno en uso)
        
        setRolloverIcon hace que la imagen solo se muestre cuando se pasa el mouse por encima del botón
        */
        
        ImageIcon jefeDeTerrenoImagen= new ImageIcon(getClass().getResource("/imagenes/jefeDeTerrenoEditado.jpg"));
        MatrizTABLERO[0][7].getBoton().setIcon(jefeDeTerrenoImagen);
        MatrizTABLERO[7][0].getBoton().setIcon(jefeDeTerrenoImagen);
        MatrizTABLERO[14][7].getBoton().setIcon(jefeDeTerrenoImagen);
        MatrizTABLERO[7][14].getBoton().setIcon(jefeDeTerrenoImagen);
        MatrizTABLERO[0][7].getBoton().setBackground(Color.red);
        MatrizTABLERO[7][0].getBoton().setBackground(Color.red);
        MatrizTABLERO[14][7].getBoton().setBackground(Color.red);
        MatrizTABLERO[7][14].getBoton().setBackground(Color.red);
        MatrizTABLERO[0][7].setTipoDeUso("jefeDeTerreno");
        MatrizTABLERO[7][0].setTipoDeUso("jefeDeTerreno");
        MatrizTABLERO[14][7].setTipoDeUso("jefeDeTerreno");
        MatrizTABLERO[7][14].setTipoDeUso("jefeDeTerreno");
        MatrizTABLERO[0][7].setUso(true);
        MatrizTABLERO[7][0].setUso(true);
        MatrizTABLERO[14][7].setUso(true);
        MatrizTABLERO[7][14].setUso(true);
        
        //como todavía no se toca algún botón, el constructor por defecto le asignará false para indicar que los botones no se han tocado
        ToqueDeBoton=false;
    }
   public int getNumeroDeCasillaSegunFilaYColumna(int FILA, int COLUMNA)
    {
        return MatrizTABLERO[FILA][COLUMNA].getNumeroDeCasilla();
    }
    public int[] getFilaYColumna(int NUMERODECASILLA)
    {
        int[] filaYColumna=new int[2];
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                if(this.MatrizTABLERO[i][j].getNumeroDeCasilla()==NUMERODECASILLA)
                {
                    filaYColumna[0]=i;
                    filaYColumna[1]=j;
                }
            }
        }
        return filaYColumna;
    }
    

    public Posicion[][] getMatrizEdicionCRIATURA() 
    {
        return MatrizEdicionCRIATURA;
    }
    
    public boolean getToqueDeBoton()
    {
        return this.ToqueDeBoton;
    }
    
    public JButton getBotonEdicion(int FILA, int COLUMNA)
    {
        return MatrizEdicionCRIATURA[FILA][COLUMNA].getBoton();
    }
    
    public JButton getBotonTablero(int FILA, int COLUMNA)
    {
        return MatrizTABLERO[FILA][COLUMNA].getBoton();
    }
    
    public Posicion[][] getMatrizTABLERO() 
    {
        return MatrizTABLERO;
    }
    
    public Posicion[][] getMatrizACTUALIZADORA() 
    {
        return MatrizACTUALIZADORA;
    }
    
    public int getFilaBotonTocado() 
    {
        return filaBotonTocado;
    }

    public int getColumnaBotonTocado() 
    {
        return columnaBotonTocado;
    }
    
    public Posicion getPosicion(int FILA, int COLUMNA)
    {
        return MatrizTABLERO[FILA][COLUMNA];
    }
    
    public void setMatrizTABLERO(Posicion[][] MatrizTABLERO) 
    {
        this.MatrizTABLERO = MatrizTABLERO;
    }

    public void setMatrizACTUALIZADORA(Posicion[][] MatrizACTUALIZADORA) 
    {
        this.MatrizACTUALIZADORA = MatrizACTUALIZADORA;
    }
    
    public void setToqueDeBoton(boolean ToqueDeBoton) 
    {
        this.ToqueDeBoton = ToqueDeBoton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                if(ae.getSource()==MatrizTABLERO[i][j].getBoton())
                {
                    System.out.println("Soy el botón "+MatrizTABLERO[i][j].getNumeroDeCasilla()+" ubicado en la fila: "+j+" y columna: "+i);
                    this.filaBotonTocado=MatrizTABLERO[i][j].getColumna();
                    this.columnaBotonTocado=MatrizTABLERO[i][j].getFila();
                    MatrizTABLERO[i][j].setToque(true);
                    this.ToqueDeBoton=true;
                }
            }
        }
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<5; j++)
            {
                if(ae.getSource()==MatrizEdicionCRIATURA[i][j].getBoton())
                {
                    System.out.println("Soy el botón "+MatrizEdicionCRIATURA[i][j].getNumeroDeCasilla()+" ubicado en la fila: "+j+" y columna: "+i);
                    this.filaBotonTocado=MatrizEdicionCRIATURA[i][j].getColumna();
                    this.columnaBotonTocado=MatrizEdicionCRIATURA[i][j].getFila();
                    MatrizEdicionCRIATURA[i][j].setToque(true);
                    this.ToqueDeBoton=true;
                }
            }
        }
    }
}
