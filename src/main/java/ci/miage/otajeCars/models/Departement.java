// Departement.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class Departement {
    private IntegerProperty idDepartement;
    private StringProperty nomDepartement;
    private StringProperty codeDepartement;

    public Departement() {
        this.idDepartement = new SimpleIntegerProperty();
        this.nomDepartement = new SimpleStringProperty();
        this.codeDepartement = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdDepartement() { return idDepartement.get(); }
    public void setIdDepartement(int value) { idDepartement.set(value); }
    public IntegerProperty idDepartementProperty() { return idDepartement; }

    public String getNomDepartement() { return nomDepartement.get(); }
    public void setNomDepartement(String value) { nomDepartement.set(value); }
    public StringProperty nomDepartementProperty() { return nomDepartement; }

    public String getCodeDepartement() { return codeDepartement.get(); }
    public void setCodeDepartement(String value) { codeDepartement.set(value); }
    public StringProperty codeDepartementProperty() { return codeDepartement; }

    @Override
    public String toString() {
        return getNomDepartement();
    }
}