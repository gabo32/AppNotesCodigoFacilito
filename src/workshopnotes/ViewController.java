/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopnotes;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author JuanVaio
 */
public class ViewController implements Initializable {
    @FXML private Button botonEliminar,botonAgregar;
    @FXML private TextArea contenidoPrincipal;
    @FXML private ListView listaNotas;
    
    private List<Note> notas;
    private List<String> resumenes;
    private ListProperty<String> propiedadesResumenNotas;
    
    private Note notaActual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notaActual = new Note();
        resumenes = new ArrayList<>();
        notas = new ArrayList<>();
        propiedadesResumenNotas = new SimpleListProperty<>(FXCollections.observableArrayList(resumenes));
        listaNotas.itemsProperty().bind(propiedadesResumenNotas);
        nuevaNota();
        
        contenidoPrincipal.textProperty().addListener((ObservableValue<? extends String> ov,String oldValue,String newValue)->{
            notaActual.change(newValue);
        });
    }    
    
    
    public void nuevaNota(){
        notaActual = new Note();
        notas.add(notaActual);
        propiedadesResumenNotas.add(notaActual.getResumen());
    }
}
