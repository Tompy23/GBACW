

delete from leader;
DELETE FROM side_type;
delete from state_type
DELETE FROM status_type;
DELETE FROM orders_type;
DELETE FROM leader_type;


delete from turn_activation;
delete from turn_ampool;
delete from turn_efficiency;
delete from turn_initiative;
delete from turn;
delete from activation_brigade;
delete from game;
delete from game_leader;
delete from game_player


#Side Types

INSERT INTO side_type VALUES (1, 'USA');
INSERT INTO side_type VALUES (2, 'CSA');

#State Types

INSERT INTO state_type VALUES (10, 'GAME_TURN');
INSERT INTO state_type VALUES (20, 'GAME_STARTTURN');
INSERT INTO state_type VALUES (25, 'GAME_STARTTURN_INITIATIVE');
INSERT INTO state_type VALUES (30, 'GAME_ACTIVATION');
INSERT INTO state_type VALUES (40, 'ACTIVATION_ACTIVE');
INSERT INTO state_type VALUES (50, 'ACTIVATION_INACTIVE');

#Status Types

INSERT INTO status_type VALUES (1, 'Ok');
INSERT INTO status_type VALUES (2, 'Disordered');
INSERT INTO status_type VALUES (3, 'Collapsed');
INSERT INTO status_type VALUES (4, 'Routed');
INSERT INTO status_type VALUES (5, 'Eliminated');

#Orders Type

INSERT INTO orders_type VALUES (1, 'March');
INSERT INTO orders_type VALUES (2, 'Advance');
INSERT INTO orders_type VALUES (3, 'Attack');

#Leader Type

INSERT INTO leader_type VALUES (1, 'Overall');
INSERT INTO leader_type VALUES (2, 'Corps');
INSERT INTO leader_type VALUES (3, 'Division');
INSERT INTO leader_type VALUES (4, 'Brigade');

INSERT INTO leader (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, initiativeRating, replacementName) VALUES (1, 1, 1, 'Meade', '****', 'Lee_front.png', 'Lee_back.png', 15, 0, 'Meade');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (86, 1, 2, 'Buford (Corps)', '1 Cav', 'Buford_front.png', 'Buford_back.png', 0, 1, 0, 'Gamble', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (87, 1, 3, 'Buford', '1 Cav', 'Buford_front.png', 'Buford_back.png', 0, 86, 1, 'Gamble', 0, 'Buford_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (88, 1, 4, 'Gamble', '1/1/C', 'Gamble_front.png', 'Gamble_back.png', 0, 87, 'Gamble Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (89, 1, 4, 'Devin', '2/1/C', 'Devin_front.png', 'Devin_back.png', 0, 87, 'Devin Repl');

#CSA
#OC
INSERT INTO leader (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, initiativeRating, replacementName) VALUES (1001, 2, 1, 'Lee', '****', 'Lee_front.png', 'Lee_back.png', 7, 1, 'Meade');

#Corps
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1004, 2, 2, 'AP Hill', 'III Corps', 'AP_Hill_front.png', 'AP_Hill_back.png', 4, 1001, 0, 'Anderson', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1005, 2, 2, 'Ewell', 'II Corps', 'Ewell_front.png', 'Ewell_back.png', 7, 1001, 0, 'G. Anderson', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1006, 2, 2, 'Longstreet', 'I Corps', 'Longstreet_front.png', 'Longstreet_back.png', 10, 1001, 1, 'Hood', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1007, 2, 2, 'Pendleton', 'Artillery', 'Pendleton_front.png', 'Pendleton_back.png', 7, 1001, -2, 'Alexander', -2);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1020, 2, 2, 'Stuart Corps', 'Cav Corps', 'Stuart_front.png', 'Stuart_back.png', 25, 1001, 0, 'F. Lee', 0);

#Division
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1002, 2, 3, 'Heth', 'He/III', 'Heth_front.png', 'Heth_back.png', 0, 1004, 0, 'Pettigrew', 0, 'Heth_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1008, 2, 3, 'Pender', 'Pn/III', 'Pender_front.png', 'Pender_back.png', 11, 1004, 1, 'Perrin', 0, 'Pender_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1009, 2, 3, 'R. Anderson', 'An/III', 'R_Anderson_front.png', 'R_Anderson_back.png', 10, 1004, 0, 'Wilcox', 0, 'R_Anderson_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1011, 2, 3, 'Johnson', 'Jn/II', 'Johnson_front.png', 'Johnson_back.png', 12, 1005, 0, 'Walker', 0, 'Johnson_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1012, 2, 3, 'Early', 'Ea/II', 'Early_front.png', 'Early_back.png', 8, 1005, 1, 'Hays', 0, 'Early_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1013, 2, 3, 'Rodes', 'Rd/II', 'Rodes_front.png', 'Rodes_back.png', 6, 1005, 0, 'Daniel', 0, 'Rodes_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1015, 2, 3, 'Hood', 'Hd/I', 'Hood_front.png', 'Hood_back.png', 17, 1006, 1, 'Law', 1, 'Hood_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1016, 2, 3, 'McLaws', 'Mc/I', 'McLaws_front.png', 'McLaws_back.png', 18, 1006, 1, 'Kershaw', 0, 'McLaws_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1017, 2, 3, 'Picket', 'Pk/I', 'Picket_front.png', 'Picket_back.png', 26, 1006, 1, 'Armstead', 0, 'Picket_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1019, 2, 3, 'Stuart', 'Cav', 'Stuart_front.png', 'Stuart_back.png', 25, 1020, 2, 'F. Lee', 1, 'Stuart_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1031, 2, 3, 'Pegram', 'III/ArtyRes', 'Pegram_front.png', 'Pegram_back.png', 0, 1007, 0, 'Pegram Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1010, 2, 3, 'McIntosh', 'III/ArtRes', 'McIntosh_c_front.png', 'McIntosh_c_back.png', 5, 1004, 0, 'McIntosh Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1014, 2, 3, 'Dance', 'II/ArtyRes', 'Dance_front.png', 'Dance_back.png', 12, 1005, 0, 'Dance Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1035, 2, 3, 'Nelson', 'II/ArtyRes', 'Nelson_front.png', 'Nelson_back.png', 12, 1005, 0, 'Nelson Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1018, 2, 3, 'Alexander', 'I ArtRes', 'Alexander_front.png', 'Alexander_back.png', 19, 1006, 0, 'Alexander Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1036, 2, 3, 'Eschelman', 'I ArtRes', 'Eschelman_front.png', 'Eschelman_back.png', 19, 1006, 0, 'Eschelman Repl', 0, null);

#Brigade
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1003, 2, 4, 'Pegram', 'III/ArtyRes', 'Pegram_front.png', 'Pegram_back.png', 0, 1031, 'Pegram Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1037, 2, 4, 'McIntosh', 'III/ArtyRes', 'McIntosh_c_front.png', 'McIntosh_c_back.png', 5, 1010, 'McIntosh Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1038, 2, 4, 'Dance', 'II/ArtyRes', 'Dance_front.png', 'Dance_back.png', 12, 1014, 'Dance Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1039, 2, 4, 'Nelson', 'II/ArtyRes', 'Nelson_front.png', 'Nelson_back.png', 12, 1035, 'Nelson Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1040, 2, 4, 'Alexander', 'I/ArtyRes', 'Alexander_front.png', 'Alexander_back.png', 19, 1018, 'Alexander Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1041, 2, 4, 'Eschelman', 'I/ArtyRes', 'Eschelman_front.png', 'Eschelman_back.png', 19, 1036, 'Eschelman Repl');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1021, 2, 4, 'Pettigrew', '1/He/III', 'Pettigrew_front.png', 'Pettigrew_back.png', 2, 1002, 'Pettigrew Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1022, 2, 4, 'Breckenbrough', '2/He/III', 'Breckenbrough_front.png', 'Breckenbrough_back.png', 2, 1002, 'Breckenbrough Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1023, 2, 4, 'Archer', '3/He/III', 'Archer_front.png', 'Archer_back.png', 0, 1002, 'Archer Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1024, 2, 4, 'Davis', '4/He/III', 'Davis_front.png', 'Davis_back.png', 0, 1002, 'Davis Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1025, 2, 4, 'Garnett', 'He/III/Art', 'Garnett_front.png', 'Garnett_back.png', 0, 1002, 'Garnett Repl');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1026, 2, 4, 'Perrin', '1/Pn/III', 'Perrin_front.png', 'Perrin_back.png', 5, 1008, 'Perrin Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1027, 2, 4, 'Jm. Lane', '2/Pn/III', 'Jm_Lane_front.png', 'Jm_Lane_back.png', 5, 1008, 'Jm. Lane Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1028, 2, 4, 'Thomas', '3/Pn/III', 'Thomas_front.png', 'Thomas_back.png', 5, 1008, 'Thomas Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1029, 2, 4, 'Scales', '4/Pn/III', 'Scales_front.png', 'Scales_back.png', 5, 1008, 'Scales Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1030, 2, 4, 'Poague', 'Pn/III/Art', 'Poague_front.png', 'Poague_back.png', 6, 1008, 'Poague Repl');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1032, 2, 4, 'Wilcox', '1/An/III', 'Wilcox_front.png', 'Wilcox_back.png', 10, 1009, 'Wilcox Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1033, 2, 4, 'Mahone', '2/An/III', 'Mahone_front.png', 'Mahone_back.png', 10, 1009, 'Mahone Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1042, 2, 4, 'Wright', '3/An/III', 'Wright_front.png', 'Wright_back.png', 10, 1009, 'Wright Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1043, 2, 4, 'Lang', '4/An/III', 'Lang_front.png', 'Lang_back.png', 10, 1009, 'Lang Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1044, 2, 4, 'Posey', '5/An/III', 'Posey_front.png', 'Posey_back.png', 10, 1009, 'Posey Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1045, 2, 4, 'Jn. Lane', 'An/III/Art', 'Jn_Lane_front.png', 'Jn_Lane_back.png', 10, 1009, 'Jn. Lane Repl');











########################################################################################





#Side Types
DELETE FROM side_type;
INSERT INTO side_type VALUES (1, 'USA');
INSERT INTO side_type VALUES (2, 'CSA');

#Status Types
DELETE FROM status_type;
INSERT INTO status_type VALUES (1, 'Ok');
INSERT INTO status_type VALUES (2, 'Disordered');
INSERT INTO status_type VALUES (3, 'Collapsed');
INSERT INTO status_type VALUES (4, 'Routed');
INSERT INTO status_type VALUES (5, 'Eliminated');

#Orders Type
DELETE FROM orders_type;
INSERT INTO orders_type VALUES (1, 'March');
INSERT INTO orders_type VALUES (2, 'Advance');
INSERT INTO orders_type VALUES (3, 'Attack');

#Leader Type
DELETE FROM leader_type;
INSERT INTO leader_type VALUES (1, 'Overall');
INSERT INTO leader_type VALUES (2, 'Corps');
INSERT INTO leader_type VALUES (3, 'Division');
INSERT INTO leader_type VALUES (4, 'Brigade');

#Leaders
#ID, Side, LeaderType, Name, Identifier, FrontImage, BackImage, TurnOfEntry, SuperiorId, ActivationRating(div), EfficiencyRating(corps), InitiativeRating(OC), #ReplacementName, ReplacementActivationRating, ReplacementEfficiencyRating, AMImage

DELETE FROM leader;
#USA
INSERT INTO leader VALUES (1, 1, 1, 'Meade', '****', 'Meade_front.png', 'Meade_back.png', 15, null, null, null, 0, 'Meade', null, null);


INSERT INTO leader VALUES (2, 1, 2, 'Reynolds', 'I Corps', 'Reynolds_front.png', 'Reynolds_back.png', 2, 1, null, 1, null, 'Doubleday', null, 0);
INSERT INTO leader VALUES (3, 1, 3, 'Wadsworth', '1/I', 'Wadsworth_front.png', 'Wadsworth_back.png', 2, 2, 1, null, null, 'Meredith', 1, null, 'Wadsworth_AM.png');
INSERT INTO leader VALUES (4, 1, 4, 'Meredith', '1/1/I', 'Meredith_front.png', 'Meredith_back.png', 2, 3, null, null, null, 'Meredith Repl', null, null);
INSERT INTO leader VALUES (5, 1, 4, 'Cutler', '2/1/I', 'Cutler_front.png', 'Cutler_back.png', 2, 3, null, null, null, 'Cutler Repl', null, null);


INSERT INTO leader VALUES (6, 1, 3, 'Robinson', '2/I', 'Robinson_front.png', 'Robinson_back.png', 3, 2, l, null, null, 'Paul', null, null, 'Robinson_AM.png');
INSERT INTO leader VALUES (7, 1, 4, 'Paul', '1/2/I', 'Paul_front.png', 'Paul_back.png', 3, 6, null, null, null, 'Paul Repl', null, null);
INSERT INTO leader VALUES (8, 1, 4, 'Baxter', '2/2/I', 'Baxter_front.png', 'Baxter_back.png', 3, 6, null, null, null, 'Cutler Repl', null, null);

INSERT INTO leader VALUES (9, 1, 3, 'Doubleday', '3/I', 'Doubleday_front.png', 'Doubleday_back.png', 3, 2, 1, null, null, 'Rowley', 0, null, 'Doubleday_AM.png');
INSERT INTO leader VALUES (10, 1, 4, 'Rowley', '1/3/I', 'Rowley_front.png', 'Rowley_back.png', 2, 9, null, null, null, 'Rowley Repl', null, null);
INSERT INTO leader VALUES (11, 1, 4, 'Stone', '2/3/I', 'Stone_front.png', 'Stone_back.png', 2, 9, null, null, null, 'Stone Repl', null, null);

INSERT INTO leader VALUES (12, 1, 4, 'Stannard', '3/3/I', 'Stannard_front.png', 'Stannard_back.png', 13, 9, null, null, null, 'Stannard Repl', null, null);

INSERT INTO leader VALUES (13, 1, 4, 'Wainwright', 'I Arty', 'Wainwright_front.png', 'Wainwright_back.png', 2, 3, null, null, null, 'Wainwright Repl', null, null);

INSERT INTO leader VALUES (14, 1, 2, 'Hancock', 'II Corps', 'Hancock_front.png', 'Hancock_back.png',17, 1, null, 1, null, 'Caldwell', null, 0);
INSERT INTO leader VALUES (15, 1, 3, 'Caldwell', '1/II', 'Caldwell_front.png', 'Caldwell_back.png', 17, 14, 1, null, null, 'Cross', 0, null, 'Caldwell_AM.png'); 
INSERT INTO leader VALUES (16, 1, 4, 'Cross', '1/1/II', 'Cross_front.png', 'Cross_back.png', 17,15, null, null, null, 'Cross Repl', null, null);
INSERT INTO leader VALUES (17, 1, 4, 'Kelly', '2/1/II', 'Kelly_front.png', 'Kelly_back.png', 17, 15, null, null, null, 'Kelly Repl', null, null);   

INSERT INTO leader VALUES (18, 1, 4, 'Zook', '3/1/II', 'Zook_front.png', 'Zook_back.png', 17,15, null, null, null, 'Zook Repl', null, null);
INSERT INTO leader VALUES (19, 1, 4, 'Brooke', '4/1/I', 'Brooke_front.png', 'Brooke_back.png', 17, 15, null, null, null, 'Brooke Repl', null, null);             

 

     

INSERT INTO leader VALUES (20, 1, 3, 'Gibbon', '2/II', 'Gibbon_front.png', 'Gibbon_back.png', 17, 14, 2, null, null, 'Harrow', 0, null, 'Gibbon_AM.png'); 
INSERT INTO leader VALUES (21, 1, 4, 'Harrow', '1/2/II', 'Harrow_front.png', 'Harrow_back.png', 17,20, null, null, null, 'Harrow Repl', null, null);
INSERT INTO leader VALUES (22, 1, 4, 'Webb', '2/2/II', 'Webb_front.png', 'Webb_back.png', 17, 20, null, null, null, 'Webb Repl', null, null);   

INSERT INTO leader VALUES (23, 1, 4, 'Hall', '3/2/II', 'Hall_front.png', 'Hall_back.png', 17, 20, null, null, null, 'Hall Repl', null, null);

 

INSERT INTO leader VALUES (24, 1, 3, 'Hays', '3/II', 'Hays_front.png', 'Hays_back.png', 17, 14,1, null, null, 'Carroll', 0, null, 'Hays_AM.png'); 
INSERT INTO leader VALUES (25, 1, 4, 'Carroll', '1/3/II', 'Carroll_front.png', 'Carroll_back.png', 17,24, null, null, null, 'Carroll Repl', null, null);
INSERT INTO leader VALUES (26, 1, 4, 'Smyth', '2/3/II', 'Smyth_front.png', 'Smyth_back.png', 17, 24, null, null, null, 'Smyth Repl', null, null);   

INSERT INTO leader VALUES (27, 1, 4, 'Willard', '3/3/II', 'Willard_front.png', 'Willard_back.png', 17, 24, null, null, null, 'Willard Repl', null, null);


INSERT INTO leader VALUES (28, 1, 4, 'Hazard', 'II Arty', 'Hazard_front.png', 'Hazard_back.png', 17, 15, null, null, null, 'Hazard Repl', null, null);

 

 

INSERT INTO leader VALUES (29, 1, 2, 'Sickles', 'III Corps', 'Sickles_front.png', 'Sickles_back.png', 12, 1, null, 0, null, 'Birney', null, -1);

 

INSERT INTO leader VALUES (30, 1, 3, 'Birney', '1/III', 'Birney_front.png', 'Birney_back.png', 12, 29, -1, null, null, 'Graham', 1, null, 'Birney_AM.png');

INSERT INTO leader VALUES (31, 1, 4, 'Graham', '1/1/III', 'Graham_front.png', 'Graham_back.png', 12, 30, null, null, null, 'Graham Repl', null, null);

 INSERT INTO leader VALUES (32, 1, 4, 'Ward', '2/1/III', 'Ward_front.png', 'Ward_back.png', 12, 30, null, null, null, 'Ward Repl', null, null);

INSERT INTO leader VALUES (33, 1, 4, 'deTrbrnd', '3/1/III', 'deTrbrnd_front.png', 'deTrbrnd_back.png', 12, 30, null, null, null, 'deTrbrnd Repl', null, null);

 

INSERT INTO leader VALUES (34, 1, 3, 'Humphreys', '2/III', 'Humphreys_front.png', 'Humphreys_back.png', 14, 29, 1, null, null, 'Carr', 0, null, 'Humphreys_AM.png');

INSERT INTO leader VALUES (35, 1, 4, 'Carr', '1/2/III', 'Carr_front.png', 'Carr_back.png', 14, 34, null, null, null, 'Carr Repl', null, null);

 INSERT INTO leader VALUES (36, 1, 4, 'Brewster', '2/2/III', 'Ward_front.png', 'Ward_back.png', 14, 34, null, null, null, 'Brewster Repl', null, null);

INSERT INTO leader VALUES (37, 1, 4, 'Burling', '3/2/III', 'Burling_front.png', 'Burling_back.png', 14, 34, null, null, null, 'Burling Repl', null, null);

 

INSERT INTO leader VALUES (38, 1, 4, 'Randolph', 'III Arty', 'Randolph_front.png', 'Randolph_back.png', 20, 34, null, null, null, 'Randolph_Repl', null, null);

 

 

INSERT INTO leader VALUES (39, 1, 2, 'Sykes', 'V Corps', 'Sykes_front.png', 'Sykes_back.png', 20, 1, null, 0, null, 'Crawford', null, 0);

 

INSERT INTO leader VALUES (40, 1, 3, 'Barnes', '1/V', 'Barnes_front.png', 'Barnes_back.png', 20, 39, 0, null, null, 'Tilton', 0, null, 'Barnes_AM.png');

INSERT INTO leader VALUES (41, 1, 4, 'Tilton', '1/1/V', 'Tilton_front.png', 'Tilton_back.png', 20, 40, null, null, null, 'Tilton Repl', null, null);

 INSERT INTO leader VALUES (42, 1, 4, 'Sweitzer', '2/1/V', 'Sweitzer_front.png', 'Sweitzer_back.png', 20, 40, null, null, null, 'Sweitzer Repl', null, null);

INSERT INTO leader VALUES (43, 1, 4, 'Vincent', '3/1/V', 'Vincent_front.png', 'Vincent_back.png', 20, 40, null, null, null, 'Vincent Repl', null, null);

 

INSERT INTO leader VALUES (44, 1, 3, 'Ayres', '2/V', 'Ayres_front.png', 'Ayres_back.png', 20, 39, 1, null, null, 'Day', 0, null, 'Ayres_AM.png');

INSERT INTO leader VALUES (45, 1, 4, 'Day', '1/2/V', 'Day_front.png', 'Day_back.png', 20, 44, null, null, null, 'Day Repl', null, null);

 INSERT INTO leader VALUES (46, 1, 4, 'Burbank', '2/2/V', 'Burbank_front.png', 'Burbank_back.png', 20, 44, null, null, null, 'Burbank Repl', null, null);

INSERT INTO leader VALUES (47, 1, 4, 'Weed', '3/2/V', 'Weed_front.png', 'Weed_back.png', 20, 44, null, null, null, 'Weed Repl', null, null);

 

INSERT INTO leader VALUES (48, 1, 3, 'Crawford', '3/V', 'Crawford_front.png', 'Crawford_back.png', 24, 39, 1, null, null, 'McCandless', 0, null, 'Crawford_AM.png');

INSERT INTO leader VALUES (49, 1, 4, 'McCandless', '1/3/V', 'McCandless_front.png', 'McCandless_back.png', 24, 48, null, null, null, 'McCandless Repl', null, null);

 INSERT INTO leader VALUES (50, 1, 4, 'Fischer', '3/3/V', 'Fischer_front.png', 'Fischer_back.png', 24, 48, null, null, null, 'Fischer Repl', null, null);

 

INSERT INTO leader VALUES (51, 1, 4, 'Martin', 'V Arty', 'Martin_front.png', 'Martin_back.png', 20, 41, null, null, null, 'Martin Repl', null, null);

 

 

INSERT INTO leader VALUES (52, 1, 2, 'Sedwick', 'VI Corps', 'Sedwick_front.png', 'Sedwick_back.png', 27, 1, null, 0, null, 'Wright', null, 0);

 

INSERT INTO leader VALUES (53, 1, 3, 'Wright', '1/VI', 'Wright_front.png', 'Wright_back.png', 27, 52, 1, null, null, 'Torbert', 1, null, 'Wright_AM.png');

INSERT INTO leader VALUES (54, 1, 4, 'Torbert', '1/1/VI', 'Torbert_front.png', 'Torbert_back.png', 27, 53, null, null, null, 'Torbert Repl', null, null);

 INSERT INTO leader VALUES (55, 1, 4, 'Bartlett', '2/1/VI', 'Bartlett_front.png', 'Bartlett_back.png', 27, 53, null, null, null, 'Bartlett Repl', null, null);

INSERT INTO leader VALUES (56, 1, 4, 'Russell', '3/1/VI', 'Russell_front.png', 'Russell_back.png', 27, 53, null, null, null, 'Russell Repl', null, null);

 

INSERT INTO leader VALUES (57, 1, 3, 'Howe', '2/VI', 'Howe_front.png', 'Howe_back.png', 27, 52, 0, null, null, 'Grant', 0, null, 'Howe_AM.png');

INSERT INTO leader VALUES (58, 1, 4, 'Grant', '2/2/VI', 'Grant_front.png', 'Grant_back.png', 27, 57, null, null, null, 'Grant Repl', null, null);

 INSERT INTO leader VALUES (59, 1, 4, 'Neill', '3/2/VI', 'Neill_front.png', 'Neill_back.png', 27, 57, null, null, null, 'Neill Repl', null, null);

 

INSERT INTO leader VALUES (60, 1, 3, 'Newton', '3/VI', 'Newton_front.png', 'Newton_back.png', 27, 52, 1, null, null, 'Shaler', 0, null, 'Newton_AM.png');

INSERT INTO leader VALUES (61, 1, 4, 'Shaler', '1/3/VI', 'Shaler_front.png', 'Shaler_back.png', 27, 60, null, null, null, 'Shaler Repl', null, null);

 INSERT INTO leader VALUES (62, 1, 4, 'Eustis', '2/3/VI', 'Eustis_front.png', 'Eustis_back.png', 27, 60, null, null, null, 'Eustis Repl', null, null);

INSERT INTO leader VALUES (63, 1, 4, 'Wheaton', '3/3/VI', 'Wheaton_front.png', 'Wheaton_back.png', 27, 60, null, null, null, 'Wheaton Repl', null, null);

 

INSERT INTO leader VALUES (64, 1, 4, 'Tompkins', 'VI Arty', 'Tompkins_front.png', 'Tompkins_back.png', 27, 53, null, null, null, 'Tompkins Repl', null, null);

 

 

INSERT INTO leader VALUES (65, 1, 2, 'Howard', 'XI Corps', 'Howard_front.png', 'Howard_back.png', 5, 1, null, 0, null, 'Barlow', null, -1);

 

INSERT INTO leader VALUES (66, 1, 3, 'Barlow', '1/XI', 'Barlow_front.png', 'Barlow_back.png', 5, 65, 1, null, null, 'v.Gilsa', 0, null, 'Barlow_AM.png');

INSERT INTO leader VALUES (67, 1, 4, 'v.Gilsa', '1/1/XI', 'vGilsa_front.png', 'vGilsa_back.png', 5, 66, null, null, null, 'v.Gilsa Repl', null, null);

 INSERT INTO leader VALUES (68, 1, 4, 'Ames', '2/1/XI', 'Ames_front.png', 'Ames_back.png', 5, 66, null, null, null, 'Ames Repl', null, null);

 

INSERT INTO leader VALUES (69, 1, 3, 'von Steinwehr', '2/XI', 'vonSteinwehr_front.png', 'vonSteinwehr_back.png', 5, 65, 1, null, null, 'Coster', 0, null, 'Steinwehr_AM.png');

INSERT INTO leader VALUES (70, 1, 4, 'Coster', '1/2/XI', 'Coster_front.png', 'Coster_back.png', 5, 69, null, null, null, 'Coster Repl', null, null);

 INSERT INTO leader VALUES (71, 1, 4, 'O. Smith', '2/2/XI', 'OSmith_front.png', 'OSmith_back.png', 5, 69, null, null, null, 'O. Smith Repl', null, null);

 

INSERT INTO leader VALUES (72, 1, 3, 'Schurz', '3/XI', 'Schurz_front.png', 'Schurz_back.png', 5, 65, 0, null, null, 'Schimmlfennig', 0, null, 'Schurz_AM.png');

INSERT INTO leader VALUES (73, 1, 4, 'Schimmelfenning', '1/3/XI', 'Schimmelfenning_front.png', 'Schimmelfenning_back.png', 5, 72, null, null, null, 'Schimmelfenning Repl', null, null);

 INSERT INTO leader VALUES (74, 1, 4, 'Krzyuzanowski', '2/3/XI', 'Krzynwski_front.png', 'Krzynwski_back.png', 5, 72, null, null, null, 'Krzynwski Repl', null, null);

 

INSERT INTO leader VALUES (75, 1, 4, 'Osborn', 'XI Arty', 'Osborn_front.png', 'Osborn_back.png', 5, 66, null, null, null, 'Osborn Repl', null, null);

 

INSERT INTO leader VALUES (76, 1, 2, 'Slocum', 'XII Corps', 'Slocum_front.png', 'Slocum_back.png', 11, 1, null, 0, null, 'Williams', null, 0);

 

INSERT INTO leader VALUES (77, 1, 3, 'Williams', '1/XII', 'Williams_front.png', 'Williams_back.png', 27, 76, 1, null, null, 'McDougall', 0, null, 'Williams_AM.png');

INSERT INTO leader VALUES (78, 1, 4, 'McDougall', '1/1/XII', 'McDougall_front.png', 'MCDougall_back.png', 27, 77, null, null, null, 'McDougall Repl', null, null);

 INSERT INTO leader VALUES (79, 1, 4, 'Lockwood', '2/1/XII', 'Lockwood_front.png', 'Lockwood_back.png', 27, 77, null, null, null, 'Lockwood Repl', null, null);

INSERT INTO leader VALUES (80, 1, 4, 'Ruger', '3/1/XII', 'Ruger_front.png', 'Ruger_back.png', 27, 77, null, null, null, 'Ruger Repl', null, null);

 

INSERT INTO leader VALUES (81, 1, 3, 'Geary', '2/XII', 'Geary_front.png', 'Geary_back.png', 27, 76, 0, null, null, 'Candy', 0, null, 'Geary_AM.png');

INSERT INTO leader VALUES (82, 1, 4, 'Candy', '1/2/XII', 'Candy_front.png', 'Candy_back.png', 27, 81, null, null, null, 'Candy Repl', null, null);

 INSERT INTO leader VALUES (83, 1, 4, 'Kane', '2/2/XII', 'Kane_front.png', 'Kane_back.png', 27, 81, null, null, null, 'Kane Repl', null, null);

INSERT INTO leader VALUES (84, 1, 4, 'Greene', '3/2/XII', 'Greene_front.png', 'Greene_back.png', 27, 81, null, null, null, 'Greene Repl', null, null);

 

INSERT INTO leader VALUES (85, 1, 4, 'Muhlenberg', 'XII Arty', 'Muhlenberg_front.png', 'Muhlenberg_back.png', 27, 77, null, null, null, 'Muhlenberg Repl', null, null);


#Atstart
INSERT INTO leader (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, initiativeRating, replacementName) VALUES (1, 1, 1, 'Meade', '****', 'Lee_front.png', 'Lee_back.png', 15, 0, 'Meade');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (86, 1, 2, 'Buford (Corps)', '1 Cav', 'Buford_front.png', 'Buford_back.png', 0, 1, 0, 'Gamble', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (87, 1, 3, 'Buford', '1 Cav', 'Buford_front.png', 'Buford_back.png', 0, 86, 1, 'Gamble', 0, 'Buford_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (88, 1, 4, 'Gamble', '1/1/C', 'Gamble_front.png', 'Gamble_back.png', 0, 87, 'Gamble Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (89, 1, 4, 'Devin', '2/1/C', 'Devin_front.png', 'Devin_back.png', 0, 87, 'Devin Repl');

#CSA
#OC
INSERT INTO leader (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, initiativeRating, replacementName) VALUES (1001, 2, 1, 'Lee', '****', 'Lee_front.png', 'Lee_back.png', 7, 1, 'Meade');

#Corps
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1004, 2, 2, 'AP Hill', 'III Corps', 'AP_Hill_front.png', 'AP_Hill_back.png', 4, 1001, 0, 'Anderson', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1005, 2, 2, 'Ewell', 'II Corps', 'Ewell_front.png', 'Ewell_back.png', 7, 1001, 0, 'G. Anderson', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1006, 2, 2, 'Longstreet', 'I Corps', 'Longstreet_front.png', 'Longstreet_back.png', 10, 1001, 1, 'Hood', 0);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1007, 2, 2, 'Pendleton', 'Artillery', 'Pendleton_front.png', 'Pendleton_back.png', 7, 1001, -2, 'Alexander', -2);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, efficiencyRating, replacementName, replacementEfficiencyRating) VALUES (1020, 2, 2, 'Stuart Corps', 'Cav Corps', 'Stuart_front.png', 'Stuart_back.png', 25, 1001, 0, 'F. Lee', 0);

#Division
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1002, 2, 3, 'Heth', 'He/III', 'Heth_front.png', 'Heth_back.png', 0, 1004, 0, 'Pettigrew', 0, 'Heth_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1008, 2, 3, 'Pender', 'Pn/III', 'Pender_front.png', 'Pender_back.png', 11, 1004, 1, 'Perrin', 0, 'Pender_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1009, 2, 3, 'R. Anderson', 'An/III', 'R_Anderson_front.png', 'R_Anderson_back.png', 10, 1004, 0, 'Wilcox', 0, 'R_Anderson_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1011, 2, 3, 'Johnson', 'Jn/II', 'Johnson_front.png', 'Johnson_back.png', 12, 1005, 0, 'Walker', 0, 'Johnson_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1012, 2, 3, 'Early', 'Ea/II', 'Early_front.png', 'Early_back.png', 8, 1005, 1, 'Hays', 0, 'Early_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1013, 2, 3, 'Rodes', 'Rd/II', 'Rodes_front.png', 'Rodes_back.png', 6, 1005, 0, 'Daniel', 0, 'Rodes_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1015, 2, 3, 'Hood', 'Hd/I', 'Hood_front.png', 'Hood_back.png', 17, 1006, 1, 'Law', 1, 'Hood_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1016, 2, 3, 'McLaws', 'Mc/I', 'McLaws_front.png', 'McLaws_back.png', 18, 1006, 1, 'Kershaw', 0, 'McLaws_AM.png');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1017, 2, 3, 'Picket', 'Pk/I', 'Picket_front.png', 'Picket_back.png', 26, 1006, 1, 'Armstead', 0, 'Picket_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1019, 2, 3, 'Stuart', 'Cav', 'Stuart_front.png', 'Stuart_back.png', 25, 1020, 2, 'F. Lee', 1, 'Stuart_AM.png');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1031, 2, 3, 'Pegram', 'III/ArtyRes', 'Pegram_front.png', 'Pegram_back.png', 0, 1007, 0, 'Pegram Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1010, 2, 3, 'McIntosh', 'III/ArtRes', 'McIntosh_c_front.png', 'McIntosh_c_back.png', 5, 1004, 0, 'McIntosh Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1014, 2, 3, 'Dance', 'II/ArtyRes', 'Dance_front.png', 'Dance_back.png', 12, 1005, 0, 'Dance Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1035, 2, 3, 'Nelson', 'II/ArtyRes', 'Nelson_front.png', 'Nelson_back.png', 12, 1005, 0, 'Nelson Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1018, 2, 3, 'Alexander', 'I ArtRes', 'Alexander_front.png', 'Alexander_back.png', 19, 1006, 0, 'Alexander Repl', 0, null);
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, activationRating, replacementName, replacementActivationRating, imageNameAM) VALUES (1036, 2, 3, 'Eschelman', 'I ArtRes', 'Eschelman_front.png', 'Eschelman_back.png', 19, 1006, 0, 'Eschelman Repl', 0, null);

#Brigade
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1003, 2, 4, 'Pegram', 'III/ArtyRes', 'Pegram_front.png', 'Pegram_back.png', 0, 1031, 'Pegram Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1037, 2, 4, 'McIntosh', 'III/ArtyRes', 'McIntosh_c_front.png', 'McIntosh_c_back.png', 5, 1010, 'McIntosh Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1038, 2, 4, 'Dance', 'II/ArtyRes', 'Dance_front.png', 'Dance_back.png', 12, 1014, 'Dance Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1039, 2, 4, 'Nelson', 'II/ArtyRes', 'Nelson_front.png', 'Nelson_back.png', 12, 1035, 'Nelson Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1040, 2, 4, 'Alexander', 'I/ArtyRes', 'Alexander_front.png', 'Alexander_back.png', 19, 1018, 'Alexander Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1041, 2, 4, 'Eschelman', 'I/ArtyRes', 'Eschelman_front.png', 'Eschelman_back.png', 19, 1036, 'Eschelman Repl');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1021, 2, 4, 'Pettigrew', '1/He/III', 'Pettigrew_front.png', 'Pettigrew_back.png', 2, 1002, 'Pettigrew Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1022, 2, 4, 'Breckenbrough', '2/He/III', 'Breckenbrough_front.png', 'Breckenbrough_back.png', 2, 1002, 'Breckenbrough Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1023, 2, 4, 'Archer', '3/He/III', 'Archer_front.png', 'Archer_back.png', 0, 1002, 'Archer Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1024, 2, 4, 'Davis', '4/He/III', 'Davis_front.png', 'Davis_back.png', 0, 1002, 'Davis Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1025, 2, 4, 'Garnett', 'He/III/Art', 'Garnett_front.png', 'Garnett_back.png', 0, 1002, 'Garnett Repl');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1026, 2, 4, 'Perrin', '1/Pn/III', 'Perrin_front.png', 'Perrin_back.png', 5, 1008, 'Perrin Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1027, 2, 4, 'Jm. Lane', '2/Pn/III', 'Jm_Lane_front.png', 'Jm_Lane_back.png', 5, 1008, 'Jm. Lane Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1028, 2, 4, 'Thomas', '3/Pn/III', 'Thomas_front.png', 'Thomas_back.png', 5, 1008, 'Thomas Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1029, 2, 4, 'Scales', '4/Pn/III', 'Scales_front.png', 'Scales_back.png', 5, 1008, 'Scales Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1030, 2, 4, 'Poague', 'Pn/III/Art', 'Poague_front.png', 'Poague_back.png', 6, 1008, 'Poague Repl');

INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1032, 2, 4, 'Wilcox', '1/An/III', 'Wilcox_front.png', 'Wilcox_back.png', 10, 1009, 'Wilcox Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1033, 2, 4, 'Mahone', '2/An/III', 'Mahone_front.png', 'Mahone_back.png', 10, 1009, 'Mahone Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1042, 2, 4, 'Wright', '3/An/III', 'Wright_front.png', 'Wright_back.png', 10, 1009, 'Wright Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1043, 2, 4, 'Lang', '4/An/III', 'Lang_front.png', 'Lang_back.png', 10, 1009, 'Lang Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1044, 2, 4, 'Posey', '5/An/III', 'Posey_front.png', 'Posey_back.png', 10, 1009, 'Posey Repl');
INSERT INTO leader  (id, sideId, typeId, name, identifier, imageNameFront, imageNameBack, turnOfEntry, superiorId, replacementName) VALUES (1045, 2, 4, 'Jn. Lane', 'An/III/Art', 'Jn_Lane_front.png', 'Jn_Lane_back.png', 10, 1009, 'Jn. Lane Repl');





