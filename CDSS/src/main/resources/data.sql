INSERT INTO user (id, username, password , role) VALUES (789, 'doctor', '$2a$10$8sXfLf7KxaxrYOGnggigv.GMEV/wpCaHXou3OrLOnf.hw2HUMwtRG', 'ROLE_DOCTOR');
INSERT INTO user (id, username, password , role) VALUES (790, 'admin', '$2a$10$8sXfLf7KxaxrYOGnggigv.GMEV/wpCaHXou3OrLOnf.hw2HUMwtRG', 'ROLE_ADMIN');

INSERT INTO supstance (id, supstance_id) VALUES (789, 'supstance1');
INSERT INTO supstance (id, supstance_id) VALUES (790, 'supstance2');
INSERT INTO supstance (id, supstance_id) VALUES (791, 'supstance3');
INSERT INTO supstance (id, supstance_id) VALUES (792, 'supstance4');

INSERT INTO medicine (id, medicine_id) VALUES (789, 'antibiotik');
INSERT INTO medicine (id, medicine_id) VALUES (790, 'analgetik');
INSERT INTO medicine (id, medicine_id) VALUES (791, 'medicine3');

INSERT INTO medicine_supstances (medicine_id, supstances) VALUES (789, 'supstance1');
INSERT INTO medicine_supstances (medicine_id, supstances) VALUES (790, 'supstance2');
INSERT INTO medicine_supstances (medicine_id, supstances) VALUES (791, 'supstance3');
INSERT INTO medicine_supstances (medicine_id, supstances) VALUES (791, 'supstance4');


INSERT INTO patient(id,jmbg) VALUES (789,'jmbg1');
INSERT INTO patient(id,jmbg) VALUES (790,'jmbg2');

INSERT INTO patient_allergies (patient_id,allergies) VALUES (789,'supstance1');
INSERT INTO patient_allergies (patient_id,allergies) VALUES (789,'supstance4');

INSERT INTO patient_allergies (patient_id,allergies) VALUES (790,'supstance2');
INSERT INTO patient_allergies (patient_id,allergies) VALUES (790,'supstance3');

INSERT INTO disease (id, disease_id, grupa) VALUES (789, 'prehlada','jedan');
INSERT INTO disease (id, disease_id, grupa) VALUES (790, 'groznica','jedan');
INSERT INTO disease (id, disease_id, grupa) VALUES (791, 'upala krajnika','jedan');
INSERT INTO disease (id, disease_id, grupa) VALUES (792, 'sinusna infekcija','jedan');
INSERT INTO disease (id, disease_id, grupa) VALUES (793, 'hipertenzija','dva');
INSERT INTO disease (id, disease_id, grupa) VALUES (794, 'dijabetes','dva');
INSERT INTO disease (id, disease_id, grupa) VALUES (795, 'hronicna bubrezna bolest','tri');
INSERT INTO disease (id, disease_id, grupa) VALUES (796, 'akutna bubrezna povreda','tri');

INSERT INTO symptom (id, symptom_id, disease) VALUES (789, 'curenje iz nosa','prehlada');
INSERT INTO symptom (id, symptom_id, disease) VALUES (790, 'bol u grlu','prehlada');
INSERT INTO symptom (id, symptom_id, disease) VALUES (791, 'glavobolja','prehlada');
INSERT INTO symptom (id, symptom_id, disease) VALUES (792, 'kijanje','prehlada');
INSERT INTO symptom (id, symptom_id, disease) VALUES (793, 'kasalj','prehlada');

INSERT INTO symptom (id, symptom_id, disease) VALUES (794, 'kijanje','groznica');
INSERT INTO symptom (id, symptom_id, disease) VALUES (795, 'bol u grlu','groznica');
INSERT INTO symptom (id, symptom_id, disease) VALUES (796, 'kasalj','groznica');
INSERT INTO symptom (id, symptom_id, disease) VALUES (797, 'temperatura > 38','groznica');
INSERT INTO symptom (id, symptom_id, disease) VALUES (798, 'curenje iz nosa','groznica');
INSERT INTO symptom (id, symptom_id, disease) VALUES (799, 'glavobolja','groznica');
INSERT INTO symptom (id, symptom_id, disease) VALUES (800, 'drhtavica','groznica');

INSERT INTO symptom (id, symptom_id, disease) VALUES (801, 'bol u grlu','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (802, 'bol koji se siri od usiju','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (803, 'glavobolja','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (804, 'temperatura 40-41','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (805, 'drhtavica','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (806, 'gubitak apetita','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (807, 'umor','upala krajnika');
INSERT INTO symptom (id, symptom_id, disease) VALUES (808, 'zuti sekret iz nosa','upala krajnika');

INSERT INTO symptom (id, symptom_id, disease) VALUES (809, 'oticanje oko ociju','sinusna infekcija');
INSERT INTO symptom (id, symptom_id, disease) VALUES (810, 'glavobolja','sinusna infekcija');
INSERT INTO symptom (id, symptom_id, disease) VALUES (811, 'zuti sekret iz nosa','sinusna infekcija');
INSERT INTO symptom (id, symptom_id, disease) VALUES (812, 'bol u grlu','sinusna infekcija');
INSERT INTO symptom (id, symptom_id, disease) VALUES (813, 'temperatura > 38','sinusna infekcija');
INSERT INTO symptom (id, symptom_id, disease) VALUES (814, 'kasalj','sinusna infekcija');

INSERT INTO symptom (id, symptom_id, disease) VALUES (815, 'cesto uriniranje','dijabetes');
INSERT INTO symptom (id, symptom_id, disease) VALUES (816, 'gubitak telesne tezine','dijabetes');
INSERT INTO symptom (id, symptom_id, disease) VALUES (817, 'zamor','dijabetes');
INSERT INTO symptom (id, symptom_id, disease) VALUES (818, 'mucnina i povracanje','dijabetes');

INSERT INTO symptom (id, symptom_id, disease) VALUES (819, 'zamor','hronicna bubrezna bolest');
INSERT INTO symptom (id, symptom_id, disease) VALUES (820, 'nocturia','hronicna bubrezna bolest');
INSERT INTO symptom (id, symptom_id, disease) VALUES (821, 'otoci nogu i zglobova','hronicna bubrezna bolest');
INSERT INTO symptom (id, symptom_id, disease) VALUES (822, 'gusenje','hronicna bubrezna bolest');
INSERT INTO symptom (id, symptom_id, disease) VALUES (823, 'bol u grudima','hronicna bubrezna bolest');
INSERT INTO symptom (id, symptom_id, disease) VALUES (824, 'gusenje','hronicna bubrezna bolest');

