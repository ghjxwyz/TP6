package ticketmachine;
// git add . 
// git commit -m "tp"
// git push 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	
	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de
	// l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		// GIVEN : une machine vierge (initialisée dans @BeforeEach)
		// WHEN On insère de l'argent
		machine.insertMoney(10);
		machine.insertMoney(20);
		// THEN La balance est mise à jour, les montants sont correctement additionnés
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");
	}

	@Test 
	void BalanceNotEnough () {
		machine.insertMoney(PRICE - 10);
		assertFalse(machine.printTicket());
	} 
	@Test 
	void BalanceIsEnough (){
		machine.insertMoney(PRICE);
		assertTrue(machine.printTicket());
	}
	@Test

	void Decrementation (){
		machine.insertMoney(PRICE + 20); 
		machine.printTicket(); 
		assertEquals(machine.getBalance(),20 );
	}
 	@Test 

 	void collect(){
		machine.insertMoney(PRICE);
		machine.printTicket(); 
		assertEquals(PRICE, machine.getTotal());

	}
	@Test 

 	void GiveBackMoney (){
		machine.insertMoney(PRICE + 10);
		machine.printTicket(); 
		assertEquals(10, machine.getBalance()); 
	}

	@Test

	void TestRefund (){
		machine.insertMoney(10);
		machine.refund(); 
		assertEquals(0, machine.getBalance() );
	}

	
	@Test
void NoNegative() {
    assertThrows(
        IllegalArgumentException.class,
        () -> machine.insertMoney(-10),
        "pas de montant negatif"
    );
}
@Test 

void NoNegativePrice () {
	
	assertThrows(
		IllegalArgumentException.class, 
		() -> new TicketMachine(-50),
		"Ticket price must be positive"
		);
	
}



}
