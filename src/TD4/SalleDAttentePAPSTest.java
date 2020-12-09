package TD4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;				//nécessaire pour pouvoir utiliser les assert

class SalleDAttentePAPSTest {

	private SalleDAttente<ClientAvecPrio> sallePAPS;
	
	@BeforeEach
	void setUp() throws Exception {
		sallePAPS = new SalleDAttentePAPS<> (5);
	}
	
	@Test	
    void testSalleVide() {
        assertTrue("La salle doit être vide", sallePAPS.estVide()); 
    }
	
	@Test
	public void testUnElement()
	{
		ClientAvecPrio c = new ClientAvecPrio("un client", 1) ;
		testUnElement(sallePAPS, c) ;
	}

	private void testUnElement(SalleDAttente s, ClientAvecPrio c)
	{
		assertTrue("La salle doit être vide", s.estVide()) ;
		s.entrer(c); 
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit être de taille 1") ;
		assertSame(c, s.getProchain(), "Le prochain à sortir doit être le premier entré") ;
		s.sortir();
		assertTrue("La salle doit être vide", s.estVide()) ;		
	}
	
	@Test
	public void testCinqElements()
	{
		ClientAvecPrio c1 = new ClientAvecPrio("un client", 1) ;
		ClientAvecPrio c2 = new ClientAvecPrio("un client 2", 1) ;
		ClientAvecPrio c3 = new ClientAvecPrio("un client 3", 1) ;
		ClientAvecPrio c4 = new ClientAvecPrio("un client 4", 1) ;
		ClientAvecPrio c5 = new ClientAvecPrio("un client 5", 1) ;
		testCinqElements(sallePAPS, c1, c2, c3, c4, c5) ;
	}

	private void testCinqElements (SalleDAttente s, ClientAvecPrio c1, ClientAvecPrio c2, ClientAvecPrio c3, ClientAvecPrio c4, ClientAvecPrio c5) 
	{
		assertTrue("La salle doit être vide", s.estVide()) ;
		s.entrer(c1); 
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit être de taille 1") ;
		s.entrer(c2);
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(2, s.getNbClients(), "La salle doit être de taille 2") ;
		s.entrer(c3);
		s.entrer(c4);
		s.entrer(c5);
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle doit être pleine", s.estPleine()) ;
		assertEquals(5, s.getNbClients(), "La salle doit être de taille 5") ;
		assertSame(c1, s.getProchain(), "Le prochain à sortir doit être le premier entré") ;
		s.sortir();
		assertEquals(4, s.getNbClients(), "La salle doit contenir 4 clients") ;
	}
	
	@Test
	public void testSixElements()
	{
		ClientAvecPrio c1 = new ClientAvecPrio("un client", 1) ;
		ClientAvecPrio c2 = new ClientAvecPrio("un client 2", 1) ;
		ClientAvecPrio c3 = new ClientAvecPrio("un client 3", 1) ;
		ClientAvecPrio c4 = new ClientAvecPrio("un client 4", 1) ;
		ClientAvecPrio c5 = new ClientAvecPrio("un client 5", 1) ;
		ClientAvecPrio c6 = new ClientAvecPrio("un client 6", 1) ;
		testSixElements(sallePAPS, c1, c2, c3, c4, c5, c6) ;
	}

	private void testSixElements (SalleDAttente s, ClientAvecPrio c1, ClientAvecPrio c2, ClientAvecPrio c3, ClientAvecPrio c4, ClientAvecPrio c5, ClientAvecPrio c6) 
	{
		assertTrue("La salle doit être vide", s.estVide()) ;
		s.entrer(c1); 
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit être de taille 1") ;
		s.entrer(c2);
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(2, s.getNbClients(), "La salle doit être de taille 2") ;
		s.entrer(c3);
		s.entrer(c4);
		s.entrer(c5);
		assertTrue("La salle doit être pleine", s.estPleine()) ;
		assertEquals(5, s.getNbClients(), "La salle doit être de taille 5") ;
		s.entrer(c6);
		assertTrue("Le client n'a pas pu rentrer", s.estPleine());
		assertSame(c1, s.getProchain(), "Le prochain à sortir doit être le premier entré") ;
		s.sortir();
		assertEquals(4, s.getNbClients(), "La salle doit contenir 4 clients") ;
	}
}
