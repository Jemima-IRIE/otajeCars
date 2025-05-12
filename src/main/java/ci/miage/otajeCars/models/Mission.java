// Mission.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;
import java.time.LocalDateTime;

public class Mission {
    private IntegerProperty idMission;
    private StringProperty titreMission;
    private ObjectProperty<LocalDateTime> dateDebut;
    private ObjectProperty<LocalDateTime> dateFin;
    private StringProperty lieuDepart;
    private StringProperty lieuDestination;
    private StringProperty descriptionMission;
    private ObjectProperty<Utilisateur> demandeur;
    private ObjectProperty<Utilisateur> validateur;
    private ObjectProperty<Vehicule> vehicule;
    private IntegerProperty idAffectation;
    private ObjectProperty<StatutMission> statutMission;
    private ObjectProperty<LocalDateTime> dateValidation;
    private StringProperty motifRefus;

    public enum StatutMission {
        BROUILLON("Brouillon"),
        EN_ATTENTE("En attente"),
        VALIDEE("Validée"),
        EN_COURS("En cours"),
        TERMINEE("Terminée"),
        ANNULEE("Annulée");

        private final String libelle;

        StatutMission(String libelle) {
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

    public Mission() {
        this.idMission = new SimpleIntegerProperty();
        this.titreMission = new SimpleStringProperty();
        this.dateDebut = new SimpleObjectProperty<>();
        this.dateFin = new SimpleObjectProperty<>();
        this.lieuDepart = new SimpleStringProperty();
        this.lieuDestination = new SimpleStringProperty();
        this.descriptionMission = new SimpleStringProperty();
        this.demandeur = new SimpleObjectProperty<>();
        this.validateur = new SimpleObjectProperty<>();
        this.vehicule = new SimpleObjectProperty<>();
        this.idAffectation = new SimpleIntegerProperty();
        this.statutMission = new SimpleObjectProperty<>(StatutMission.BROUILLON);
        this.dateValidation = new SimpleObjectProperty<>();
        this.motifRefus = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdMission() { return idMission.get(); }
    public void setIdMission(int value) { idMission.set(value); }
    public IntegerProperty idMissionProperty() { return idMission; }

    public String getTitreMission() { return titreMission.get(); }
    public void setTitreMission(String value) { titreMission.set(value); }
    public StringProperty titreMissionProperty() { return titreMission; }

    public LocalDateTime getDateDebut() { return dateDebut.get(); }
    public void setDateDebut(LocalDateTime value) { dateDebut.set(value); }
    public ObjectProperty<LocalDateTime> dateDebutProperty() { return dateDebut; }

    public LocalDateTime getDateFin() { return dateFin.get(); }
    public void setDateFin(LocalDateTime value) { dateFin.set(value); }
    public ObjectProperty<LocalDateTime> dateFinProperty() { return dateFin; }

    public String getLieuDepart() { return lieuDepart.get(); }
    public void setLieuDepart(String value) { lieuDepart.set(value); }
    public StringProperty lieuDepartProperty() { return lieuDepart; }

    public String getLieuDestination() { return lieuDestination.get(); }
    public void setLieuDestination(String value) { lieuDestination.set(value); }
    public StringProperty lieuDestinationProperty() { return lieuDestination; }

    public String getDescriptionMission() { return descriptionMission.get(); }
    public void setDescriptionMission(String value) { descriptionMission.set(value); }
    public StringProperty descriptionMissionProperty() { return descriptionMission; }

    public Utilisateur getDemandeur() { return demandeur.get(); }
    public void setDemandeur(Utilisateur value) { demandeur.set(value); }
    public ObjectProperty<Utilisateur> demandeurProperty() { return demandeur; }

    public Utilisateur getValidateur() { return validateur.get(); }
    public void setValidateur(Utilisateur value) { validateur.set(value); }
    public ObjectProperty<Utilisateur> validateurProperty() { return validateur; }

    public Vehicule getVehicule() { return vehicule.get(); }
    public void setVehicule(Vehicule value) { vehicule.set(value); }
    public ObjectProperty<Vehicule> vehiculeProperty() { return vehicule; }

    public int getIdAffectation() { return idAffectation.get(); }
    public void setIdAffectation(int value) { idAffectation.set(value); }
    public IntegerProperty idAffectationProperty() { return idAffectation; }

    public StatutMission getStatutMission() { return statutMission.get(); }
    public void setStatutMission(StatutMission value) { statutMission.set(value); }
    public ObjectProperty<StatutMission> statutMissionProperty() { return statutMission; }

    public LocalDateTime getDateValidation() { return dateValidation.get(); }
    public void setDateValidation(LocalDateTime value) { dateValidation.set(value); }
    public ObjectProperty<LocalDateTime> dateValidationProperty() { return dateValidation; }

    public String getMotifRefus() { return motifRefus.get(); }
    public void setMotifRefus(String value) { motifRefus.set(value); }
    public StringProperty motifRefusProperty() { return motifRefus; }

    @Override
    public String toString() {
        return getTitreMission();
    }
}