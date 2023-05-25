### Application Hibernate Gestion de centre sportif ###
## Description ##
- creation d'une application en console Java qui permet à un utilisateur d'intéragir avec le système de gestion du centre sportif. 
- Ajout d'un adhérents
- Affichade des adhérents
- la mise à jour des informations d'un adhérent
- la suppression d'un adhérent
- l'inscription aux différents cours proposés par le centre sportif

### explication ###
- L'application se compose de trois entités principales : Adhérent, Activité et Le centre sportif.


## Relation entre les entités ##
- Un adhérent peut s'inscrire à plusieurs activités liaison est Many to Many.
- il y a donc une table intermédiaire entre les deux entités qui se nomme adherent_activite.
- Un centre sportif peut proposer plusieurs activités liaison est One to Many.

![image](image/diagrammeDeClasse)
#   e c f 2 
 
 