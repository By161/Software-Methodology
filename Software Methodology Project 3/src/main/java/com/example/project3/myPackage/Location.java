package myPackage;
/**
 *  The required enum class for location
 *  This class shows all the locations and their constants that identify them.
 * @author Brandon Yuen, Anna Kryzanekas
 */
public enum Location {
    BRIDGEWATER ("08807", "SOMERSET"),
    EDISON ("08837", "MIDDLESEX"),
    FRANKLIN ("08873", "SOMERSET"),
    PISCATAWAY ("08854", "MIDDLESEX"),
    SOMERVILLE ("08876", "SOMERSET");

    private final String zipcode;
    private final String county;

    /**
     * Constructor method for location.
     * creates an object called Location to help the other classes identify what location the member is at.
     * @param zipcode The location's zipcode
     * @param county The location's county
     */
    Location(String zipcode, String county){
        this.zipcode = zipcode;
        this.county = county;
    }

    /**
     * Getter method for the location's county
     * @return the location's county
     */
    public String getCounty(){
        return this.county;
    }

    /**
     * Getter method for the location's zipcode
     * @return the location's Zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * toString method for location
     * helps to print out information for the corresponding location.
     * @return location information in a String format 
     */
    @Override
    public String toString(){
        return (this.name());
        }
}

