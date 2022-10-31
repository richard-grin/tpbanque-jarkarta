package com.mycompany.tpbanque.ejb;

import com.mycompany.tpbanque.entities.CompteBancaire;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 *
 * @author grin
 */
@Singleton
@Startup
public class Init {
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    @PostConstruct
    public void creationComptesInitiaux() {
        if (gestionnaireCompte.nbComptes() != 0) {
            return;
        }
        CompteBancaire c = new CompteBancaire("John Lennon", 150000);
        gestionnaireCompte.persist(c);
        c = new CompteBancaire("Paul McCartney", 950000);
        gestionnaireCompte.persist(c);
        c = new CompteBancaire("Ringo Starr", 20000);
        gestionnaireCompte.persist(c);
        c = new CompteBancaire("Georges Harrisson", 100000);
        gestionnaireCompte.persist(c);
    }
}
