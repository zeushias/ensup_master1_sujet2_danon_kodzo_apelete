package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.Annonce;
import metier.Personne;


public class ServiceImpl implements Iservice {
	
	public static List<Personne> base = new ArrayList<Personne>();

	@Override
	public int creerPersonne(List<Personne> list, Personne personne) {
		
		try {
			list.add(personne);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public Personne getPersonne(List<Personne> list, int idPersonne) {
		
		try {
			for (Personne personne : list) {
				if(personne.getPersonneId() == idPersonne) {
					return personne;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deletePersonne(List<Personne> list, int idPersonne) {
		
		for (Personne personne : list) {
			if(personne.getPersonneId() == idPersonne) {
				list.remove(personne);
				break;
			}
		}
	}

	@Override
	public void updatePersonne(List<Personne> list, Personne p, String nom, String prenom, Date dateNaissance) {
		
		for (Personne personne : list) {
			if(personne.getPersonneId() == p.getPersonneId()) {
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setDateNaissance(dateNaissance);
				break;
			}
		} 

	}

	@Override
	public List<Personne> findAllPersonnes() {
		return (List<Personne>) base;
	}

	@Override
	public int getPersonneId(List<Personne> list, Personne p) {
		
		try {
			for (Personne personne : list) {
				if(personne.getPersonneId() == p.getPersonneId()) {
					return personne.getPersonneId();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public void affichePersonnes() {
		
		System.out.println(base);
	}

	@Override
	public void afficheAnnoncesPersonne(Personne p) {
		
		System.out.println(p.getAnnonces());

	}

	@Override
	public int creerAnnonce(Personne personne, Annonce a) {

		try {
			personne.getAnnonces().add(a);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public Annonce getAnnonce(Personne personne, int idAnnonce) {
		for(Annonce a : personne.getAnnonces()) {
			if(a.getIdAnnonce() == idAnnonce) {
				return a;
			}
		}
		return null;
	}

	@Override
	public void deleteAnnonce(Personne personne, int idAnnonce) {
		for(Annonce a : personne.getAnnonces()) {
			if(a.getIdAnnonce() == idAnnonce) {
				personne.getAnnonces().remove(a);
			}
		}

	}

	@Override
	public void updateAnnonce(Personne personne, Annonce a) {
		for(Annonce annonce : personne.getAnnonces()) {
			if(annonce.getIdAnnonce() == a.getIdAnnonce()) {
				annonce.setIntitule("Tutoriel Java EE");
				annonce.setPrix(300);
			}
		}
	}

	@Override
	public List<Annonce> findAllAnnonce(Personne personne) {
		
		return personne.getAnnonces();
	}

}
