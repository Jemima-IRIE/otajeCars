// StatutVehicule.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class StatutVehicule {
    private IntegerProperty idStatut;
    private StringProperty libelleStatut;
    private StringProperty couleurStatut;

    public StatutVehicule() {
        this.idStatut = new SimpleIntegerProperty();
        this.libelleStatut = new SimpleStringProperty();
        this.couleurStatut = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdStatut() { return idStatut.get(); }
    public void setIdStatut(int value) { idStatut.set(value); }
    public IntegerProperty idStatutProperty() { return idStatut; }

    public String getLibelleStatut() { return libelleStatut.get(); }
    public void setLibelleStatut(String value) { libelleStatut.set(value); }
    public StringProperty libelleStatutProperty() { return libelleStatut; }

    public String getCouleurStatut() { return couleurStatut.get(); }
    public void setCouleurStatut(String value) { couleurStatut.set(value); }
    public StringProperty couleurStatutProperty() { return couleurStatut; }

    @Override
    public String toString() {
        return getLibelleStatut();
    }
}