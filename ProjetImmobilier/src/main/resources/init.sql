delete from Logement_datesAnnonce;
delete from Logement_datesDebutLocation;
delete from Logement;
delete from Quartier;
delete from Commune;
delete from TypeLogement;
delete from Individu;



insert into Commune values (1, 30, 'Marignane', 6000);
insert into Commune values (2, 25, 'Vitrolles', 5000);
insert into Commune values (3, 20, 'Les Pennes Mirabeau', 4500);


insert into Quartier values (1, 'Méditerranée Parc', 1);
insert into Quartier values (2, 'Parc Hélène Boucher', 1);

insert into Quartier values (3, 'Bastide blanche', 2);
insert into Quartier values (4, 'La Frescoule', 2);

insert into Quartier values (5, 'La Cannai', 3);
insert into Quartier values (6, 'Les Pergolas fleuries', 3);

insert into TypeLogement values (1, 300);
insert into TypeLogement values (2, 350);
insert into TypeLogement values (3, 400);

insert into Individu values (1, '1960-07-12', 'Imbert', '0612569874', 'Paul');
insert into Individu values (2, '1953-02-18', 'Durand', '0612635425', 'Pierre');
insert into Individu values (3, '1975-04-03', 'Duhamel', '0456985224', 'Jacques');
insert into Individu values (4, '1952-03-08', 'Dargilo', '0421459632', 'Albert');
insert into Individu values (5, '1980-05-02', 'Gobert', '0745963212', 'Françoise');
insert into Individu values (6, '1958-03-14', 'Dacunto', '0645896325', 'Denise');

insert into Logement values (1, 0, 550, 'Rue du puisatier', '9', 90, 1, 1, 1);
insert into Logement values (2, 1, 600, 'Rue Anatole France', '10', 80, 2, 2, 2);
insert into Logement values (3, 1, 700, 'Rue Frédéric Mistral', '8', 70, 3, 3, 3);
insert into Logement values (4, 1, 750, 'Rue Maréchal Joffre', '2', 85, 4, 4, 1);
insert into Logement values (5, 1, 800, 'Boulevard Charles de Gaulle', '4 bis', 100, 5, 5, 2);
insert into Logement values (6, 0, 900, 'Boulevard Carnot', '1', 110, 6, 6, 3);

insert into Logement_datesAnnonce values (1, '2015-04-23');
insert into Logement_datesAnnonce values (2, '2015-04-24');
insert into Logement_datesAnnonce values (3, '2015-04-25');
insert into Logement_datesAnnonce values (4, '2015-04-26');
insert into Logement_datesAnnonce values (5, '2015-04-27');
insert into Logement_datesAnnonce values (6, '2015-04-28');

insert into Logement_datesDebutLocation values (1, '2015-04-30');
insert into Logement_datesDebutLocation values (6, '2015-05-04');



