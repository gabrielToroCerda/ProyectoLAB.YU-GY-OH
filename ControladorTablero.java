//Paquete
package Controlador;

//Importaciones necesarias
import Modelo.Posicion;
import Modelo.Tablero;
import java.awt.Color;
import javax.swing.ImageIcon;


public class ControladorTablero 
{
    //Atributos
    private Tablero campoDeBatalla;//clase que se encarga de darle la informacion necesaria al controlador
    private Posicion[][] MatrizREDUCCION;
    //constructor del Controlador del tablero, se encarga de instanciar los atributos,
    // NO BORRAR YA QUE CORRESPONDE A LA FORMA CORRECTA DE INSTANCIAR LOS ATRIBUTOS SEGUN EL PARADIGMA ORIENTADO A OBJETOS
    public ControladorTablero()
    {
        campoDeBatalla= new Tablero();
    }
    
    
    //GETS

    //Se encargan de devolver los atributos de la clase
    public Tablero getCampoDeBatalla() 
    {
        return campoDeBatalla;
    }
    public int getNumeroDeCasillaSegunFilaYcolumna(int FILA, int COLUMNA)
    {
        return campoDeBatalla.getNumeroDeCasillaSegunFilaYColumna(FILA, COLUMNA);
    }
    
    
    public int [] getFilaYColumna(int NUMERODECASILLA)
    {
        int[] ubicacion=new int[2];
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                if(campoDeBatalla.getPosicion(i,j).getNumeroDeCasilla()==NUMERODECASILLA)
                {
                    ubicacion[0]=i;
                    ubicacion[1]=j;
                }
            }
        }
        return ubicacion;
        
    }
    //Métodos
    //Este método se encarga de devolver el atributo toque, en donde si es true, significa que se ha realizado el toque de algún botón
    //caso contrario, que no se ha tocado algún botón
    public boolean confirmacionToque()
    {
        return campoDeBatalla.getToqueDeBoton();
    }
    
    //Se encarga de restaurar el toque a un valor false, esto para que cuando se termine de hacer alguna accion
    // se pueda corroborar que el usuario ya realizó la accion esperada
    public void restaurarToque()
    {
        campoDeBatalla.setToqueDeBoton(false);
    }
    
    //Funcion que comprueba si se puede realizar el despliege 
    public boolean comprobacionDespliegue(int FILA, int COLUMNA, int FORMA, int ORIENTACION, Posicion[][] MatrizTABLERO)
    {
        boolean confirmacion=false;
        //valores que se encargan de analizar casilla por casilla
        boolean A;
        boolean B;
        boolean C;
        boolean D;
        boolean E;
        boolean F;
        
        //valores que se encargan de analizar las restricciones por cada pieza a implementar
        boolean G;
        boolean H;
        boolean I;
        boolean J;
        boolean K;
        
        switch(FORMA)
        {
            case 1:
                switch(ORIENTACION)
                {
                    case 1://Arriba
                        
                        /* obs: misma estructura se repite para todas las orientaciones
                         la estructura que se sigue es la siguente:
                        
                        1.- comprobar si la casilla seleccionada por el usuario es o nó una casilla crítica
                        (casilla en la cual se encuentra cerca, en los bordes o esquinas del tablero)
                        
                        2.- comprobar si las casillas de los alrredores de la casilla seleccionada por el usuario 
                        están disponibles para su implementacion
                        
                        3.- por defecto, la confirmacion es False, si las casillas a su alrrededor están libres y no es una casilla crítica
                        entonces confirmación pasará  a ser true.

                        comprobacion de restricciones primero
                        */
                        G=COLUMNA!=0;
                        H=COLUMNA!=14;
                        I=FILA!=0;
                        J=FILA!=1;
                        K=FILA!=14;
                        
                        /*este if solo se accede si y solo sí no se halla en el caso de las restricciones impuestas por la forma de la figura y la ubicación
                        en la que se desea desplegar el dado*/
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA][FILA-2].getUso()==false;
                            D=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            
                            //solo se accede si las casillas alrrededor de la casilla impuesta por el usuario
                            //están disponibles para el uso
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    case 2://Izquierda
                        G=COLUMNA!=0;
                        H=COLUMNA!=1;
                        I=COLUMNA!=14;
                        J=FILA!=0;
                        K=FILA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA-2][FILA].getUso()==false;
                            E=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        
                        break;
                    case 3://abajo
                        
                        //comprobacion de restricciones primero
                        G=COLUMNA!=0;
                        H=COLUMNA!=14;
                        I=FILA!=0;
                        J=FILA!=13;
                        K=FILA!=14;
                        
                        //este a este if solo se accede si la casilla seleccionada por el usuario no es
                        //alguna zona crítica
                        if(G && H && I && J && K)
                        {
                            //comprobacion de las casillas de los alrrededres de la casilla seleccionada
                            // por el usuario por medio de Busqueda de Espacios y Estados
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA][FILA+2].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            
                            if(A && B && C && D && E && F && G && H && I && J && K)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    
                    default://derecha
                        
                        G=COLUMNA!=0;
                        H=COLUMNA!=13;
                        I=COLUMNA!=14;
                        J=FILA!=0;
                        K=FILA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA+2][FILA].getUso()==false;
                            E=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                }
                break;
            case 2:
                
                switch(ORIENTACION)
                {
                    case 1:
                        G= FILA!=0;
                        H= FILA!=1;
                        I= FILA!=13;
                        J= FILA!=14;
                        K= COLUMNA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA][FILA-2].getUso()==false;
                            D=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA+2].getUso()==false;
                            
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    case 2:
                        G= COLUMNA!=0;
                        H= COLUMNA!=1;
                        I= COLUMNA!=13;
                        J= COLUMNA!=14;
                        K= FILA!=0;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-2][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+2][FILA-1].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                }
                break;
            case 3:
                switch(ORIENTACION)
                {
                    case 1:
                        G= FILA!=0;
                        H= FILA!=13;
                        I= FILA!=14;
                        J= COLUMNA!=0;
                        K= COLUMNA!=14;
                        
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                            D=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA-1][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA-1][FILA+2].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    case 2:
                        G= COLUMNA!=0;
                        H= COLUMNA!=13;
                        I= COLUMNA!=14;
                        J= FILA!=0;
                        K= FILA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-1][FILA-1].getUso()==false;
                            D=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+2][FILA+1].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                }
                break;
            case 4:
                switch(ORIENTACION)
                {
                    case 1:
                        G=FILA!=0;
                        H=FILA!=1;
                        I=FILA!=14;
                        J=COLUMNA!=0;
                        K=COLUMNA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA][FILA-2].getUso()==false;
                            D=MatrizTABLERO[COLUMNA-1][FILA-2].getUso()==false;
                            E=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA+1].getUso()==false;

                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }    
                        }
                        break;
                    case 2:
                        G=COLUMNA!=0;
                        H=COLUMNA!=1;
                        I=COLUMNA!=14;
                        J=FILA!=0;
                        K=FILA!=14;
                        if(G && H && I && J && K)
                        {
                            
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-2][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA-2][FILA+1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                            
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }    
                        }
                        break;
                }
                break;
                
            case 5:
                switch(ORIENTACION)
                {
                    case 1:
                        G= FILA!=0;
                        H= FILA!=1;
                        I= FILA!=14;
                        J= COLUMNA!=0;
                        K= COLUMNA!=14;

                        if(G && H && I && J && K)
                        {
                           A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                           B=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                           C=MatrizTABLERO[COLUMNA+1][FILA+1].getUso()==false;
                           D=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                           E=MatrizTABLERO[COLUMNA][FILA-2].getUso()==false;
                           F=MatrizTABLERO[COLUMNA-1][FILA-1].getUso()==false;

                           if(A && B && C && D && E && F)
                           {
                               confirmacion=true;
                           }
                        }
                        break;
                    case 2:
                        G= COLUMNA!=0;
                        H= COLUMNA!=1;
                        I= COLUMNA!=14;
                        J= FILA!=0;
                        K= FILA!=14;
                        if(G && H && I && J && K)
                        {
                           A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                           B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                           C=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                           D=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                           E=MatrizTABLERO[COLUMNA-2][FILA].getUso()==false;
                           F=MatrizTABLERO[COLUMNA-1][FILA+1].getUso()==false;

                           if(A && B && C && D && E && F)
                           {
                               confirmacion=true;
                           }
                        }
                        break;
                }
                break;
            case 6:
                switch(ORIENTACION)
                {
                    case 1:
                        G= FILA!=0;
                        H= FILA!=13;
                        I= FILA!=14;
                        J= COLUMNA!=0;
                        K= COLUMNA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                            D=MatrizTABLERO[COLUMNA-1][FILA-1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA][FILA+2].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    case 2:
                        G= FILA!=0;
                        H= FILA!=14;
                        I= COLUMNA!=0;
                        J= COLUMNA!=13;
                        K= COLUMNA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-1][FILA-1].getUso()==false;
                            D=MatrizTABLERO[COLUMNA-1][FILA+1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+2][FILA].getUso()==false;
                            
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    case 3:
                        G= FILA!=0;
                        H= FILA!=1;
                        I= FILA!=14;
                        J= COLUMNA!=0;
                        K= COLUMNA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA][FILA-2].getUso()==false;
                            D=MatrizTABLERO[COLUMNA][FILA+1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA-1][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA+1].getUso()==false;
                            
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    default:
                        G= FILA!=0;
                        H= FILA!=14;
                        I= COLUMNA!=0;
                        J= COLUMNA!=1;
                        K= COLUMNA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-2][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA+1][FILA].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+1][FILA+1].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                }
                break;
            case 7:
                switch(ORIENTACION)
                {
                    case 1:
                        G= FILA!=0;
                        H= FILA!=1;
                        I= FILA!=13;
                        J= FILA!=14;
                        K= COLUMNA!=0;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            C=MatrizTABLERO[COLUMNA][FILA-2].getUso()==false;
                            D=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            E=MatrizTABLERO[COLUMNA-1][FILA+1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA-1][FILA+2].getUso()==false;
                           
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                    case 2:
                        G= COLUMNA!=0;
                        H= COLUMNA!=1;
                        I= COLUMNA!=13;
                        J= COLUMNA!=14;
                        K= FILA!=14;
                        if(G && H && I && J && K)
                        {
                            A=MatrizTABLERO[COLUMNA][FILA].getUso()==false;
                            B=MatrizTABLERO[COLUMNA-1][FILA].getUso()==false;
                            C=MatrizTABLERO[COLUMNA-2][FILA].getUso()==false;
                            D=MatrizTABLERO[COLUMNA][FILA-1].getUso()==false;
                            E=MatrizTABLERO[COLUMNA+1][FILA-1].getUso()==false;
                            F=MatrizTABLERO[COLUMNA+2][FILA-1].getUso()==false;
                            if(A && B && C && D && E && F)
                            {
                                confirmacion=true;
                            }
                        }
                        break;
                }
                break;
            case 8:
                confirmacion=true;
                break;
            case 9:
                confirmacion=true;
                break;
            default:
                confirmacion=true;
                break;
        }
        return confirmacion;
    }
    
    //Funcion que actualiza los usos de las casillas
    public Posicion[][] actualizarUsos(Posicion[][]MatrizTABLERO, Posicion[][]MatrizACTUALIZADORA)
    {
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                if(MatrizTABLERO[i][j].getUso()!=MatrizACTUALIZADORA[i][j].getUso())
                {
                    MatrizTABLERO[i][j].setUso(MatrizACTUALIZADORA[i][j].getUso());
                }
                MatrizTABLERO[i][j].setTipoDeUso(MatrizTABLERO[i][j].getTipoDeUso());
            }
        }
        MatrizTABLERO[0][7].setUso(true);
        MatrizTABLERO[7][0].setUso(true);
        MatrizTABLERO[14][7].setUso(true);
        MatrizTABLERO[7][14].setUso(true);
        return MatrizTABLERO;
    }
    
    //Funcion que agrega los terrenos
    public Posicion[][] agregarTerrenos(int FILA, int COLUMNA, int FORMA, int ORIENTACION, Posicion[][]MatrizTABLERO)
    {
        switch(FORMA)
        {
            case 1:
                switch(ORIENTACION)
                {
                    case 1://arriba
                        /*
                        Estado Inicial= F,C
                        
                               [F-2,C]
                               [F-1,C]
                        [F,C-1][F  ,C][F,C+1]
                               [F+1,C]
                        */
                        
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setIcon(new ImageIcon(getClass().getResource("/Imagenes/criaturaPrueba.jpg")));
                        MatrizTABLERO[COLUMNA][FILA].setTipoDeUso("criatura");
                        break;
                        
                    case 2://izquierda
                        /*
                                [   ]
                        [  ][  ][E.I][  ]
                                [   ]
                        */
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setIcon(new ImageIcon(getClass().getResource("/Imagenes/criaturaPrueba.jpg")));
                        MatrizTABLERO[COLUMNA][FILA].setTipoDeUso("criatura");
                        
                        break;
                    case 3://abajo
                        /*
                               [   ]
                          [   ][E.I][   ]
                               [   ]
                               [   ]
                         */
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setIcon(new ImageIcon(getClass().getResource("/Imagenes/criaturaPrueba.jpg")));
                        MatrizTABLERO[COLUMNA][FILA].setTipoDeUso("criatura");
                        
                        break;
                    default://derecha
                        /*
                            [   ]
                        [  ][E.I][  ][  ]
                            [   ]
                        */
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        break;
                }
                break;
                
            case 2://segundo tipo de despligue
                switch(ORIENTACION)
                {
                    case 1://arriba
                        
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+2].setUso(true);
                      break;
                      
                    case 2://izq
                        /* 
                        formaAObtener[0]=this.TABLERO[FILA][COLUMNA];
                        formaAObtener[1]=this.TABLERO[FILA-1][COLUMNA];
                        formaAObtener[2]=this.TABLERO[FILA-2][COLUMNA];
                        formaAObtener[3]=this.TABLERO[FILA][COLUMNA-1];
                        formaAObtener[4]=this.TABLERO[FILA+1][COLUMNA-1];
                        formaAObtener[5]=this.TABLERO[FILA+2][COLUMNA-1];*/
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA-1].setUso(true);
                        break;
                        
                    case 3://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);      
                        break;
                        
                    default://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true); 
                        break;
                }
                break;
                
            case 3://tercer
                 
                //despliegue 3 del enunciado
                switch(ORIENTACION)
                {
                    case 1://arr                       
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+2].setUso(true); 
                    
                        break;
                    case 2://izq
                       
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA+1].setUso(true); 
                        break;
                        
                    case 3://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-2].setUso(true);      
                        break;
                        
                    default://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA-1].setUso(true); 
                        break;                     
                }
                break;
                
            case 4:
                 //despliegue 4 del enunciado
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true); 
                        break;
                      
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true); 
                        break;
                        
                    case 3://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+2].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);      
                        break;
                        
                    default://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA-1].setUso(true); 
                        break;                     
                }
                break;
                
            case 5:
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);

                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        break;
                        
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        break;
                        
                    case 3://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        break;
                        
                    default://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        break;
                }
                break;
                
            case 6:
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);

                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);
                        break;
                        
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        break;
                        
                    case 3://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);      
                        break;
                        
                    default://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        break;
                }
                break;
                
            case 7:
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+2].getBoton().setBackground(Color.yellow);

                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+2].setUso(true);
                        break;
                        
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA+1].setUso(true);
                        break;
                        
                    case 3://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-2].setUso(true);      
                        break;
                        
                    default://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        break;
                }
                break;
                
            case 8:
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-2].getBoton().setBackground(Color.yellow);

                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-2].setUso(true);
                        break;
                        
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA+1].setUso(true);
                        break;
                        
                    case 3://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+2].setUso(true);      
                        break;
                        
                    default://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA-1].setUso(true);
                        break;
                }
                break;
                
            case 9:
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-2].getBoton().setBackground(Color.yellow);

                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-2].setUso(true);
                        break;
                        
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA-1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA-1].setUso(true);
                        break;
                        
                    case 3://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+2].setUso(true);      
                        break;
                        
                    default://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA+1].setUso(true);
                        break;
                }
                break;
                
            default:
                switch(ORIENTACION)
                {
                    case 1://arr
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-2].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);

                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-2].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        break;
                        
                    case 2://izq
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        break;
                        
                    case 3://der
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA+1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA+2].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA+1].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA+2].setUso(true);      
                        break;
                        
                    default://ab
                        MatrizTABLERO[COLUMNA][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA-1][FILA-1].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+2][FILA].getBoton().setBackground(Color.yellow);
                        MatrizTABLERO[COLUMNA+1][FILA+1].getBoton().setBackground(Color.yellow);
                        
                        MatrizTABLERO[COLUMNA][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA-1][FILA-1].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+2][FILA].setUso(true);
                        MatrizTABLERO[COLUMNA+1][FILA+1].setUso(true);
                        break;
                }
                break;
        }
        return MatrizTABLERO;
    }
    
    public int gastoMoverCriatura(int CASILLAINICIAL, int CASILLAFINAL)
    {
        int gasto=0;
        int filaInicial=0;
        int columnaInicial=0;
        int filaFinal=0;
        int columnaFinal=0;
        
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                if(campoDeBatalla.getPosicion(i,j).getNumeroDeCasilla()==CASILLAINICIAL)
                {
                    filaInicial=campoDeBatalla.getPosicion(i,j).getFila();
                    columnaInicial=campoDeBatalla.getPosicion(i,j).getColumna();
                }
                if(campoDeBatalla.getPosicion(i,j).getNumeroDeCasilla()==CASILLAFINAL)
                {
                    filaFinal=campoDeBatalla.getPosicion(i,j).getFila();
                    columnaFinal=campoDeBatalla.getPosicion(i,j).getColumna();
                }
            }
        }
        
        if(filaInicial==filaFinal)
        {
            gasto=Math.abs(columnaFinal-columnaInicial);
        }
        
        else
        {
            if(columnaInicial==columnaFinal)
            {
                gasto=Math.abs(filaFinal-filaInicial);
            }
            else
            {
            }
        }
        return gasto;
    }
    
    public Posicion[][] realizarMovimiento(Posicion[][]MatrizTABLERO, int CASILLAFINAL, int CASILLAINICIAL)
    {
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                boolean A=MatrizTABLERO[i][j].getNumeroDeCasilla()==CASILLAINICIAL;
                if(MatrizTABLERO[i][j].getNumeroDeCasilla()==CASILLAINICIAL)
                {
                    MatrizTABLERO[i][j].getBoton().setIcon(null);
                    MatrizTABLERO[i][j].setTipoDeUso("");
                }
                boolean B=MatrizTABLERO[i][j].getNumeroDeCasilla()==CASILLAFINAL;
                if(MatrizTABLERO[i][j].getNumeroDeCasilla()==CASILLAFINAL)
                {
                    MatrizTABLERO[i][j].getBoton().setIcon(new ImageIcon(getClass().getResource("/imagenes/criaturaPrueba.jpg")));
                    MatrizTABLERO[i][j].setTipoDeUso("criatura");
                }
            }
        }
        return MatrizTABLERO;
   }
    
   public int[] crearCamino(int ESTADOINICIAL, int ESTADOFINAL, Tablero TABLERO)
   {
       int k=0;
       int i=0;
       int j=0;
       int estIni=ESTADOINICIAL;
       int estFin=ESTADOFINAL;
       int[]estadosAbiertos=new int[225];
       int[]estadosCerrados=new int[225];
       
       while(estIni!=estFin)
       {
          int[] filaYColumnaEI= TABLERO.getFilaYColumna(ESTADOINICIAL);
          int[] filaYColumnaEF= TABLERO.getFilaYColumna(ESTADOFINAL);
          
          boolean A= TABLERO.getPosicion(filaYColumnaEI[0]-1, filaYColumnaEI[1]).getUso()!=false;
          boolean B= TABLERO.getPosicion(filaYColumnaEI[0], filaYColumnaEI[1]-1).getUso()!=false;
          boolean C= TABLERO.getPosicion(filaYColumnaEI[0]+1, filaYColumnaEI[1]).getUso()!=false;
          boolean D= TABLERO.getPosicion(filaYColumnaEI[0], filaYColumnaEI[1]+1).getUso()!=false;
          if(A)
          {
              estadosAbiertos[k]=TABLERO.getPosicion(filaYColumnaEI[0]-1, filaYColumnaEI[1]).getNumeroDeCasilla();
              k++;
          }
          if(B)
          {
              estadosAbiertos[k]=TABLERO.getPosicion(filaYColumnaEI[0], filaYColumnaEI[1]-1).getNumeroDeCasilla();
              k++;
          }
          if(C)
          {
              estadosAbiertos[k]=TABLERO.getPosicion(filaYColumnaEI[0]+1, filaYColumnaEI[1]).getNumeroDeCasilla();
              k++;
          }
          if(D)
          {
              estadosAbiertos[k]=TABLERO.getPosicion(filaYColumnaEI[0], filaYColumnaEI[1]+1).getNumeroDeCasilla();
              k++;
          }
          
          estadosCerrados[j]=estIni;
          j++;
          estIni=estadosAbiertos[i];
          i++;
       }
       return estadosCerrados;
   }
}