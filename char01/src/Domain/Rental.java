package Domain;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public double getCharge() {
        double thisAmount = 0;
        switch (get_movie().get_priceCode()){
            case Movie.REGULAR:
                thisAmount +=2;
                if (get_daysRented()>2){
                    thisAmount += (get_daysRented()-2)*1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                    thisAmount += get_daysRented()*3;

                break;
            case Movie.CHILDRENS:
                thisAmount +=1.5;
                if (get_daysRented()>3){
                    thisAmount += (get_daysRented()-3)*1.5;
                }
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (get_movie().get_priceCode() == Movie.NEW_RELEASE && get_daysRented()>1){
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
