# Noms des cas d'utilisations :


## Configurer etat initial :

### Sommaire d'identification :

	Résumé           : L'utilisateur configure l'état initial de la simulation
	Acteurs          : Utilisateur
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Aucune
#### Scénario nominal : 
	1. L'utilisateur complète une configuration initiale pour la simulation
	2. Le système valide la configuration initiale
#### Enchaînements alternatifs : 
	-
#### Post conditions : 
	L'utilisateur lance la simulation
#### Enchaînements d'exception : 
	E1 : Erreur de saisie dans la configuration initiale
	- Le système informe l'utilisateur d'une erreur de saisie de la configuration initiale 
#### Post conditions : 
	L'utilisateur corrige les paramètres nécessaires pour la configuration


## Démarrer simulation :

### Sommaire d'identification :

	Résumé           : L'utilisateur démarre la simulation
	Acteurs          : Utilisateur
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Configurer etat initial
#### Scénario nominal : 
	1. L'utilisateur lance la simulation
	2. La simulation se lance
	3. La simulation se termine 
	4. Le système prévient l'utilisateur que la simulation est terminée
#### Enchaînements alternatifs : 
	-
#### Post conditions : 
	La simulation se termine correctement
#### Enchaînements d'exception : 
	E1 : Une erreur survient lors de la simulation et celle-ci doit s'arrêter
	- Le système informe l'utilisateur des problèmes rencontrer lors de la simulation
#### Post conditions : 
	L'utilisateur corrige les paramètres nécessaires pour la simulation


## Visualiser déroulement :

### Sommaire d'identification :

	Résumé           : L'utilisateur peut visualiser le déroulement de la simulation
	Acteurs          : Utilisateur
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Démarrer simulation
#### Scénario nominal : 
	1. La simulation est lancée
	2. L'utilisateur lance la visualisation du déroulement de la simulation
	3. La simulation se termine
	4. La visualisation du déroulement de la simulation s'arrête et le système prévient l'utilisateur que la simulation est terminée
#### Enchaînements alternatifs : 
	A1 : Trop d'éléments sont sur une même cellule
	- Le système ne pourra pas afficher tous les éléments sur cette même cellule 
#### Post conditions : 
	La simulation se termine correctement
#### Enchaînements d'exception : 
	E1 : Une erreur survient lors de la simulation et celle-ci doit s'arrêter
	- Le système informe l'utilisateur des problèmes rencontrer lors de la simulation
#### Post conditions : 
	L'utilisateur corrige les paramètres nécessaires pour la simulation


## Obtenir bilan :

### Sommaire d'identification :

	Résumé           : L'utilisateur peut obtenir un bilan de la simulation
	Acteurs          : Utilisateur
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Démarrer simulation
#### Scénario nominal : 
	1. La simulation est terminée
	2. L'utilisateur demande le bilan final de la simulation
	3. Le système génère le bilan de la simulation
#### Enchaînements alternatifs : 
	-
#### Post conditions : 
	-
#### Enchaînements d'exception : 
	E1 : Erreur lors de la génération du bilan
	- Le système informe l'utilisateur qu'une erreur s'est produite lors de la génération du bilan 
#### Post conditions : 
	L'utilisateur doit regénérer un bilan


## Ajouter élément sur le damier :

### Sommaire d'identification :

	Résumé           : Grâce à l'API on peut ajouter des éléments dans des cellules du damier
	Acteurs          : API
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Aucune
#### Scénario nominal : 
	1. on ajoute/modifie/supprime un élément dans une cellule du damier
#### Enchaînements alternatifs : 
	A1 : On veut faire un/e ajout/modification/suppression interdit/e
	- Le système informe de la situation interdite
#### Post conditions : 
	L'utilisateur lance la simulation
#### Enchaînements d'exception : 
	-
#### Post conditions : 
	-


## Ajouter mobileAntenna :

### Sommaire d'identification :

	Résumé           : Ajouter une antenne sur le damier
	Acteurs          : API
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Aucune
#### Scénario nominal : 
	1. on ajoute/modifie/supprime une antenne dans une cellule du damier
#### Enchaînements alternatifs : 
	A1 : On veut faire un/e ajout/modification/suppression interdit/e
	- Le système informe de la situation interdite
#### Post conditions : 
	L'utilisateur lance la simulation
#### Enchaînements d'exception : 
	-
#### Post conditions : 
	-


## Ajouter mobilePhone :

### Sommaire d'identification :

	Résumé           : Ajouter un phone sur le damier
	Acteurs          : API
	Auteur           : Groupe
	Date de création : 05.04.2022
	Version          : 1.0
	Modifications    : -
	Responsable      : Leonardo Angelini

### Description des enchaînements :
	
#### Pré conditions : 
	Aucune
#### Scénario nominal : 
	1. on ajoute/modifie/supprime un phone dans une cellule du damier
#### Enchaînements alternatifs : 
	A1 : On veut faire un/e ajout/modification/suppression interdit/e
	- Le système informe de la situation interdite
#### Post conditions : 
	L'utilisateur lance la simulation
#### Enchaînements d'exception : 
	-
#### Post conditions : 
	-
