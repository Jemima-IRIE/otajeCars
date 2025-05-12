// Role.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class Role {
    private IntegerProperty idRole;
    private StringProperty nomRole;
    private StringProperty description;
    private IntegerProperty niveauAcces;

    public Role() {
        this.idRole = new SimpleIntegerProperty();
        this.nomRole = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.niveauAcces = new SimpleIntegerProperty();
    }

    // Getters and Setters
    public int getIdRole() { return idRole.get(); }
    public void setIdRole(int value) { idRole.set(value); }
    public IntegerProperty idRoleProperty() { return idRole; }

    public String getNomRole() { return nomRole.get(); }
    public void setNomRole(String value) { nomRole.set(value); }
    public StringProperty nomRoleProperty() { return nomRole; }

    public String getDescription() { return description.get(); }
    public void setDescription(String value) { description.set(value); }
    public StringProperty descriptionProperty() { return description; }

    public int getNiveauAcces() { return niveauAcces.get(); }
    public void setNiveauAcces(int value) { niveauAcces.set(value); }
    public IntegerProperty niveauAccesProperty() { return niveauAcces; }

    @Override
    public String toString() {
        return getNomRole();
    }
}