package ch.hearc.ig.odi.customeraccount.application;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Customer;

/**
 * Classe de test.
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class Application {

    private Application() {
    }

    private void run() {
        // Création du client
        Customer customer = new Customer(1, "Tic", "Tac");

        // Création des comptes clients
        String[] accountNumber = {"1-5323-12", "4-2195-09"};
        customer.addAccount(accountNumber[0], "Account 1", 0.03);
        customer.addAccount(accountNumber[1], "Account 2", 0.1);

        // Test des getters client
        System.out.println("-----Description du client-----");
        System.out.println("Numéro client : " + customer.getNumber());
        System.out.println("Prénom : " + customer.getFirstName());
        System.out.println("Nom : " + customer.getLastName());

        // Test des getters compte
        Account accountX;
        for (int i = 0; i < accountNumber.length; i++) {
            accountX = customer.getAccountByNumber(accountNumber[i]);

            System.out.println("-----Description d'un compte-----");
            System.out.println("Numéro de compte : " + accountX.getNumber());
            System.out.println("Nom du compte : " + accountX.getName());
            System.out.println("Taux d'intérêt : " + accountX.getRate());
            System.out.println("Solde : " + accountX.getBalance());

            customer = accountX.getCustomer();
            
            System.out.println("Propriétaire : " + customer.getLastName() + " " + customer.getFirstName());
        }

        Account account1 = customer.getAccountByNumber(accountNumber[1]);
        
        // Méthode debit() : Test l'exception levé en cas de solde insuffisant (avec solde à 0)
        try {
            account1.debit(200);
        } catch (IllegalStateException ex) {
            System.out.println();
            System.out.println("/!\\ Erreur de solde insuffisant interceptée :");
            System.out.println(ex);
            System.out.println();
        }

        // Méthode debit() : Test l'exception levé en cas de montant nul
        try {
            account1.debit(0);
        } catch (IllegalArgumentException ex) {
            System.out.println();
            System.out.println("/!\\ Erreur de montant nul interceptée :");
            System.out.println(ex);
            System.out.println();
        }

        // Montant credit() : Test l'exception levé en cas de montant négatif
        try {
            account1.credit(-230);
        } catch (IllegalArgumentException ex) {
            System.out.println();
            System.out.println("/!\\ Erreur de montant négatif interceptée :");
            System.out.println(ex);
            System.out.println();
        }

        // Test du credit
        account1.credit(1200);

        System.out.println("-----Nouveau solde-----");
        System.out.println("Solde compte n°" + account1.getNumber() + " : " + account1.getBalance());
        System.out.println("Débit de 100.-");

        // Test du debit
        account1.debit(100);
        
        System.out.println("Solde compte n°" + account1.getNumber() + " : " + account1.getBalance());
        
        Account account2 = customer.getAccountByNumber(accountNumber[0]);

        // Méthode transfert() : Test l'exception levé en cas de montant nul
        try {
            Account.transfer(0, account1, account2);
        } catch (IllegalArgumentException ex) {
            System.out.println();
            System.out.println("/!\\ Erreur de montant nul interceptée :");
            System.out.println(ex);
            System.out.println();
        }

        // Méthode transfert() : Test l'exception levé en cas de solde insuffisant (avec solde > 0)
        try {
            Account.transfer(1500, account1, account2);
        } catch (IllegalStateException ex) {
            System.out.println();
            System.out.println("/!\\ Erreur de solde insuffisant interceptée :");
            System.out.println(ex);
            System.out.println();
        }

        // Test du transfert
        Account.transfer(500, account1, account2);

        // Vérifie le succès du transfert
        for (int i = 0; i < accountNumber.length; i++) {
            accountX = customer.getAccountByNumber(accountNumber[i]);

            System.out.println("-----Description d'un compte-----");
            System.out.println("Numéro de compte : " + accountX.getNumber());
            System.out.println("Nom du compte : " + accountX.getName());
            System.out.println("Taux d'intérêt : " + accountX.getRate());
            System.out.println("Solde : " + accountX.getBalance());

            customer = accountX.getCustomer();
            
            System.out.println("Propriétaire : " + customer.getLastName() + " " + customer.getFirstName());
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
