// TypePlainte.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class TypePlainte {
    private IntegerProperty idTypePlainte;
    private StringProperty libelle;
    private StringProperty description;

    public TypePlainte() {
        this.idTypePlainte = new SimpleIntegerProperty();
        this.libelle = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdTypePlainte() { return idTypePlainte.get(); }
    public void setIdTypePlainte(int value) { idTypePlainte.set(value); }
    public IntegerProperty idTypePlainteProperty() { return idTypePlainte; }

    public String getLibelle() { return libelle.get(); }
    public void setLibelle(String value) { libelle.set(value); }
    public StringProperty libelleProperty() { return libelle; }

    public String getDescription() { return description.get(); }
    public void setDescription(String value) { description.set(value); }
    public StringProperty descriptionProperty() { return description; }

    @Override
    public String toString() {
        return getLibelle();
    }
}
