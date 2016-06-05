package Controlador;

import Vista.VistaLogin;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;
import Modelo.Jugador;
import Vista.VistaDuelo;
import Vista.VistaEdicionDeDados;
import Vista.VistaPreparacionDuelo;
import Vista.VistaPreparacionTorneo;

public class ControladorJugador 
{
    // ATRIBUTOS
    
    private VistaLogin VL;
    private VistaRegistro VR;
    private VistaPrincipal VP;
    private VistaPreparacionTorneo VPT;
    private VistaEdicionDeDados VED;
    private VistaDuelo VD;
    private VistaPreparacionDuelo VPD;
    private Jugador J;
    private String jugadorSesion= "";
    private String contraseñaSesion= "";
    
    //CONSTRUCTORES
    

    public ControladorJugador() 
    {
        VP= new VistaPrincipal();
        VL= new VistaLogin(VP,true);
        VR= new VistaRegistro(VP,true);
        VPT= new VistaPreparacionTorneo(VP,true);
        VED= new VistaEdicionDeDados(VP,true);
        VD= new VistaDuelo(VP,true);
        VPD= new VistaPreparacionDuelo(VP,true);
        J= new Jugador("","");
    }
    
    //PARA LLAMAR A LAS VISTAS
    
    public void llamarVistaLogin(ControladorJugador cj2)
    {
        VL.setLocationRelativeTo(null);
        VL.setCJ2(cj2);
        VL.liberarCampos();
        VL.setVisible(true);
    }
    
    public void llamarVistaRegistro(ControladorJugador cj2)
    {
        VR.setLocationRelativeTo(null);
        VR.setCJ2(cj2);
        VR.setVisible(true);
    }
    
    public void llamarVistaPrincipal(ControladorJugador cj2)
    {
        VP.setLocationRelativeTo(null);
        VP.setCJ2(cj2);
        VP.setUsuarioActivo(cj2.usuarioActivo());
        VP.setVisible(true);
    }
    
    public void llamarVistaPreparacionTorneo(ControladorJugador cj2)
    {
        VPT.setLocationRelativeTo(null);
        VPT.setCJ2(cj2);
        VPT.setVisible(true);
    }
    
    public void llamarVistaEdicionDeDados(ControladorJugador cj2)
    {
        VED.setLocationRelativeTo(null);
        VED.setCJ2(cj2);
        VED.setVisible(true);
    }
    
    public void llamarVistaDuelo(ControladorJugador cj2)
    {
        VD.setLocationRelativeTo(null);
        VD.setCJ2(cj2);
        VD.setVisible(true);
    }
    
    public void llamarVistaPreparacionDuelo(ControladorJugador cj2)
    {
        VPD.setLocationRelativeTo(null);
        VPD.setCJ2(cj2);
        VPD.setVisible(true);
    }
    //CERRAR VISTAS
    
    public void cerrarVistaLogin(VistaLogin vl)
    {
        vl.dispose();
    }
    
    public void cerrarVistaRegistro(VistaRegistro vr)
    {
        vr.dispose();
    }
    public void cerrarVistaPrincipal(VistaPrincipal vp)
    {
        vp.dispose();
    }
    
    public void cerrarVistaPreparacionTorneo(VistaPreparacionTorneo vpt)
    {
        vpt.dispose();
    }
    
    public void cerrarVistaEdicionDeDados(VistaEdicionDeDados ved)
    {
        ved.dispose();
    }
    
    public void cerrarVistaDuelo(VistaDuelo vd)
    {
        vd.dispose();
    }
    
    public void cerrarVistaPreparacionDuelo(VistaPreparacionDuelo vpd)
    {
        vpd.dispose();
    }
    //PARA REGISTRAR Y COMPROBAR LA EXISTENCIA DE UN USUARIO
    public boolean Registro(String Jugador, String pass)
    {
        boolean confirmacion=J.CrearRegistro(Jugador, pass);
        return confirmacion;
    }

    public boolean ValidarRegistro(String Jugador, String pass)
    {
        return J.ConfirmarRegistro(Jugador, pass);
    }
    
    
    // REMOVER ELEMENTOS DE LAS VISTAS
    
    public void removerDatosVistaRegistro(VistaRegistro vr)
    {
        vr.removerDatos();
    }
    //para la obtencion de usuario activo
    public String usuarioActivo()
    {
        return J.getNombre();
    }
}
