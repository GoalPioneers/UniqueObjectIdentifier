package goalpioneers.com.uiod.objects;

/**
 * @author Kent Madsen
 * @author Goal Pioneers
 */
public class LineSeparator 
{
    /**
     * 
     */
    public LineSeparator()
    {
        this('-', 
             5 );
    }
    
    /**
     * 
     * @param seperatorCharacter
     */
    public LineSeparator( char seperatorCharacter )
    {
        this( seperatorCharacter, 
              5 );
    }
    
    
    /**
     * 
     * @param separatorCharacter
     * @param lengthForSeparation
     */
    public LineSeparator( char separatorCharacter, 
                          int lengthForSeparation )
    {
        this.setSeparator(
                separatorCharacter 
        );
        
        this.setLengthForSeparation(
                lengthForSeparation 
        );
    }
    
    
    // Variables
    /**
     * 
     */
    private char separator;
    
    
    /**
     * 
     */
    private int lengthForSeparation;
    
    
    // Code
    /**
     * 
     * @param index
     * @return
     */
    public boolean shouldSeparate( int index )
    {
        return ( index % this.getLengthForSeparation() ) == 0;
    }
    
    
    // Accessor
    /**
     * 
     * @return
     */
    public char getSeparator() 
    {
        return separator;
    }
    
    
    /**
     * 
     * @param seperator
     */
    public void setSeparator( char seperator ) 
    {
        this.separator = seperator;
    }
    
    
    /**
     * 
     * @return
     */
    public int getLengthForSeparation() 
    {
        return lengthForSeparation;
    }
    
    
    /**
     * 
     * @param lengthForSeperation
     */
    protected void setLengthForSeparation( int lengthForSeperation ) 
    {
        this.lengthForSeparation = lengthForSeperation;
    }
}
