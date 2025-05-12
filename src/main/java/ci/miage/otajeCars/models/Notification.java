// Notification.java
package main.java.ci.miage.otajeCars.models;

import javafx.beans.property.*;
import java.time.LocalDateTime;

public class Notification {
    private IntegerProperty idNotification;
    private ObjectProperty<TypeNotification> typeNotification;
    private StringProperty titre;
    private StringProperty message;
    private ObjectProperty<Utilisateur> emetteur;
    private ObjectProperty<Utilisateur> destinataire;
    private ObjectProperty<Role> roleDestinataire;
    private ObjectProperty<LocalDateTime> dateCreation;
    private ObjectProperty<LocalDateTime> dateLecture;
    private BooleanProperty lu;
    private ObjectProperty<Priorite> priorite;
    private StringProperty urlAction;

    public enum Priorite {
        BASSE("Basse"),
        NORMALE("Normale"),
        HAUTE("Haute"),
        URGENTE("Urgente");

        private final String libelle;

        Priorite(String libelle) {
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

    public Notification() {
        this.idNotification = new SimpleIntegerProperty();
        this.typeNotification = new SimpleObjectProperty<>();
        this.titre = new SimpleStringProperty();
        this.message = new SimpleStringProperty();
        this.emetteur = new SimpleObjectProperty<>();
        this.destinataire = new SimpleObjectProperty<>();
        this.roleDestinataire = new SimpleObjectProperty<>();
        this.dateCreation = new SimpleObjectProperty<>();
        this.dateLecture = new SimpleObjectProperty<>();
        this.lu = new SimpleBooleanProperty(false);
        this.priorite = new SimpleObjectProperty<>(Priorite.NORMALE);
        this.urlAction = new SimpleStringProperty();
    }

    // Getters and Setters
    public int getIdNotification() { return idNotification.get(); }
    public void setIdNotification(int value) { idNotification.set(value); }
    public IntegerProperty idNotificationProperty() { return idNotification; }

    public TypeNotification getTypeNotification() { return typeNotification.get(); }
    public void setTypeNotification(TypeNotification value) { typeNotification.set(value); }
    public ObjectProperty<TypeNotification> typeNotificationProperty() { return typeNotification; }

    public String getTitre() { return titre.get(); }
    public void setTitre(String value) { titre.set(value); }
    public StringProperty titreProperty() { return titre; }

    public String getMessage() { return message.get(); }
    public void setMessage(String value) { message.set(value); }
    public StringProperty messageProperty() { return message; }

    public Utilisateur getEmetteur() { return emetteur.get(); }
    public void setEmetteur(Utilisateur value) { emetteur.set(value); }
    public ObjectProperty<Utilisateur> emetteurProperty() { return emetteur; }

    public Utilisateur getDestinataire() { return destinataire.get(); }
    public void setDestinataire(Utilisateur value) { destinataire.set(value); }
    public ObjectProperty<Utilisateur> destinataireProperty() { return destinataire; }

    public Role getRoleDestinataire() { return roleDestinataire.get(); }
    public void setRoleDestinataire(Role value) { roleDestinataire.set(value); }
    public ObjectProperty<Role> roleDestinataireProperty() { return roleDestinataire; }

    public LocalDateTime getDateCreation() { return dateCreation.get(); }
    public void setDateCreation(LocalDateTime value) { dateCreation.set(value); }
    public ObjectProperty<LocalDateTime> dateCreationProperty() { return dateCreation; }

    public LocalDateTime getDateLecture() { return dateLecture.get(); }
    public void setDateLecture(LocalDateTime value) { dateLecture.set(value); }
    public ObjectProperty<LocalDateTime> dateLectureProperty() { return dateLecture; }

    public boolean isLu() { return lu.get(); }
    public void setLu(boolean value) { lu.set(value); }
    public BooleanProperty luProperty() { return lu; }

    public Priorite getPriorite() { return priorite.get(); }
    public void setPriorite(Priorite value) { priorite.set(value); }
    public ObjectProperty<Priorite> prioriteProperty() { return priorite; }

    public String getUrlAction() { return urlAction.get(); }
    public void setUrlAction(String value) { urlAction.set(value); }
    public StringProperty urlActionProperty() { return urlAction; }
}


