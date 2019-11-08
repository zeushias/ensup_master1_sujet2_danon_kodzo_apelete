package presentation;

import java.util.Date;

import metier.Annonce;
import metier.Personne;
import service.Iservice;
import service.ServiceImpl;

public class Lanceur {
	
	public static void init() {
		
		Personne p1 = new Personne(1, "DANON", "Kodzo", "kodzo", "mdp1", new Date());
		Personne p2 = new Personne(2, "TANGUI", "Gilbert", "gilbert", "mdp2", new Date());
		
		Annonce a1 = new Annonce(1, "Cours GPM", "bla bla bla bla", 263);
		Annonce a2 = new Annonce(1, "Algo", "bla bla bla bla", 23);
		Annonce a3 = new Annonce(1, "Java", "bla bla bla bla", 26);
		Annonce a4 = new Annonce(1, "PHP", "bla bla bla bla", 53);
		Annonce a5 = new Annonce(1, "UML", "bla bla bla bla", 33);
		
		p1.getAnnonces().add(a1);
		p1.getAnnonces().add(a2);
		p2.getAnnonces().add(a3);
		p2.getAnnonces().add(a4);
		p2.getAnnonces().add(a5);
		
		ServiceImpl.base.add(p1);
		ServiceImpl.base.add(p2);
	}

	public static void main(String[] args) {
		
		Iservice service = new ServiceImpl();
		init();
		System.out.println("Avant ajout");
		System.out.println(ServiceImpl.base);
		
		
		
		service.affichePersonnes();
		
		service.creerPersonne(ServiceImpl.base, new Personne(3, "SON","Yan","yan","mdp3",new Date()));
		service.findAllAnnonce(ServiceImpl.base.get(0));
		service.getPersonne(ServiceImpl.base, 1);
		service.updatePersonne(ServiceImpl.base, ServiceImpl.base.get(1), "LOIC", "Hubert", new Date());
		service.getPersonneId(ServiceImpl.base, ServiceImpl.base.get(0));
		service.affichePersonnes();
		
		service.findAllPersonnes();
		//
		service.afficheAnnoncesPersonne(ServiceImpl.base.get(0));
		service.getAnnonce(ServiceImpl.base.get(1), 1);
		service.deleteAnnonce(ServiceImpl.base.get(1), 2);
		service.creerAnnonce(ServiceImpl.base.get(0), new Annonce(6, "ALgo2", "algo", 203));
		service.findAllAnnonce(ServiceImpl.base.get(1));
		service.updateAnnonce(ServiceImpl.base.get(0), ServiceImpl.base.get(0).getAnnonces().get(0));
		
		//service.deletePersonne(ServiceImpl.base.get(1), 1);
		service.deleteAnnonce(ServiceImpl.base.get(1), 2);
	}

}
