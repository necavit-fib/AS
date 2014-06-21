#AS

El codi de la pràctica es troba al directori `word-guess`.

El codi del client de mail (servei extern) es troba al directori `mail-client`

El codi del servidor de mail es troba al directori `mail-server`

L'informe de la primera entrega es troba al directori `report1`.

L'informe de la segona entrega es troba al directori `report2`.

L'informe de la tercera entrega es troba al directori `report3`.

##Setup

####Maven

[Maven](http://en.wikipedia.org/wiki/Apache_Maven) és una eina que ens permet la gestió de tot el cicle de vida d'un projecte. Entre d'altres, automatitza la gestió de dependències i les fases que es poden executar: validació, compilació, empaquetat, testeig, desplegament...

Farem servir Maven per a facilitar la gestió de dependències.

**Instal·lació (Ubuntu):**

Si tenim les capçaleres ben actualitzades, s'hauria de descarregar la versió 3 de Maven:

```bash
sudo apt-get install maven
```

Si executem `mvn --version` en un terminal ens ha de dir: `Apache Maven 3.0.4 ...`.

**Integració amb Eclipse**

Per integrar-ho fàcilment amb Eclipse, podem instal·lar el plugin m2e. Si cerquem 'maven' a l'Eclipse marketplace, hi ha una entrada que ens instal·larà tots els components necessaris. No és la versió de desenvolupament de Maven, sinó només les eines d'integració!

**POM.xml**

El fitxer de configuració de Maven del projecte és el `pom.xml`. Aquí es defineix tant la gestió de dependències com tot el flux de l'execució d'un build.

####PostreSQL (Ubuntu)

**Instal·lació:**

Instal·lem el servidor i l'administrador pgAdminIII.

```bash
sudo apt-get install postgresql postgresql-contrib
sudo apt-get install pgadmin3
```

**Server setup:**

Iniciem una connexió amb el servidor amb l'usuari 'postgres':

```bash
sudo -u postgres psql postgres
```

Un cop iniciada, ens assegurem que posem com a contrasenya 'postgres', mitjançant la comanda `\password postgres` (ens demanarà quina nova contrasenya se li assignarà a l'usuari 'postgres'). Quan volguem tancar la connexió, introduïm `\q`.

Creem també una base de dades que anomenarem 'asdb' (important per a que no haguem de canviar la configuració d'Hibernate):

```bash
sudo -u postgres createdb asdb
```

Per tal de fer testing de l'aplicació, crearem també una base de dades de test, on podrem mantenir un estat conegut al llarg de l'execució de les suites de test:

```bash
sudo -u postgres createdb astest
```

D'aquesta manera, disposarem de dos esquemes on podrem executar la nostra aplicació o els tests, de la manera que volguem.


####Dependències i servei extern

A la pràctica fem ús d'un servei extern que és un client de mail. Aquest client, que també hem implementat nosaltres, es comporta com una llibreria de la qual depèn el projecte principal. Al seu torn, aquest depèn del servidor, també. Totes aquestes dependències es gestionen amb Maven, de manera "automàtica".

Per tal que el projecte principal (word-guess) funcioni correctament, ens caldrà executar la següent comanda, situant-nos a l'arrel de cadascun dels projectes:

```bash
mvn install
```

Alternativament, podem 


