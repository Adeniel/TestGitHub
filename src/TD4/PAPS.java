package TD4;

import java.util.ArrayList;

public class PAPS<TC> implements SalleDAttente<TC> {

	private Integer capacite, nbClients;
	private ArrayList<TC> List; 
	
	//Constructeur
	public PAPS(int capacite) {
		this.capacite = capacite;
		//this.nbClients = nbClients;
		List = new ArrayList<TC>();
	}
		
	@Override
	public int getCapacite() {
		// TODO Auto-generated method stub
		return capacite;
	}

	// Nombre de clients dans la salle
	@Override
	public int getNbClients() {
		// TODO Auto-generated method stub
		return List.size();
	}

	// La salle est vide ?
	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return List.isEmpty();
	}

	// La salle est pleine ?
	@Override
	public boolean estPleine() {
		// TODO Auto-generated method stub
		return List.size()>=getCapacite();
	}

	// Entree d'un nouveau client
	// (precondition : salle non pleine)
	@Override
	public void entrer(TC client) {
		// TODO Auto-generated method stub
		if(!this.estPleine()) {
			List.add(client);
		}	
	}

	// Prochain client a servir
	// (precondition : salle non vide)
	@Override
	public TC getProchain() {
		// TODO Auto-generated method stub
		if(!this.estVide()) {return List.get(0);}
		else return null;
	}

	// Sortie du prochain client a servir
	// (precondition : salle non vide)
	@Override
	public void sortir() {
		// TODO Auto-generated method stub
		if(!this.estVide()) {
			List.remove(getProchain());
		}	
	}

}
