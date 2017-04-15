/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopnotes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;

/**
 *
 * @author JuanVaio
 */
public class Note {
    public SimpleStringProperty texto, resumen;
    
    Note(){
        texto = new SimpleStringProperty("");
        resumen = new SimpleStringProperty("Nueva nota");
        
        texto.addListener((ObservableValue<? extends String> ov,String oldValue,String newValue)->{
            this.resumen.set(texto.get().substring(0, Math.min(texto.get().length(), 20)));
            System.out.println(this.resumen.get());
        });
    }
    
    public String getTexto(){
        return texto.get();
    }
    
    public String getResumen(){
        return resumen.get();
    }
    
    public void change(String text){
        texto.set(text);
    }
    
    
}
