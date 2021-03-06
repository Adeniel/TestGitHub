package TD4;

import java.util.*;

public class SalleDAttenteAvecPrio<TC extends AvecPrio> implements SalleDAttente<TC> {		//TC implique l'�l�ment

	private int capacite, maxPrio;
	private Map<Integer, ArrayList<TC>> salle; 
	//private ArrayList<TC> [] salle;
	
	//Constructeur
	/* @param capacite = capacite maximum de la salle
	 * @param maxPrio = level maximum qu'on peut avoir pour les priorit�s maximums
	 */
	public SalleDAttenteAvecPrio(int capacite, int maxPrio) {
		this.capacite = capacite;
		this.maxPrio = maxPrio;
		this.salle = new HashMap<Integer,ArrayList<TC>>();
		//this.salle = new ArrayList<TC>[capacite];
		
		//Map initialisation
		for (int i=0;i<maxPrio;i++) {
			salle.put(i, new ArrayList<TC>());		// il faut dans la map d�clar� la liste
		}
	}

	// Capacite de la salle
	@Override
	public int getCapacite() {
		// TODO Auto-generated method stub
		return capacite;
	}

	// Nombre de clients dans la salle
	@Override
	public int getNbClients() {
		// TODO Auto-generated method stub
		int nbClients=0;
		for (ArrayList<TC> quantite : salle.values()) {		//On parcours l'ensemble de la liste pour conna�tre � chaque tour de
			nbClients += quantite.size();					//boucle le nombre de personne prioritaire.
		}
		return nbClients;
		
		// on cherche a donner le nombre de clients dans la salle � l'instant T, pour ce faire on fait la somme de la taille de chaque file d'attente 
//        int res=0;
//        for(int i=0;i<maxPrio;i++) {
//            res += salle.get(i).size(); // on fait un get sur la salle d'indice i (correspondant a 1 niveau de priorit�) ce qui rend l'ArrayList puis on prend la size de ce get. 
//        }
	}

	// La salle est vide ?
	@Override
	public boolean estVide() {
		return getNbClients()==0;
	}

	// La salle est pleine ?
	@Override
	public boolean estPleine() {
		return getNbClients()==capacite;
	}

	// Entree d'un nouveau client
	// (precondition : salle non pleine)
	@Override
	public void entrer(TC client) {
		int prio = client.getPrio();
		if (!estPleine()) {
			if(prio>maxPrio) {						//Si la priorit� donn�e est sup
				salle.get(maxPrio).add(client);		//.get r�cup�ration cl� .add rajout
			}
			else if (prio<0) {						//Si priorit� inf � 0
				salle.get(0).add(client);		
			}
			else {salle.get(client.getPrio()).add(client);
			// {salle.get(prio).entrer(client);}
			}
		}
	}

	// Prochain client a servir
	// (precondition : salle non vide)
	@Override
	public TC getProchain() {
		// TODO Auto-generated method stub
		if (!estVide()) {
			for (int i = maxPrio-1; i>=0; i--) {
				if (salle.get(i).size()!=0) {
					return salle.get(i).get(0);
				}			
			}
		}
		return null;
	}

	// Sortie du prochain client a servir
	// (precondition : salle non vide)
	@Override
	public void sortir() {
		if (!estVide()) {
			TC next = getProchain();				//On recupere le prochain
			salle.get(next.getPrio()).remove(next);	//Antinomie de entrer
		}
	}			
}
