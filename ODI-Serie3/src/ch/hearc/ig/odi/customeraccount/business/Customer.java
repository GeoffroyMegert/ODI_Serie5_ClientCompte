package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

/**
 * Classe permettant la gestion de clients.
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class Customer {

    private Collection<Account> accounts;
    private int number;
    private String firstName;
    private String lastName;

    /**
     * Constructeur paramétré pour les clients.
     *
     * @param number Le numéro du client.
     * @param firstName Le prénom du client.
     * @param lastName Le nom du client.
     */
    public Customer(final Integer number, final String firstName, final String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    /**
     * Retourne le compte possédant le numéro passé en paramètre.
     *
     * @param number Le numéro du compte désiré.
     */
    public Account getAccountByNumber(final String number) {
        int i = 0;

        while (!((ArrayList<Account>)accounts).get(i).getNumber().equals(number)) {
            i++;
        }

        return ((ArrayList<Account>)accounts).get(i);
    }

    /**
     * Ajoute un compte à la liste des comptes du client.
     *
     * @param number Le numéro du compte.
     * @param name Le nom du compte.
     * @param rate Le taux d'intérêt du compte.
     */
    public void addAccount(final String number, final String name, final double rate) {
        accounts.add(new Account(number, name, rate, this));
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
