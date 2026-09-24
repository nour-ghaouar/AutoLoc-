# AutoLoc

## Présentation du projet

AutoLoc est une application de gestion de location de véhicules multi-agences.

L'objectif du projet est de numériser les principales activités d'une entreprise de location de véhicules, notamment :

- la gestion des agences ;
- la gestion des véhicules ;
- la gestion des clients ;
- la réservation des véhicules ;
- la gestion des contrats ;
- la gestion des paiements ;
- le suivi de la flotte.

L'application sera développée avec Spring Boot et exposera une API REST.

---

## Acteurs du système

Le système AutoLoc comporte quatre acteurs principaux.

### 1. Client

Le Client est une personne ou une entreprise souhaitant louer un véhicule.

Principaux cas d'utilisation :

- consulter les véhicules disponibles ;
- rechercher un véhicule ;
- créer une réservation ;
- modifier ou annuler une réservation ;
- consulter ses contrats.

---

### 2. Agent d'agence

L'Agent d'agence est chargé de la gestion opérationnelle d'une agence.

Principaux cas d'utilisation :

- gérer les véhicules ;
- consulter les réservations ;
- valider une réservation ;
- établir un contrat ;
- enregistrer un paiement ;
- suivre la disponibilité des véhicules.

---

### 3. Responsable d'agence / Manager

Le Responsable d'agence supervise une agence et son personnel.

Il possède les droits d'un Agent d'agence avec des fonctionnalités supplémentaires.

Principaux cas d'utilisation :

- gérer les véhicules ;
- gérer les réservations ;
- établir les contrats ;
- enregistrer les paiements ;
- gérer les employés de son agence ;
- consulter les statistiques de son agence.

---

### 4. Administrateur

L'Administrateur assure l'administration générale de la plateforme.

Principaux cas d'utilisation :

- gérer les agences ;
- gérer les catégories de véhicules ;
- consulter les statistiques globales ;
- gérer la configuration générale de la plateforme.

---

## Résumé des acteurs

| Acteur | Rôle principal |
|---|---|
| Client | Réserver un véhicule et consulter ses contrats |
| Agent d'agence | Gérer les opérations quotidiennes de location |
| Responsable d'agence | Superviser l'agence et ses employés |
| Administrateur | Administrer l'ensemble de la plateforme |
