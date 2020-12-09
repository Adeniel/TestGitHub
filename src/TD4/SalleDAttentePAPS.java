package TD4;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class SalleDAttentePAPS<TC> extends ArrayList<TC> implements SalleDAttente<TC> {		//Le prof a rajouté extends pour appeler les méthodes de ArrayList

		private Integer capacite;						//Ai retiré nbClients car 0 utilité
		private ArrayList<TC> List; 
		
		//Constructeur
		public SalleDAttentePAPS(int capacite) {		//Prof : public SalleDAttentePAPS(int capacite) {
			this.capacite = capacite;					//super() ;
			List = new ArrayList<TC>();					//this.capacite = capacite ; }			
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
			return List.size()==getCapacite();			//return getNbClients() == getCapacite();
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
			if(!this.estVide()) {							//assert !estVide();
				List.remove(getProchain());					//this.remove(0);
			}
			
		}

	}

	

