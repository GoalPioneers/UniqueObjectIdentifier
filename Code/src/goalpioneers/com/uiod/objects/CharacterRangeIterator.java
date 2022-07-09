package goalpioneers.com.uiod.objects;

import goalpioneers.com.uiod.objects.templates.CharacterRangeIteratorFacade;


/**
 * @author Kent Madsen
 * @author Goal Pioneers
 */
public class CharacterRangeIterator 
    implements CharacterRangeIteratorFacade
{
    // Constructors
    /**
     * 
     */
    public CharacterRangeIterator()
    {
        
    }
    
    
    /**
     * 
     * @param value
     */
    public CharacterRangeIterator( char value )
    {
        super();
        this.map( value );
    }
    
    
    // Variables
    /**
     * 
     */
    private int value = -1;
    
    private static char begin = 'a'; 
    private static char end = 'z';
    
    // Code
    /**
     * 
     * @param c
     */
    @Override 
    public void map( char c )
    {
        if( this.isWithinRange( c ) )
        {
            int position = (int)c - this.startAlphabetAt();
            this.setValue( position );
        }
    }
    
    
    /**
     * retrieves the appropiate character that are associated with the number. 
     * converts it from relative to the actual id for a given character in
     * the alphabet
     * @return
     */
    @Override
    public char position()
    {
        int r = startAlphabetAt() + this.getValue();
        return (char) r;
    }
    
    
    /**
     * 
     * @return
     */
    @Override
    public int relativePosition() 
    {
        return this.value;
    }
    
    
    /**
     * 
     */
    @Override
    public void next() 
    {
        int r = this.value + 1;
        
        int range = this.endAlphabetAt() - this.startAlphabetAt();
        
        if( r > ( range ) )
        {
            r = r % ( range + 1 );
        }
        
        this.setValue( r );
    }
    
    
    /**
     * 
     */
    @Override
    public void previous() 
    {
        int i = this.value - 1;
        int range = this.endAlphabetAt() - this.startAlphabetAt();
        
        if( i < 0 )
        {
            i = (range + 1) + i;
        }
        
        this.setValue( i );
    }
    
    
    /**
     * 
     * @param c
     * @return
     */
    protected boolean isWithinRange( char c )
    {
        // Convert Character to lowercase
        char C = Character.toLowerCase( c );
        
        // Character Range Limits
        boolean leftLimit  = ( begin <= C );
        boolean rightLimit = ( end >= C );
        
        boolean completeValue = false;
        
        if( leftLimit && rightLimit )
        {
            return !completeValue;
        }
        
        return completeValue;
    }
    
    
    /**
     * 
     * @return
     */
    protected int startAlphabetAt()
    {
        char c = begin;
        return ( int )c;
    }
    
    
    /**
     * 
     * @return
     */
    protected int endAlphabetAt()
    {
        char c = end;
        return ( int )c;
    }
    
    
    // Accessors
    /**
     * 
     * @return
     */
    public final int getValue() 
    {
        return value;
    }
    
    
    /**
     * 
     * @param value
     */
    protected final void setValue( int value ) 
    {
        this.value = value;
    }
    
    
    /**
     * 
     * @return
     */
    public boolean isNotInitialised()
    {
        boolean complete = false;
        
        if( this.getValue() == -1 )
        {
            complete = !complete;
        }
        
        return complete;
    }
}
