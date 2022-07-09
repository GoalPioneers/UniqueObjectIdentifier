package goalpioneers.com.uiod.objects.templates;


/**
 * @author Kent Madsen
 * @author Goal Pioneers
 */
public interface CharacterRangeIteratorFacade 
{
    /**
     * 
     * @return
     */
    public char position();
    
    
    /**
     * 
     * @return
     */
    public int relativePosition();
    
    
    /**
     * 
     * @param c
     */
    public void map( char c );
    
    
    
    /**
     * 
     */
    public void next();
    
    
    /**
     * 
     */
    public void previous();
}
