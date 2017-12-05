package dijkstra;

import java.util.List;
import java.util.Random;

import graphen.AdjListGraphCounting;
import graphen.AdjMatrixGraphCounting;
import graphen.Graph;
import graphen.Pos;

public class Benchmark
{
	public static void main(String[] args)
	{
		AdjMatrixGraphCounting matrixGraph = new AdjMatrixGraphCounting();
		AdjListGraphCounting listGraph = new AdjListGraphCounting();
		
		Dijkstra dij = new Dijkstra();
		
		for(int i = 1; i <= 5; i++)
		{
			for(int k = 0; k < Math.pow(10, i); k++)
			{
				matrixGraph.fuegeEin(k);
				listGraph.fuegeEin(k);
			}
			verbinde(matrixGraph, 1000);
			verbinde(listGraph, 1000);

			matrixGraph.resetCounter();
			listGraph.resetCounter();
			
			
			dij.zeigeKuerzesteWegeNach(matrixGraph.gibKnoten().get(0), matrixGraph);
			dij.zeigeKuerzesteWegeNach(listGraph.gibKnoten().get(0), listGraph);
			
			System.out.println(matrixGraph.getCounter() +"\t\t"+listGraph.getCounter());
		}
	}

	private static void verbinde(Graph g, int seed)
	{
		Random r = new Random(seed);
		List<Pos> knoten = g.gibKnoten();
		for(int i = 0; i < knoten.size(); i++)
		{
			for(int k = 0; k < 4; k++)
			{
				int l = r.nextInt(g.gibAnzahlKnoten());
				if(l != i)
				{
					g.verbinde(knoten.get(i), knoten.get(l), r.nextInt(10)+1);
				}
			}
		}
	}
	
}
