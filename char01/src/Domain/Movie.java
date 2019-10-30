package Domain;

abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented >3){
            thisAmount += (daysRented -3)*1.5;
        }
        return thisAmount;
    }
}

class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double thisAmount = 2;
        if (daysRented >2){
            thisAmount += (daysRented -2)*1.5;
        }
        return thisAmount;
    }
}

class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented *3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if (daysRented >1){
            return 2;
        }
        return 1;
    }
}

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR =0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        this._title = title;
        //self encapsulate field 171
        set_priceCode(priceCode);
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    public void set_priceCode(int priceCode) {
        //replace type code with state/strategy 227
        switch (priceCode){
            case CHILDREN:
                _price= new ChildrenPrice();
                break;
            case REGULAR:
                _price= new RegularPrice();
                break;
            case NEW_RELEASE:
                _price= new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String get_title() {
        return _title;
    }

    //move method 402
    public double getCharge(int daysRented) {
        //replace conditional with Polymorphism 255
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
