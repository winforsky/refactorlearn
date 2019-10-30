package Domain;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR =0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (get_priceCode()){
            case REGULAR:
                thisAmount +=2;
                if (daysRented >2){
                    thisAmount += (daysRented -2)*1.5;
                }
                break;
            case NEW_RELEASE:
                    thisAmount += daysRented *3;

                break;
            case CHILDRENS:
                thisAmount +=1.5;
                if (daysRented >3){
                    thisAmount += (daysRented -3)*1.5;
                }
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (get_priceCode() == NEW_RELEASE && daysRented >1){
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
