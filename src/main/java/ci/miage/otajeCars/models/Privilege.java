// Privilege.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;

public class Privilege {
    private IntegerProperty idPrivilege;
    private StringProperty codePrivilege;
    private StringProperty libelle;
    private StringProperty description;

    public Privilege() {
        this.idPrivilege = new SimpleIntegerProperty();
        this.codePrivilege = new SimpleStringProperty();
        this.libelle = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdPrivilege() { return idPrivilege.get(); }
    public void setIdPrivilege(int value) { idPrivilege.set(value); }
    public IntegerProperty idPrivilegeProperty() { return idPrivilege; }

    public String getCodePrivilege() { return codePrivilege.get(); }
    public void setCodePrivilege(String value) { codePrivilege.set(value); }
    public StringProperty codePrivilegeProperty() { return codePrivilege; }

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