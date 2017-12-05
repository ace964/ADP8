package graphen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AdjListGraph
 * Eine Listen-Implementation fuer ein Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class AdjMatrixGraph implements Graph {
	private int[] _data;
	private byte[][] _matrix;
	protected int _size;
	
	public AdjMatrixGraph() {
		this(15);
	}
	
	public AdjMatrixGraph(int size) {
		_matrix = new byte[size][size];
		_data = new int[size];
		_size = 0;
	}
	
	@Override
	public Pos[] gibNachbarn(Pos pos) {
		List<Pos> nachbarn = new ArrayList<>();
		for(int i = 0; i < _size; i++)
		{
			if(_matrix[pos.gibIndex()][i] != 0)
			{
				nachbarn.add(new Pos(i));
			}
		}
		return nachbarn.toArray(new Pos[nachbarn.size()]);
	}
	
	public Pos fuegeEin(int data) {
		if(_size == _matrix.length)
		{
			vergroessereMatrix();
		}
		_data[_size] = data;
		_size++;
		return new Pos(_size-1);
	}
	
	private void vergroessereMatrix()
	{
		byte[][] newMatrix = new byte[_matrix.length*2][];
		for(int i = 0; i < _matrix.length; i++)
		{
			if(_matrix[i] != null)
				newMatrix[i] = Arrays.copyOf(_matrix[i], _matrix.length*2);
		}
		_matrix = newMatrix;
		_data = Arrays.copyOf(_data, _matrix.length*2);
	}

	@Override
	public void verbinde(Pos posAnfang, Pos posEnde, int distanz) {
		if(_matrix[posAnfang.gibIndex()] == null)
		{
			_matrix[posAnfang.gibIndex()] = new byte[_matrix.length];
		}
		
		if(_matrix[posEnde.gibIndex()] == null)
		{
			_matrix[posEnde.gibIndex()] = new byte[_matrix.length];
		}
		
		_matrix[posAnfang.gibIndex()][posEnde.gibIndex()] = (byte) distanz;
		_matrix[posEnde.gibIndex()][posAnfang.gibIndex()] = (byte) distanz;
	}

	@Override
	public int gibDistanz(Pos posAnfang, Pos posEnde) {
		if(_matrix[posAnfang.gibIndex()][posEnde.gibIndex()] == 0)
			return -1;
		
		return _matrix[posAnfang.gibIndex()][posEnde.gibIndex()];
	}

	@Override
	public int gibData(Pos pos) {
		return _data[pos.gibIndex()];
	}

	@Override
	public int gibAnzahlKnoten()
	{
		return _size;
	}

	@Override
	public List<Pos> gibKnoten()
	{
		List<Pos> list = new ArrayList<>();
		for(int i = 0; i < _size; i++)
		{
			list.add(new Pos(i));
		}
		return list;
	}

}
