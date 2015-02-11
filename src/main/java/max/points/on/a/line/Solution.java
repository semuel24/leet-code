package max.points.on.a.line;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */
public class Solution {
	
	public static void main(String [] args) {
		Point p1  = new Point(0,9);
		Point p2  = new Point(138,429);
		Point p3  = new Point(115,359);
		Point p4  = new Point(115,359);
		Point p5  = new Point(-30,-102);
		Point p6  = new Point(230,709);
		Point p7  = new Point(-150,-686);
		Point p8  = new Point(-135,-613);
		Point p9  = new Point(-60,-248);
		Point p10  = new Point(-161,-481);
		Point p11  = new Point(207,639);
		Point p12  = new Point(23,79);
		Point p13  = new Point(-230,-691);
		Point p14  = new Point(-115,-341);
		Point p15  = new Point(92,289);
		Point p16  = new Point(60,336);
		Point p17  = new Point(-105,-467);
		Point p18  = new Point(-105,-467);
		Point p19  = new Point(-90,-394);
		Point p20  = new Point(-184,-551);
		Point p21  = new Point(150,774);
		
		Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21};
		Solution s = new Solution();
		System.out.println("Number of max points on a line is: " + s.maxPoints(points));
	}
	
	public int maxPoints(Point[] points) {
		if(points.length == 1) {
			return 1;
		}
		
		Hashtable<String, Set<Integer>> table = new Hashtable<String, Set<Integer>>();
		for(int i=0; i<points.length; i++) {
			for(int j=i+1; j<points.length; j++) {
				String expn = generateLineExpn(points[i], points[j]);
				Set<Integer> indexs = null;
				if(table.containsKey(expn)) {//update
					indexs = table.get(expn);
					if(!indexs.contains(i)) {//try to store i-th point
						indexs.add(i);
					}
					if(!indexs.contains(j)) {//try to store j-th point
						indexs.add(j);
					}
				} else {//insert new
					indexs = new HashSet<Integer>();
					indexs.add(i);
					indexs.add(j);
					table.put(expn,indexs);
				}
			}
		}

		//go through whole hashtabe and get most voted expression
		int max = 0;
		Set<Integer> indexs = null;
		String expr = "";
		Set<String> exprs = table.keySet();
		for(String _expr : exprs) {
			if(table.get(_expr).size() > max) {
				expr = _expr;
				indexs = table.get(_expr);
				max = indexs.size();
			}
		}
		
//		System.out.println("expression:" + expr);
//		for(Integer i : indexs) {
//			System.out.println("index:" + i + " points (" + points[i].x + "," + points[i].y + ")" + " " + (3.044*points[i].x+9));
//		}
		return max;
	}
	
	/**
	 * y=ax+b
	 * need to handle k=infinity
	 */
	private String generateLineExpn(Point p1, Point p2) {
		String expr = "";
		if(p1.x == p2.x) {
			expr = "x=" + p1.x; 
		} else {
			BigDecimal ydiff = BigDecimal.valueOf(p2.y-p1.y);
			BigDecimal xdiff = BigDecimal.valueOf(p2.x-p1.x);
			BigDecimal k = ydiff.divide(xdiff, 3, RoundingMode.CEILING);
			
			BigDecimal tdiff = BigDecimal.valueOf(p2.x*p1.y - p1.x*p2.y);
			BigDecimal b = tdiff.divide(xdiff, 3, RoundingMode.CEILING);
			expr = k + "x+" + b;
		}
		
		if("3x+9".equalsIgnoreCase(expr)) {
			int i = 0;
		}
		return expr;
	}
}

class Point {
	int x;
	int y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}
}