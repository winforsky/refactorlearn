package Domain;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental rental) {
        this._rentals.add(rental);
    }

    public String get_name() {
        return _name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Domain.Rental Record for "+ get_name()+"\n";
        while (rentals.hasMoreElements()){
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            switch (each.get_movie().get_priceCode()){
                case Movie.REGULAR:
                    thisAmount +=2;
                    if (each.get_daysRented()>2){
                        thisAmount += (each.get_daysRented()-2)*1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                        thisAmount += each.get_daysRented()*3;

                    break;
                case Movie.CHILDRENS:
                    thisAmount +=1.5;
                    if (each.get_daysRented()>3){
                        thisAmount += (each.get_daysRented()-3)*1.5;
                    }
                    break;
            }

            frequentRenterPoints++;
            if (each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRented()>1){
                frequentRenterPoints++;
            }

            result += "\t"+each.get_movie().get_title()+"\t"+String.valueOf(thisAmount)+"\n";
            totalAmount+=thisAmount;
        }

        result += "Amount owed is "+String.valueOf(totalAmount)+"\n";
        result +="You earned "+String.valueOf(frequentRenterPoints)+"frequent renter points\n";
        return result;
    }
}
