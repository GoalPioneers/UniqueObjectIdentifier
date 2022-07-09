package goalpioneers.com.uiod.objects;


/**
 * @author Kent Madsen
 * @author Goal Pioneers
 */
public interface UOID
{
    /**
     * 
     * @return
     */
    public String saveIdentifier();
    
    
    /**
     * 
     * @return
     */
    public String saveIdentifierReadable();
    
    
    /**
     * 
     * @param Identifier
     */
    public void loadIdentifier( String Identifier );
    
    
    /**
     *
     * @param Identifier
     */
    public void loadIdentifierReadable( String Identifier );
    
    
    /**
     * 
     * @return
     */
    public int getSize();
    
    
    /**
     * 
     * @return
     */
    public int getSizeReadable();
}
