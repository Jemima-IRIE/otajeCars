// Affectation.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;
import java.time.LocalDateTime;

public class Affectation {
    private IntegerProperty idAffectation;
    private ObjectProperty<Utilisateur> utilisateur;
    private ObjectProperty<Vehicule> vehicule;
    private ObjectProperty<LocalDateTime> dateDebut;
    private ObjectProperty<LocalDateTime> dateRetourPrevu;
    private ObjectProperty<LocalDateTime> dateRetourReel;
    private IntegerProperty kilometrageDebut;
    private IntegerProperty kilometrageRetour;
    private ObjectProperty<StatutAffectation> statutAffectation;
    private StringProperty observations;

    public enum StatutAffectation {
        EN_COURS("En cours"),
        TERMINEE("Terminée"),
        ANNULEE("Annulée");

        private final String libelle;

        StatutAffectation(String libelle) {
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

    public Affectation() {
        this.idAffectation = new SimpleIntegerProperty();
        this.utilisateur = new SimpleObjectProperty<>();
        this.vehicule = new SimpleObjectProperty<>();
        this.dateDebut = new SimpleObjectProperty<>();
        this.dateRetourPrevu = new SimpleObjectProperty<>();
        this.dateRetourReel = new SimpleObjectProperty<>();
        this.kilometrageDebut = new SimpleIntegerProperty();
        this.kilometrageRetour = new SimpleIntegerProperty();
        this.statutAffectation = new SimpleObjectProperty<>(StatutAffectation.EN_COURS);
        this.observations = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdAffectation() { return idAffectation.get(); }
    public void setIdAffectation(int value) { idAffectation.set(value); }
    public IntegerProperty idAffectationProperty() { return idAffectation; }

    public Utilisateur getUtilisateur() { return utilisateur.get(); }
    public void setUtilisateur(Utilisateur value) { utilisateur.set(value); }
    public ObjectProperty<Utilisateur> utilisateurProperty() { return utilisateur; }

    public Vehicule getVehicule() { return vehicule.get(); }
    public void setVehicule(Vehicule value) { vehicule.set(value); }
    public ObjectProperty<Vehicule> vehiculeProperty() { return vehicule; }

    public LocalDateTime getDateDebut() { return dateDebut.get(); }
    public void setDateDebut(LocalDateTime value) { dateDebut.set(value); }
    public ObjectProperty<LocalDateTime> dateDebutProperty() { return dateDebut; }

    public LocalDateTime getDateRetourPrevu() { return dateRetourPrevu.get(); }
    public void setDateRetourPrevu(LocalDateTime value) { dateRetourPrevu.set(value); }
    public ObjectProperty<LocalDateTime> dateRetourPrevuProperty() { return dateRetourPrevu; }

    public LocalDateTime getDateRetourReel() { return dateRetourReel.get(); }
    public void setDateRetourReel(LocalDateTime value) { dateRetourReel.set(value); }
    public ObjectProperty<LocalDateTime> dateRetourReelProperty() { return dateRetourReel; }

    public int getKilometrageDebut() { return kilometrageDebut.get(); }
    public void setKilometrageDebut(int value) { kilometrageDebut.set(value); }
    public IntegerProperty kilometrageDebutProperty() { return kilometrageDebut; }

    public int getKilometrageRetour() { return kilometrageRetour.get(); }
    public void setKilometrageRetour(int value) { kilometrageRetour.set(value); }
    public IntegerProperty kilometrageRetourProperty() { return kilometrageRetour; }

    public StatutAffectation getStatutAffectation() { return statutAffectation.get(); }
    public void setStatutAffectation(StatutAffectation value) { statutAffectation.set(value); }
    public ObjectProperty<StatutAffectation> statutAffectationProperty() { return statutAffectation; }

    public String getObservations() { return observations.get(); }
    public void setObservations(String value) { observations.set(value); }
    public StringProperty observationsProperty() { return observations; }
}