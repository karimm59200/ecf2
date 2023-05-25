package org.example;

import org.example.entities.Activite;
import org.example.entities.Adherents;
import org.example.entities.CentreSportif;
import org.example.services.ActiviteService;
import org.example.services.AdherentService;
import org.example.services.CentreSportifService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private AdherentService adherentService;
    private CentreSportifService centreSportifService;
    private ActiviteService activiteService;
    private Scanner scanner;

    public Ihm() {
        adherentService = new AdherentService();
        centreSportifService = new CentreSportifService();
        activiteService = new ActiviteService();
        scanner = new Scanner(System.in);
    }

    public  void start() throws ParseException {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1": creationCentre();

                    break;
                case "2": updateCentre();

                    break;
                case "3": deleteCentre();
                    break;
                case "4": creationActivite();
                    break;
                case "5": deleteActivite();
                    break;
                case "6": updateActivite();
                    break;

                case "7": createAdherent();
                    break;
                case "8": deleteAdherent();
                    break;
                case "9": updateAdherent();
                    break;
                case "10": displayListAdherent();
                    break;
            }
        }while(!choice.equals("0"));
        centreSportifService.end();
        activiteService.end();
        adherentService.end();
    }

    private void menu() {
        System.out.println("########  Menu  #########");
        System.out.println("1 -- Création d'un centre sportif");
        System.out.println("2 -- Modification du centre sportif");
        System.out.println("3 -- Suppression du centre sportif");
        System.out.println("4 -- Création d'une activité");
        System.out.println("5 -- Suppression d'une activité");
        System.out.println("6 -- Modification d'une activité");
        System.out.println("7 -- Création d'un adhérent");
        System.out.println("8 -- Suppression d'un adhérent");
        System.out.println("9 -- Modification des informations de l'adhérent");
        System.out.println("10 -- Affichage de la liste des adhérents");

        System.out.println("0 -- Quitter ");

    }

    private void creationCentre () {
        System.out.println("########  Création d'un centre sportif  #########");
        System.out.println("Nom du centre : ");
        String nom = scanner.nextLine();
        System.out.println("Adresse du centre : ");
        String adresse = scanner.nextLine();
        centreSportifService.create( new CentreSportif(nom, adresse));
    }

    private void deleteCentre() {
        System.out.println("########  Suppression d'un centre sportif  #########");
        System.out.println("Merci de saisir l'id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        CentreSportif centreSportif = centreSportifService.findById(id);
        centreSportifService.delete(centreSportif);
    }

    private void updateCentre(){
        System.out.println("########  Modification d'un centre sportif  #########");
        System.out.println("Merci de saisir l'id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        CentreSportif centreSportif = centreSportifService.findById(id);
        System.out.println("Nom du centre : ");
        String nom = scanner.nextLine();
        System.out.println("Adresse du centre : ");
        String adresse = scanner.nextLine();
        centreSportif.setNom(nom);
        centreSportif.setAdresse(adresse);

        centreSportifService.update(centreSportif);
    }

    private void creationActivite(){
        System.out.println("########  Création d'une activité  #########");
        Activite activite = new Activite();

        System.out.println("Merci de saisir l'id du centre sportif:");
        int id = scanner.nextInt();
        scanner.nextLine();
        CentreSportif centreSportif = centreSportifService.findById(id);

        System.out.println("Nom de l'activité : ");
        String nom = scanner.nextLine();
        activite.setNom(nom);

        System.out.println("description de l'activité : ");
        String description = scanner.nextLine();
        activite.setDescription(description);

        System.out.println("Adresse du centre : ");
        String lieu = scanner.nextLine();
        activite.setLieu(lieu);

        System.out.println("Horaire de l'activité : ");
        String horaire = scanner.nextLine();
        activite.setHoraire(horaire);
         activite.setCentreSportif(centreSportif);
//        activiteService.create( new Activite(nom, description, lieu, horaire, centreSportif));
        activiteService.create(activite);
        //centreSportif.getActivites().add(activite);

    }

    private void deleteActivite(){
        System.out.println("########  Suppression d'une activité  #########");


        System.out.println("Merci de saisir l'id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activite activite = activiteService.findById(id);
        activiteService.delete(activite);
    }

    private void updateActivite(){
        System.out.println("########  Modification d'une activité  #########");
        System.out.println("Merci de saisir l'id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activite activite = activiteService.findById(id);
        System.out.println("Nom de l'activité : ");
        String nom = scanner.nextLine();
        System.out.println("description de l'activité : ");
        String description = scanner.nextLine();
        System.out.println("Adresse du centre : ");
        String lieu = scanner.nextLine();
        System.out.println("Horaire de l'activité : ");
        String horaire = scanner.nextLine();
        System.out.println("Merci de saisir l'id du centre sportif:");
        int idCentre = scanner.nextInt();
        scanner.nextLine();
        activite.setCentreSportif(centreSportifService.findById(idCentre));
        activite.setNom(nom);
        activite.setDescription(description);
        activite.setLieu(lieu);
        activite.setHoraire(horaire);
        activiteService.update(activite);
        activite.setCentreSportif(centreSportifService.findById(idCentre));
    }

     public void createAdherent() throws ParseException {
        System.out.println("########  Création d'un adhérent  #########");
        Adherents adherents = new Adherents();

        System.out.println("Nom de l'adhérent : ");
        String nom = scanner.nextLine();
        adherents.setNom(nom);

        System.out.println("Prénom de l'adhérent : ");
        String prenom = scanner.nextLine();
        adherents.setPrenom(prenom);

        System.out.println("date de naissance de l'adhérent au format dd/mm/yyyy : ");
        String dateS = scanner.nextLine();
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateS);
            adherents.setDateDeNaissance(date);
            System.out.println(date);
            System.out.println("Merci de saisir l'id de l'activité:");
            int id = scanner.nextInt();
            scanner.nextLine();
            Activite activite = activiteService.findById(id);
            System.out.println(adherents);
            adherents.getActivites().add(activite);




            adherentService.create(adherents);
            adherents.getActivites().add(activite);
            System.out.println("**************");
            System.out.println(activite);
            activiteService.update(activiteService.findById(id));



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

     public void deleteAdherent(){
        System.out.println("########  Suppression d'un adhérent  #########");
        System.out.println("Merci de saisir l'id de l'adhérent à supprimer:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Adherents adherents = adherentService.findById(id);
         System.out.println(adherents);
        adherentService.delete(adherents);

    }

    public void updateAdherent(){
        System.out.println("########  Modification d'un adhérent  #########");
        System.out.println("Merci de saisir l'id de l'adhérent à modifier:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Adherents adherents = adherentService.findById(id);
        System.out.println("Nom de l'adhérent : ");
        String nom = scanner.nextLine();
        System.out.println("Prénom de l'adhérent : ");
        String prenom = scanner.nextLine();
        System.out.println("date de naissance de l'adhérent au format dd/mm/yyyy : ");
        String dateS = scanner.nextLine();
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateS);
            adherents.setDateDeNaissance(date);
            adherents.setNom(nom);
            adherents.setPrenom(prenom);
            adherentService.update(adherents);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayListAdherent(){
        System.out.println("########  Liste des adhérents  #########");
        List<Adherents> adherents = adherentService.findAll();
        for (Adherents adherent : adherents) {
            System.out.println(adherent);
        }
    }

}
