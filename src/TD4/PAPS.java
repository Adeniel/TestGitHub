package TD4;

import java.util.ArrayList;

public class PAPS<TC> implements SalleDAttente<TC> {

	private Integer capacite;
	private ArrayList<TC> List; 
	
	//Constructeur
	public PAPS(int capacite) {
		this.capacite = capacite;
		//this.nbClients = nbClients;
		List = new ArrayList<TC>();
	}
	
	/**
	 * @return capacite de la salle
	 */
	@Override
	public int getCapacite() {
		return capacite;
	}

	/**
	 * @return nombre de Clients
	 */
	@Override
	public int getNbClients() {
		return List.size();
	}

	// La salle est vide ?
	@Override
	public boolean estVide() {
		return List.isEmpty();
	}

	// La salle est pleine ?
	@Override
	public boolean estPleine() {
		return List.size()>=getCapacite();
	}

	// Entree d'un nouveau client
	// (precondition : salle non pleine)
	@Override
	public void entrer(TC client) {
		if(!this.estPleine()) {
			List.add(client);
		}	
	}

	// Prochain client a servir
	// (precondition : salle non vide)
	@Override
	public TC getProchain() {
		if(!this.estVide()) {return List.get(0);}
		else return null;
	}

	// Sortie du prochain client a servir
	// (precondition : salle non vide)
	@Override
	public void sortir() {
		if(!this.estVide()) {
			List.remove(getProchain());
		}	
	}

}
