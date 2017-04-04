
/**
 * Write a description of class Movie here.
 * 
 * @author Zainab Hussein
 * @version 3-23-2017
 */
public class Movie implements Comparable<Movie>
{
    // instance variables - replace the example below with your own
    private String Title;
    private String Director;
    private int Year;
    private String Genre;

    /**
     * Constructor for objects of class Movie
     */
    public Movie( String myTitle, String myDirector, int myYear, String myGenre )
    {
        // initialise instance variables
        this.Title = myTitle;
        this.Director = myDirector;
        this.Year = myYear;
        this.Genre = myGenre;
    }
    
    /**
     * public access of Title
     */
    public String getTitle()
    {
        return Title;
    }
    
    /**
     * setting the Title
     */
    public void setTitle( String input )
    {
        this.Title = input;
    }
    
    /**
     * public access of Director
     */
    public String getDirector()
    {
        return Director;
    }
    
    /**
     * setting the Director
     */
    public void setDirector( String input )
    {
        this.Director = input;
    }
    
    /**
     * public access of Genre
     */
    public String getGenre()
    {
        return Genre;
    }
    
    /**
     * setting the Genre
     */
    public void setGenre( String input )
    {
        this.Genre = input;
    }
    
    /**
     * public access of Year
     */
    public int getYear()
    {
        return Year;
    }
    
    /**
     * setting the Genre
     */
    public void setYear( int input )
    {
        this.Year = input;
    }
    
    /**
     * compareTo method to make Movie comparable
     * imposing the order Year, Title, Genre then
     * Director
     */
    @Override
    public int compareTo( Movie m )
    {
        //primitive year to reference type
        Integer classYear = new Integer( this.Year );
        Integer myYear = new Integer( m.Year );
        if( classYear.equals( myYear ) ){
            if( this.Title.equals( m.Title ) ){
                if( this.Genre.equals( m.Genre ) ){
                    return this.Director.compareTo( m.Director );
                }
                else{
                    return this.Genre.compareTo( m.Genre );
                }
            }
            else{
                return this.Title.compareTo( m.Title );
            }
        }
        else{
            return classYear.compareTo( myYear );
        }
    }
    
     /**
     * overide toString method to return string representation of 
     * parameters
     */
    @Override
    public String toString()
    {
        return "(" + Year + " ," + Title + " ," + Genre + " ," 
                    + Director + " )";
    }
}
