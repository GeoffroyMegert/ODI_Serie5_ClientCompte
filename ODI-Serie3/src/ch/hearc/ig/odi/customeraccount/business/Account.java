package ch.hearc.ig.odi.customeraccount.business;

/**
 * Classe permettant la gestion de comptes.
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.001;

    /**
     * Constructeur paramétré pour les comptes.
     *
     * @param number Le numéro du compte.
     * @param name Le nom du compte.
     * @param rate Le taux d'intérêt du compte.
     * @param customer Le propriétaire du compte.
     */
    public Account(final String number, final String name, final double rate, final Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    /**
     * Crédite le montant désiré sur le compte.
     *
     * @param amount Le montant à créditer.
     */
    public void credit(final double amount) {
        checkAmount(amount);

        balance = balance + amount;
    }

    /**
     * Débite le montant désiré sur le compte.
     *
     * @param amount Le montant à débiter.
     */
    public void debit(final double amount) {
        checkAmount(amount);
        checkBalance(amount);

        balance = balance - amount;
    }

    /**
     * Transfère le montant désiré du compte source au compte cible.
     *
     * @param amount Le montant à transférer.
     * @param source Le compte source.
     * @param target Le compte cible.
     */
    public static void transfer(final double amount, final Account source, final Account target) {
        source.debit(amount);
        target.credit(amount);
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(final double rate) {
        this.rate = rate;
    }

    /**
     * Vérifie que le montant n'est pas nul ou négatif.
     * 
     * @param amount Le montant à vérifier.
     */
    private void checkAmount(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Les montants nuls ou négatifs ne sont pas valides.");
        }
    }

    /**
     * Vérifie que le solde soit suffisant.
     * 
     * @param amount Le montant à débiter.
     */
    private void checkBalance(final double amount) {
        if (balance - amount < 0) {
            throw new IllegalStateException("Vous ne possédez pas le montant suffisant sur ce compte.\n"
                    + "Compte n°" + this.number);
        }
    }
}
