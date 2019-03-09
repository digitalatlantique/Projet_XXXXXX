-------------------------------------------------------------------
/* Création des membres */
-------------------------------------------------------------------
INSERT INTO membre
	(nom, prenom, password, email, compte_valide)
VALUES
	('Allain', 'Pierre', MD5('Pierre'), 'pierre@yahoo.fr', true),
	('Almer', 'Christian', MD5('Christian'), 'christian@yahoo.fr', true),
	('Balmat', 'Jacques', MD5('Jacques'), 'jacques@yahoo.fr', true),
	('Castagna', 'Christina', MD5('Christina'), 'christina@yahoo.fr', true),
	('Cordier', 'Patrick', MD5('Patrick'), 'patrick@yahoo.fr', true);
	
	
-------------------------------------------------------------------
/* Création des sites */
-------------------------------------------------------------------
INSERT INTO site
	(nom, presentation, localite, code_postal, image_path, membre_id)
VALUES
	(	'La roche Bernard', 
		'Vitae auctor eu augue ut lectus arcu bibendum. Eget egestas purus viverra accumsan in nisl nisi scelerisque. Ut placerat orci nulla pellentesque dignissim. Nec tincidunt praesent semper feugiat nibh sed pulvinar proin gravida. Et netus et malesuada fames ac turpis. Nibh cras pulvinar mattis nunc. Scelerisque felis imperdiet proin fermentum leo vel orci. Molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed. Tincidunt lobortis feugiat vivamus at augue. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere. Aliquet sagittis id consectetur purus. Accumsan tortor posuere ac ut consequat semper viverra nam. Parturient montes nascetur ridiculus mus mauris vitae ultricies.',
		'Viéville', '52310', 'laRocheBernard.jpg', 1),
		
	(	'La falaise du Côna', 
		'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Adipiscing elit duis tristique sollicitudin nibh sit amet commodo nulla. Enim lobortis scelerisque fermentum dui. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Tortor id aliquet lectus proin. Feugiat pretium nibh ipsum consequat nisl. Fames ac turpis egestas sed. Donec adipiscing tristique risus nec feugiat in. Ultricies lacus sed turpis tincidunt id aliquet risus. Id consectetur purus ut faucibus pulvinar elementum.',
		'Bourmont', '52150', 'falaiseDuCona.jpg', 1),
		
	(	'La falaise de Cohons', 
	'Mollis aliquam ut porttitor leo a diam sollicitudin. Sagittis eu volutpat odio facilisis mauris sit amet. Pharetra sit amet aliquam id diam maecenas ultricies mi eget. Sagittis id consectetur purus ut faucibus pulvinar elementum. Arcu odio ut sem nulla. Turpis tincidunt id aliquet risus feugiat in ante metus dictum. Id donec ultrices tincidunt arcu non sodales neque sodales ut. Elementum sagittis vitae et leo duis ut diam. Mattis rhoncus urna neque viverra. Urna molestie at elementum eu facilisis sed odio morbi. Imperdiet nulla malesuada pellentesque elit eget. Vitae turpis massa sed elementum. Libero id faucibus nisl tincidunt eget nullam non nisi. Fusce ut placerat orci nulla pellentesque dignissim enim sit amet. Ac turpis egestas sed tempus. Vestibulum morbi blandit cursus risus at. Et malesuada fames ac turpis egestas maecenas pharetra convallis posuere. Augue eget arcu dictum varius duis at consectetur lorem.',
	'Cohons', '52200', 'falaiseDeCohons.jpg', 2);
	
-------------------------------------------------------------------
/* Création des commentaires */
-------------------------------------------------------------------
INSERT INTO commentaire
	(commentaire, membre_id, site_id)
VALUES
	('Primi igitur omnium statuuntur Epigonus et Eusebius ob nominum gentilitatem oppressi. praediximus enim Montium sub ipso vivendi termino his vocabulis appellatos fabricarum culpasse tribunos ut adminicula futurae molitioni pollicitos.', 3, 1),
	('Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?', 4, 1),
	('Has autem provincias, quas Orontes ambiens amnis imosque pedes Cassii montis illius celsi praetermeans funditur in Parthenium mare, Gnaeus Pompeius superato Tigrane regnis Armeniorum abstractas dicioni Romanae coniunxit.', 5, 2),
	('Sed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?', 1, 2),
	('Nemo quaeso miretur, si post exsudatos labores itinerum longos congestosque adfatim commeatus fiducia vestri ductante barbaricos pagos adventans velut mutato repente consilio ad placidiora deverti.', 3, 3),
	('Cognitis enim pilatorum caesorumque funeribus nemo deinde ad has stationes appulit navem, sed ut Scironis praerupta letalia declinantes litoribus Cypriis contigui navigabant, quae Isauriae scopulis sunt controversa.', 4, 3);

	
-------------------------------------------------------------------
/* Création des secteurs */
-------------------------------------------------------------------	
INSERT INTO secteur
	(nom, hauteur, image_path, site_id)
VALUES
	('1', 18,'RocheBernard-1.png', 1),
	('2', 25, 'RocheBernard-2.png', 1),
	('1', 35, 'cona-1.png', 2),
	('2', 29, 'cona-2.png', 2),
	('1a', 21, 'cohons-1a.png', 3);


-------------------------------------------------------------------
/* Création des voies */
-------------------------------------------------------------------	
INSERT INTO voie
	(numero, nom, cotation, secteur_id)
VALUES
	('1', 'Arc de cercle', '5b', 1),
	('2', 'Hématome de Savoie', '4b', 1),
	('3', 'Le bec', '5a', 1),
	('4', 'La rebloche', '5b', 1),
	('5', 'La cuisse Hard', '5b', 1),
	('6', 'Scan-dalle', '5c', 1),
	('7', 'Enigma', '6a+', 1),
	('8', 'Le vide ordure', '6b', 1),
	
	('9', 'Sans toit ni loi', '6b', 2),
	('10', 'Vol au vent', '7b+', 2),
	('11', 'Fleur de lisse', '7a', 2),
	('12', 'Le ventre du président', '6a', 2),
	('13', 'Question équilibre', '6a', 2),
	('14', 'Le dièdre des pleurs', '4c', 2),
	('15', 'Larme blanche', '6c', 2),
	('16', 'La fissure bleue', '6c+', 2),
	('17', 'La fissure bleue intégrale', '6c', 2),
	('18', 'Arête du Q', '7a', 2),
	
	('1', 'Nocturne', '4c', 3),
	('2', 'Ballade', '5a', 3),
	('3', 'La montagne', '5c', 3),
	('4', 'Ali baba', '6c', 3),
	('5', 'La pelle de la montagne', '6a+', 3),
	('6', 'Appel du sciècle', '6b', 3),
	('7', 'Montagnards Equipe', '6b', 3),
	
	('8', 'Traversée des Alpes', '4c', 4),
	('9', 'La voie du seigneur', '5a', 4),
	('10', 'Tinitin au bidet', '5c', 4),
	('11', 'JFS', '6c', 4),
	('12', 'Dieu créa la femme', '6a+', 4),
	('13', 'Un pour tous, tous pourris', '6b', 4),
	('14', 'Beau Croise Belle Gamelle', '6b', 4),
	
	('1', 'Rocking chair', '4c', 5),
	('2', 'La haine', '5a', 5),
	('3', 'Aveu', '5c', 5),
	('4', 'Effraie moi', '6c', 5),
	('5', 'Imitation spéléo', '6a+', 5),
	('6', 'Christian', '6b', 5),
	('7', 'Le trou du fût', '6b', 5),
	('8', 'Les cochons', '4c', 5),
	('9', 'Le pilier du soleil', '5a', 5),
	('10', 'Le rocher Lingon', '5c', 5),
	('11', 'Yvette Errant', '6c', 5);
	
	
-------------------------------------------------------------------
/* Création d'un topo */
-------------------------------------------------------------------	
INSERT INTO topo
	(libelle, information, autoriser_location, membre_id)
VALUES
	('Tautavel', 
		'Adolescebat autem obstinatum propositum erga haec et similia multa scrutanda, stimulos admovente regina, quae abrupte mariti fortunas trudebat in exitium praeceps, cum eum potius lenitate feminea ad veritatis humanitatisque viam reducere utilia suadendo deberet, ut in Gordianorum actibus factitasse Maximini truculenti illius imperatoris rettulimus coniugem.

		Cum haec taliaque sollicitas eius aures everberarent expositas semper eius modi rumoribus et patentes, varia animo tum miscente consilia, tandem id ut optimum factu elegit: et Vrsicinum primum ad se venire summo cum honore mandavit ea specie ut pro rerum tunc urgentium captu disponeretur concordi consilio, quibus virium incrementis Parthicarum gentium a arma minantium impetus frangerentur.',
		
		true, 1);
	
INSERT INTO topo_site
	(topos_topo_id, sites_site_id)
VALUES
	(1, 1),
	(1, 2);

-------------------------------------------------------------------
/* Création des réservations */
-------------------------------------------------------------------
INSERT INTO location
	(membre_id, topo_id, debut_location, fin_location)
VALUES 
	(2, 1, '2018-07-20', '2018-07-25'),
	(3, 1, '2018-08-10', '2018-08-15'),
	(4, 1, '2018-09-05', '2018-09-08');































































	