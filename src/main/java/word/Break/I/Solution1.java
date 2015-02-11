package word.Break.I;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author yaoxu
 *
 */
public class Solution1 {

	public static void main(String [] args) {
		Solution1 s = new Solution1();
		String[] dictwords = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		HashSet<String> dict = new HashSet<String>();
		for(String _word : dictwords) {
			dict.add(_word);
		}
		System.out.println(s.ladderLength("hot", "dog", dict));
	}
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> camps = new LinkedList<String>();
        camps.add(start);
		
        if(start.equalsIgnoreCase(end)) {
        	return 0;
        }
        
        int count = 2;
        while(!moveOneStepForward(camps, dict, end)) {
        	if(camps.size() == 0){//can't find a path
        		return 0;
        	}
        	count ++;
        }
        return count;
    }
	
	//return true if target is found
	private boolean moveOneStepForward(Queue<String> camps, HashSet<String> availableNodes, String target) {
		
		int qSize = camps.size();
		for(int k = 0; k<qSize; k++){
			String popedNode = camps.poll();
			char [] poped = popedNode.toCharArray();
			for(int i=0; i<poped.length; i++) {
				for(char j = 'a'; j<='z'; j++) {
					if(poped[i] == j) {
						continue;
					}
					
					char tmpChar = poped[i];
					poped[i] = j;
					String tmpStr = String.valueOf(poped);
					if(tmpStr.equalsIgnoreCase(target)) {
						return true;
					}
					if(availableNodes.contains(tmpStr)) {
						availableNodes.remove(tmpStr);
						camps.add(tmpStr);
					}
					poped[i] = tmpChar;
				}
			}
		}
		return false;
	}
	
	
}
