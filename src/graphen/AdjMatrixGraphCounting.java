package graphen;

public class AdjMatrixGraphCounting extends AdjMatrixGraph implements Counter
{

	private long _counter;
	
	public AdjMatrixGraphCounting()
	{
		super();
		_counter = 0;
	}
	
	AdjMatrixGraphCounting(int size)
	{
		super(size);
		_counter = 0;
	}
	
	@Override
	public int gibDistanz(Pos posAnfang, Pos posEnde)
	{
		_counter++;
		return super.gibDistanz(posAnfang, posEnde);
	}
	
	@Override
	public Pos[] gibNachbarn(Pos pos)
	{
		_counter+= super._size;
		return super.gibNachbarn(pos);
	}
	
	
	
	@Override
	public long getCounter()
	{
		return _counter;
	}
	
	@Override
	public void resetCounter()
	{
		_counter = 0;
	}
	
}
