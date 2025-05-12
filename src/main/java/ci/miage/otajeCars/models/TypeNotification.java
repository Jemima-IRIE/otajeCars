// TypeNotification.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class TypeNotification {
    private IntegerProperty idTypeNotification;
    private StringProperty libelle;
    private StringProperty icone;
    private StringProperty couleur;

    public TypeNotification() {
        this.idTypeNotification = new SimpleIntegerProperty();
        this.libelle = new SimpleStringProperty();
        this.icone = new SimpleStringProperty();
        this.couleur = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdTypeNotification() { return idTypeNotification.get(); }
    public void setIdTypeNotification(int value) { idTypeNotification.set(value); }
    public IntegerProperty idTypeNotificationProperty() { return idTypeNotification; }

    public String getLibelle() { return libelle.get(); }
    public void setLibelle(String value) { libelle.set(value); }
    public StringProperty libelleProperty() { return libelle; }

    public String getIcone() { return icone.get(); }
    public void setIcone(String value) { icone.set(value); }
    public StringProperty iconeProperty() { return icone; }

    public String getCouleur() { return couleur.get(); }
    public void setCouleur(String value) { couleur.set(value); }
    public StringProperty couleurProperty() { return couleur; }

    @Override
    public String toString() {
        return getLibelle();
    }
}