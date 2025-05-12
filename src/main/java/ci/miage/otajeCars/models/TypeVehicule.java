// TypeVehicule.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class TypeVehicule {
    private IntegerProperty idType;
    private StringProperty libelleType;
    private IntegerProperty nombrePlaces;

    public TypeVehicule() {
        this.idType = new SimpleIntegerProperty();
        this.libelleType = new SimpleStringProperty();
        this.nombrePlaces = new SimpleIntegerProperty();
    }

    // Getters and Setters
    public int getIdType() { return idType.get(); }
    public void setIdType(int value) { idType.set(value); }
    public IntegerProperty idTypeProperty() { return idType; }

    public String getLibelleType() { return libelleType.get(); }
    public void setLibelleType(String value) { libelleType.set(value); }
    public StringProperty libelleTypeProperty() { return libelleType; }

    public int getNombrePlaces() { return nombrePlaces.get(); }
    public void setNombrePlaces(int value) { nombrePlaces.set(value); }
    public IntegerProperty nombrePlacesProperty() { return nombrePlaces; }

    @Override
    public String toString() {
        return getLibelleType();
    }
}