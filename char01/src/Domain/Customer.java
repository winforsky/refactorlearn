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

    public double getTotalCharge(){
        double totalAmount = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()){
            Rental rental = rentals.nextElement();
            //show figures for this rental
            totalAmount+= rental.getCharge();
        }
        return totalAmount;
    }

    public double getTotalFrequentRenterPoints(){
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()){
            Rental rental = rentals.nextElement();
            //add frequent renter points
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public String statement(){
        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "Domain.Rental Record for "+ get_name()+"\n";
        while (rentals.hasMoreElements()){
            //Extract Method 110 抽取方法
            //当方法体中的代码功能没有连续性时可以考虑提取
            Rental rental = rentals.nextElement();
            //show figures for this rental
            result += "\t"+rental.get_movie().get_title()+"\t"+String.valueOf(rental.getCharge())+"\n";
        }

        //add footer lines
        //Replace temp with Query 120  去除临时变量
        //totalAmount在循环体内被赋值，把它迁移到查询函数中去
        //frequentRenterPoints 同理
        result += "Amount owed is "+String.valueOf(getTotalCharge())+"\n";
        result +="You earned "+String.valueOf(getTotalFrequentRenterPoints())+"frequent renter points\n";
        return result;
    }
}
