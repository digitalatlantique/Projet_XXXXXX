/* SELECTIONNE les tuples disponibles sur un intervalle date */
SELECT * FROM location
WHERE debut_location NOT BETWEEN '2018-07-20' AND '2018-07-25'
AND fin_location NOT BETWEEN '2018-07-20' AND '2018-07-25'

/*Recherche par nom site*/
select * from site
where nom like '%cho%';

/* Recherche multicritère */
SELECT * 
FROM site si
INNER JOIN secteur se ON se.site_id = si.site_id
INNER JOIN voie v ON v.secteur_id = se.secteur_id
WHERE v.cotation BETWEEN '6' AND '7'

/* Recherche multicritère */
SELECT * 
FROM site si
INNER JOIN secteur se ON se.site_id = si.site_id
INNER JOIN voie v ON v.secteur_id = se.secteur_id
where v.cotation = '6a'