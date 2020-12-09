package TD4;

public interface SalleDAttente<TC> {
	
	// Capacite de la salle
	public abstract int getCapacite(); 
	
	// Nombre de clients dans la salle
	public abstract int getNbClients(); 
	
	// La salle est vide ?
	public abstract boolean estVide(); 
	
	// La salle est pleine ?
	public abstract boolean estPleine(); 
	
	// Entree d'un nouveau client
	// (precondition : salle non pleine)
	public abstract void entrer(TC client); 
	
	
	// Prochain client a servir
	// (precondition : salle non vide)
	public abstract TC getProchain(); 
	
	// Sortie du prochain client a servir
	// (precondition : salle non vide)
	public abstract void sortir(); 
	
}
