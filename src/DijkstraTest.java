import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DijkstraTest {
	
	Graph _graph;
	Dijkstra _dijkstra;
	public DijkstraTest() {
		_graph = (Graph) new AdjListGraph();
		_dijkstra = new Dijkstra();
	}
	@Test
	public void test() {
		Pos[] alleKnoten = erstelleTestGraph();
		_dijkstra.zeigeKuerzesteWegeNach(alleKnoten[6], _graph);
	}
	
	public Pos[] erstelleTestGraph() {
		Pos pos0 = _graph.fuegeEin('A');
		Pos pos1 = _graph.fuegeEin('B');
		Pos pos2 = _graph.fuegeEin('C');
		Pos pos3 = _graph.fuegeEin('D');
		Pos pos4 = _graph.fuegeEin('E');
		Pos pos5 = _graph.fuegeEin('F');
		Pos pos6 = _graph.fuegeEin('G');
		
		_graph.verbinde(pos0,pos1,4);
		_graph.verbinde(pos0,pos6,5);
		_graph.verbinde(pos0,pos5,10);
		
		_graph.verbinde(pos1,pos2,7);
		_graph.verbinde(pos1,pos6,2);
		
		_graph.verbinde(pos2,pos3,12);
		_graph.verbinde(pos2,pos6,1);
		
		_graph.verbinde(pos3,pos4,4);
		
		_graph.verbinde(pos4,pos5,3);
		_graph.verbinde(pos4,pos6,8);
		
		_graph.verbinde(pos5,pos6,4);
		return new Pos[] {pos0, pos1, pos2, pos3, pos4, pos5, pos6}; //gebe start pos zurueck
	}
	
	@Test
	public void mehrereZufallsTests() {
		zufallsTest(10);
		zufallsTest(100);
		zufallsTest(1000);
		zufallsTest(10000);
		zufallsTest(100000);	
	}
	
	private void zufallsTest(int anzahlKnoten) {
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i=0; i<anzahlKnoten; i++) {
			randomNumbers.add(i);
		}
		Collections.shuffle(randomNumbers);
		
		Pos[] positionen = new Pos[anzahlKnoten];
		for (int i=0; i < anzahlKnoten; i++) {
			positionen[i] = _graph.fuegeEin(randomNumbers.get(0));
		}
	}
	
	
}
