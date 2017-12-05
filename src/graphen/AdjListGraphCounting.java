package graphen;

public class AdjListGraphCounting extends AdjListGraph implements Counter
{

	private long _counter;
	
	public AdjListGraphCounting()
	{
		super();
		_counter = 0;
	}
	
	@Override
	public Pos[] gibNachbarn(Pos pos)
	{
		_counter++;
		return super.gibNachbarn(pos);
	}
	
	@Override
	public int gibDistanz(Pos posAnfang, Pos posEnde)
	{
		_counter++;
		return super.gibDistanz(posAnfang, posEnde);
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
