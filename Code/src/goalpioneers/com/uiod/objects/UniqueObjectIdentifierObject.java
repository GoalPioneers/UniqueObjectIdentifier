package goalpioneers.com.uiod.objects;


import goalpioneers.com.uiod.objects.templates.CharacterRangeIteratorFacade;

import java.util.ArrayList;
import java.util.List;


/**
 * Unique Object Identifier Object
 * @author Kent Madsen
 * @author Goal Pioneers
 */
public class UniqueObjectIdentifierObject 
    implements UOID
{
    // Constructors
    /**
     * 
     */
    public UniqueObjectIdentifierObject( int number_of_counters )
    {
        this( number_of_counters, 
              new LineSeparator() );
    }
    
    
    /**
     * 
     * @param number_of_counters
     * @param separator
     */
    public UniqueObjectIdentifierObject( int number_of_counters,
                                         LineSeparator separator )
    {
        this.counters = new ArrayList<>();
        
        this.insertCounter( number_of_counters );
        this.setSeparator( separator );
    }
    
    // Variables
    /**
     * 
     */
    private List<CharacterRangeIteratorFacade> counters = null;
    
    /**
     * 
     */
    private LineSeparator separator = null;
    
    private static char begin = 'a';
    
    
    // Code
    /**
     * 
     * @param num
     */
    protected void insertCounter( int num )
    {
        int x;
        
        for( x = 0; 
             x < num; 
             x++ )
        {
            this.counters.add(
                    new CharacterRangeIterator( 
                            this.begin 
                    )
            );
        }
    }
    
    
    /**
     * 
     * @param num
     */
    protected void removeCounter( int num )
    {
        int x;
        
        int size = this.getCounters().size() - 1;
        
        List<CharacterRangeIteratorFacade> list = this.getCounters();
        
        for( x = 0;
             x < num; 
             x++ )
        {
            int idx = size - x;
            list.remove( idx );
        }
    }
    
    
    /**
     * 
     * @return
     */
    @Override
    public String saveIdentifier() 
    {
        return this.toStringMachine();
    }
    
    
    /**
     * 
     * @return
     */
    @Override
    public String saveIdentifierReadable() 
    {
        return this.toString();
    }
    
    
    /**
     * 
     * @param Identifier
     */
    @Override
    public void loadIdentifier( String Identifier ) 
    {
        
    }
    
    
    /**
     * 
     * @param Identifier
     */
    @Override
    public void loadIdentifierReadable( String Identifier ) 
    {
        
    }
    
    
    /**
     * 
     * @return
     */
    @Override
    public int getSize()
    {
        return this.getCounters().size();
    }
    
    
    /**
     * 
     * @return
     */
    @Override
    public int getSizeReadable() 
    {
        String readableLine = this.toString();
        return readableLine.length();
    }
    
    
    // Accessors
    /**
     * 
     * @return
     */
    public List<CharacterRangeIteratorFacade> getCounters() 
    {
        return counters;
    }
    
    
    /**
     * 
     * @param counters
     */
    public void setCounters( List<CharacterRangeIteratorFacade> counters ) 
    {
        this.counters = counters;
    }
    
    
    /**
     * 
     * @return
     */
    public LineSeparator getSeparator() 
    {
        return separator;
    }
    
    
    /**
     * 
     * @param separator
     */
    protected void setSeparator( LineSeparator separator) 
    {
        this.separator = separator;
    }
    
    
    /**
     * 
     * @return 
     */
    @Override
    public final String toString() 
    {
        StringBuilder builder = new StringBuilder();
        
        int idx;
        int length = this.getCounters().size();
        int length_limit = length - 1;
        
        for( idx = 0; 
             idx < length; 
             idx++ )
        {
            boolean seperate = this.separator.shouldSeparate( idx );
            
            boolean min = idx > 0;
            boolean max = !( idx == length_limit );
            
            if( seperate && min && max)
            {
                builder.append( this.separator.getSeparator() );
            }
            
            CharacterRangeIteratorFacade current = this.getCounters().get( idx );
            builder.append( current.position() );
        }
        
        return builder.toString();
    }
    
    
    /**
     * 
     * @return
     */
    public final String toStringMachine()
    {
        StringBuilder builder = new StringBuilder();
    
        int idx;
        int length = this.getCounters().size();
    
        for( idx = 0;
             idx < length;
             idx++ )
        {
            CharacterRangeIteratorFacade current = this.getCounters().get( idx );
            builder.append( current.position() );
        }
    
        return builder.toString();
    }
}
