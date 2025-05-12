// Vehicule.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Vehicule {
    private IntegerProperty idVehicule;
    private StringProperty immatriculation;
    private StringProperty marque;
    private StringProperty modele;
    private IntegerProperty annee;
    private ObjectProperty<TypeVehicule> type;
    private ObjectProperty<StatutVehicule> statut;
    private ObjectProperty<LocalDate> dateMiseEnService;
    private IntegerProperty kilometrageInitial;
    private IntegerProperty kilometrageActuel;
    private StringProperty urlCarteGrise;
    private StringProperty urlAssurance;
    private ObjectProperty<LocalDate> dateProchaineVisiteTechnique;
    private ObjectProperty<LocalDate> dateProchaineAssurance;
    private DoubleProperty consommationMoyenne;

    public Vehicule() {
        this.idVehicule = new SimpleIntegerProperty();
        this.immatriculation = new SimpleStringProperty();
        this.marque = new SimpleStringProperty();
        this.modele = new SimpleStringProperty();
        this.annee = new SimpleIntegerProperty();
        this.type = new SimpleObjectProperty<>();
        this.statut = new SimpleObjectProperty<>();
        this.dateMiseEnService = new SimpleObjectProperty<>();
        this.kilometrageInitial = new SimpleIntegerProperty();
        this.kilometrageActuel = new SimpleIntegerProperty();
        this.urlCarteGrise = new SimpleStringProperty();
        this.urlAssurance = new SimpleStringProperty();
        this.dateProchaineVisiteTechnique = new SimpleObjectProperty<>();
        this.dateProchaineAssurance = new SimpleObjectProperty<>();
        this.consommationMoyenne = new SimpleDoubleProperty();
    }

    // Getters and Setters pour tous les champs
    public int getIdVehicule() { return idVehicule.get(); }
    public void setIdVehicule(int value) { idVehicule.set(value); }
    public IntegerProperty idVehiculeProperty() { return idVehicule; }

    public String getImmatriculation() { return immatriculation.get(); }
    public void setImmatriculation(String value) { immatriculation.set(value); }
    public StringProperty immatriculationProperty() { return immatriculation; }

    public String getMarque() { return marque.get(); }
    public void setMarque(String value) { marque.set(value); }
    public StringProperty marqueProperty() { return marque; }

    public String getModele() { return modele.get(); }
    public void setModele(String value) { modele.set(value); }
    public StringProperty modeleProperty() { return modele; }

    public int getAnnee() { return annee.get(); }
    public void setAnnee(int value) { annee.set(value); }
    public IntegerProperty anneeProperty() { return annee; }

    public TypeVehicule getType() { return type.get(); }
    public void setType(TypeVehicule value) { type.set(value); }
    public ObjectProperty<TypeVehicule> typeProperty() { return type; }

    public StatutVehicule getStatut() { return statut.get(); }
    public void setStatut(StatutVehicule value) { statut.set(value); }
    public ObjectProperty<StatutVehicule> statutProperty() { return statut; }

    public LocalDate getDateMiseEnService() { return dateMiseEnService.get(); }
    public void setDateMiseEnService(LocalDate value) { dateMiseEnService.set(value); }
    public ObjectProperty<LocalDate> dateMiseEnServiceProperty() { return dateMiseEnService; }

    public int getKilometrageInitial() { return kilometrageInitial.get(); }
    public void setKilometrageInitial(int value) { kilometrageInitial.set(value); }
    public IntegerProperty kilometrageInitialProperty() { return kilometrageInitial; }

    public int getKilometrageActuel() { return kilometrageActuel.get(); }
    public void setKilometrageActuel(int value) { kilometrageActuel.set(value); }
    public IntegerProperty kilometrageActuelProperty() { return kilometrageActuel; }

    public String getUrlCarteGrise() { return urlCarteGrise.get(); }
    public void setUrlCarteGrise(String value) { urlCarteGrise.set(value); }
    public StringProperty urlCarteGriseProperty() { return urlCarteGrise; }

    public String getUrlAssurance() { return urlAssurance.get(); }
    public void setUrlAssurance(String value) { urlAssurance.set(value); }
    public StringProperty urlAssuranceProperty() { return urlAssurance; }

    public LocalDate getDateProchaineVisiteTechnique() { return dateProchaineVisiteTechnique.get(); }
    public void setDateProchaineVisiteTechnique(LocalDate value) { dateProchaineVisiteTechnique.set(value); }
    public ObjectProperty<LocalDate> dateProchaineVisiteTechniqueProperty() { return dateProchaineVisiteTechnique; }

    public LocalDate getDateProchaineAssurance() { return dateProchaineAssurance.get(); }
    public void setDateProchaineAssurance(LocalDate value) { dateProchaineAssurance.set(value); }
    public ObjectProperty<LocalDate> dateProchaineAssuranceProperty() { return dateProchaineAssurance; }

    public double getConsommationMoyenne() { return consommationMoyenne.get(); }
    public void setConsommationMoyenne(double value) { consommationMoyenne.set(value); }
    public DoubleProperty consommationMoyenneProperty() { return consommationMoyenne; }

    public String getDescription() {
        return marque.get() + " " + modele.get() + " (" + immatriculation.get() + ")";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
