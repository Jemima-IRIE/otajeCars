// Plainte.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;
import java.time.LocalDateTime;

public class Plainte {
    private IntegerProperty idPlainte;
    private ObjectProperty<Utilisateur> plaignant;
    private ObjectProperty<TypePlainte> typePlainte;
    private StringProperty objet;
    private StringProperty description;
    private ObjectProperty<LocalDateTime> datePlainte;
    private ObjectProperty<StatutPlainte> statutPlainte;
    private ObjectProperty<Utilisateur> rhEnCharge;
    private ObjectProperty<LocalDateTime> datePriseEnCharge;
    private ObjectProperty<LocalDateTime> dateResolution;
    private StringProperty commentaireResolution;
    private ObjectProperty<Confidentialite> confidentialite;

    public enum StatutPlainte {
        OUVERTE("Ouverte"),
        EN_COURS("En cours"),
        RESOLUE("Résolue"),
        REJETEE("Rejetée");

        private final String libelle;

        StatutPlainte(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }

        @Override
        public String toString() {
            return libelle;
        }
    }

    public enum Confidentialite {
        PUBLIC("Public"),
        PRIVE("Privé"),
        CONFIDENTIEL("Confidentiel");

        private final String libelle;

        Confidentialite(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }

        @Override
        public String toString() {
            return libelle;
        }
    }

    public Plainte() {
        this.idPlainte = new SimpleIntegerProperty();
        this.plaignant = new SimpleObjectProperty<>();
        this.typePlainte = new SimpleObjectProperty<>();
        this.objet = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.datePlainte = new SimpleObjectProperty<>();
        this.statutPlainte = new SimpleObjectProperty<>(StatutPlainte.OUVERTE);
        this.rhEnCharge = new SimpleObjectProperty<>();
        this.datePriseEnCharge = new SimpleObjectProperty<>();
        this.dateResolution = new SimpleObjectProperty<>();
        this.commentaireResolution = new SimpleStringProperty();
        this.confidentialite = new SimpleObjectProperty<>(Confidentialite.PRIVE);
    }

    // Getters and Setters
    public int getIdPlainte() { return idPlainte.get(); }
    public void setIdPlainte(int value) { idPlainte.set(value); }
    public IntegerProperty idPlainteProperty() { return idPlainte; }

    public Utilisateur getPlaignant() { return plaignant.get(); }
    public void setPlaignant(Utilisateur value) { plaignant.set(value); }
    public ObjectProperty<Utilisateur> plaignantProperty() { return plaignant; }

    public TypePlainte getTypePlainte() { return typePlainte.get(); }
    public void setTypePlainte(TypePlainte value) { typePlainte.set(value); }
    public ObjectProperty<TypePlainte> typePlainteProperty() { return typePlainte; }

    public String getObjet() { return objet.get(); }
    public void setObjet(String value) { objet.set(value); }
    public StringProperty objetProperty() { return objet; }

    public String getDescription() { return description.get(); }
    public void setDescription(String value) { description.set(value); }
    public StringProperty descriptionProperty() { return description; }

    public LocalDateTime getDatePlainte() { return datePlainte.get(); }
    public void setDatePlainte(LocalDateTime value) { datePlainte.set(value); }
    public ObjectProperty<LocalDateTime> datePlainteProperty() { return datePlainte; }

    public StatutPlainte getStatutPlainte() { return statutPlainte.get(); }
    public void setStatutPlainte(StatutPlainte value) { statutPlainte.set(value); }
    public ObjectProperty<StatutPlainte> statutPlainteProperty() { return statutPlainte; }

    public Utilisateur getRhEnCharge() { return rhEnCharge.get(); }
    public void setRhEnCharge(Utilisateur value) { rhEnCharge.set(value); }
    public ObjectProperty<Utilisateur> rhEnChargeProperty() { return rhEnCharge; }

    public LocalDateTime getDatePriseEnCharge() { return datePriseEnCharge.get(); }
    public void setDatePriseEnCharge(LocalDateTime value) { datePriseEnCharge.set(value); }
    public ObjectProperty<LocalDateTime> datePriseEnChargeProperty() { return datePriseEnCharge; }

    public LocalDateTime getDateResolution() { return dateResolution.get(); }
    public void setDateResolution(LocalDateTime value) { dateResolution.set(value); }
    public ObjectProperty<LocalDateTime> dateResolutionProperty() { return dateResolution; }

    public String getCommentaireResolution() { return commentaireResolution.get(); }
    public void setCommentaireResolution(String value) { commentaireResolution.set(value); }
    public StringProperty commentaireResolutionProperty() { return commentaireResolution; }

    public Confidentialite getConfidentialite() { return confidentialite.get(); }
    public void setConfidentialite(Confidentialite value) { confidentialite.set(value); }
    public ObjectProperty<Confidentialite> confidentialiteProperty() { return confidentialite; }
}


