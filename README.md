# Gestion Options Étudiants

Atelier REST n°1 (SOA) : API REST de gestion des options et des étudiants avec Jersey (JAX-RS).

## Technologies
Java 17, Maven (war), Jersey 2.27, Jackson (JSON), JAXB (XML), Tomcat 9.0.75

## Structure
Le projet se trouve dans le dossier `Gestion_Options_Etudiants - VStudent/src/main/java` :
- `entities` : Option, Etudiant, EtudiantList
- `metiers` : OptionBusiness, EtudiantBusiness
- `utilities` : RestActivator (`@ApplicationPath("rest")`), JacksonConfig
- `webservices` : OptionRessource, EtudiantRessource
## Lancement
Déployer l'artefact `Gestion_Options_Etudiants:war exploded` sur Tomcat, puis ouvrir :
`http://localhost:8081/Gestion_Options_Etudiants_war_exploded/rest/options`

## Endpoints
| Méthode | URI | Statut |
|---|---|---|
| POST | /options | 200 / 404 |
| GET | /options | 200 |
| GET | /options?domaine=Mathématiques | 200 |
| DELETE | /options/{code} | 204 / 404 |
| PUT | /options/{code} | 200 / 404 |
| GET | /options/{code} | 200 / 404 |
| POST | /etudiants | 200 / 404 |
| GET | /etudiants | 200 |
| GET | /etudiants/{identifiant} | 200 / 404 |
| DELETE | /etudiants/{identifiant} | 204 / 404 |
| PUT | /etudiants/{identifiant} | 200 / 404 |
| GET | /etudiants/option?codeOption=1 | 200 / 404 (XML) |
