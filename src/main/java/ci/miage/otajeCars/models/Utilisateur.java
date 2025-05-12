// Utilisateur.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Utilisateur {
    private StringProperty matricule;
    private StringProperty nom;
    private StringProperty prenoms;
    private StringProperty motDePasse;
    private ObjectProperty<LocalDate> dateNaissance;
    private StringProperty email;
    private StringProperty telephone;
    private StringProperty urlCarteIdentite;
    private StringProperty urlPermisConduire;
    private ObjectProperty<Role> role;
    private ObjectProperty<Departement> departement;
    private ObjectProperty<LocalDateTime> dateCreation;
    private ObjectProperty<LocalDateTime> derniereConnexion;
    private BooleanProperty actif;

    public Utilisateur() {
        this.matricule = new SimpleStringProperty();
        this.nom = new SimpleStringProperty();
        this.prenoms = new SimpleStringProperty();
        this.motDePasse = new SimpleStringProperty();
        this.dateNaissance = new SimpleObjectProperty<>();
        this.email = new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
        this.urlCarteIdentite = new SimpleStringProperty();
        this.urlPermisConduire = new SimpleStringProperty();
        this.role = new SimpleObjectProperty<>();
        this.departement = new SimpleObjectProperty<>();
        this.dateCreation = new SimpleObjectProperty<>();
        this.derniereConnexion = new SimpleObjectProperty<>();
        this.actif = new SimpleBooleanProperty(true);
    }

    // Getters and Setters
    public String getMatricule() { return matricule.get(); }
    public void setMatricule(String value) { matricule.set(value); }
    public StringProperty matriculeProperty() { return matricule; }

    public String getNom() { return nom.get(); }
    public void setNom(String value) { nom.set(value); }
    public StringProperty nomProperty() { return nom; }

    public String getPrenoms() { return prenoms.get(); }
    public void setPrenoms(String value) { prenoms.set(value); }
    public StringProperty prenomsProperty() { return prenoms; }

    public String getMotDePasse() { return motDePasse.get(); }
    public void setMotDePasse(String value) { motDePasse.set(value); }
    public StringProperty motDePasseProperty() { return motDePasse; }

    public LocalDate getDateNaissance() { return dateNaissance.get(); }
    public void setDateNaissance(LocalDate value) { dateNaissance.set(value); }
    public ObjectProperty<LocalDate> dateNaissanceProperty() { return dateNaissance; }

    public String getEmail() { return email.get(); }
    public void setEmail(String value) { email.set(value); }
    public StringProperty emailProperty() { return email; }

    public String getTelephone() { return telephone.get(); }
    public void setTelephone(String value) { telephone.set(value); }
    public StringProperty telephoneProperty() { return telephone; }

    public String getUrlCarteIdentite() { return urlCarteIdentite.get(); }
    public void setUrlCarteIdentite(String value) { urlCarteIdentite.set(value); }
    public StringProperty urlCarteIdentiteProperty() { return urlCarteIdentite; }

    public String getUrlPermisConduire() { return urlPermisConduire.get(); }
    public void setUrlPermisConduire(String value) { urlPermisConduire.set(value); }
    public StringProperty urlPermisConduireProperty() { return urlPermisConduire; }

    public Role getRole() { return role.get(); }
    public void setRole(Role value) { role.set(value); }
    public ObjectProperty<Role> roleProperty() { return role; }

    public Departement getDepartement() { return departement.get(); }
    public void setDepartement(Departement value) { departement.set(value); }
    public ObjectProperty<Departement> departementProperty() { return departement; }

    public LocalDateTime getDateCreation() { return dateCreation.get(); }
    public void setDateCreation(LocalDateTime value) { dateCreation.set(value); }
    public ObjectProperty<LocalDateTime> dateCreationProperty() { return dateCreation; }

    public LocalDateTime getDerniereConnexion() { return derniereConnexion.get(); }
    public void setDerniereConnexion(LocalDateTime value) { derniereConnexion.set(value); }
    public ObjectProperty<LocalDateTime> derniereConnexionProperty() { return derniereConnexion; }

    public boolean isActif() { return actif.get(); }
    public void setActif(boolean value) { actif.set(value); }
    public BooleanProperty actifProperty() { return actif; }

    public String getNomComplet() {
        return nom.get() + " " + prenoms.get();
    }

    @Override
    public String toString() {
        return getNomComplet();
    }
}