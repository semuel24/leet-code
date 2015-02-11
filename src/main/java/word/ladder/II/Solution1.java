package word.ladder.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class Solution1 {

	public static void main(String [] args) {
		Solution1 ii = new Solution1();
//		String start = "qa";
//		String end = "sq";
//		String[] dictwords = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		
		String start = "cet";
		String end = "ism";
		String [] dictwords = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm",
							   "ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug",
							   "fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion",
							   "six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed",
							   "tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod",
							   "fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop",
							   "tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho",
							   "tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
//		String start = "a";
//		String end = "c";
//		String[] dictwords = {"a", "b", "c"};
//		
//		String start = "hit";
//		String end = "cog";
//		String[] dictwords = {"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		for(String _word : dictwords) {
			dict.add(_word);
		}
		
		ArrayList<ArrayList<String>> solution = ii.findLadders(start, end, dict);
		System.out.println(solution);
	}
	
	
	public ArrayList<ArrayList<String>> findLadders(
			String start, 
			String end,
			HashSet<String> dict) {
		
		HashSet<String> used = new HashSet<String>();
		ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();
		
		int steps = ladderLength(start, end, (HashSet<String>)dict.clone());
		if(steps == 0) {
			return solution;
		}
		findLadders(start, start, end, dict, used, solution, steps);
		filterSolution(solution);
		return solution;
	}
	
	private void findLadders(
			final String originalStart,
			final String start, 
			final String end,
			final HashSet<String> dict, 
			final HashSet<String> used, 
			final ArrayList<ArrayList<String>> solution,
			final int maxLength) {

		if(start == null || end == null || dict == null || used == null) {
			throw new RuntimeException("Invalid input !");
		}
		
		if(used.size() >= maxLength) {
			return;
		}
		
		List<String> nexts = tryNextWords(start, end, dict, used); 
		for(String _next : nexts) {
			if(_next.equalsIgnoreCase(end)) {//test if found result
				ArrayList<String> s = new ArrayList<String>();
				s.add(originalStart);
				for(String _w : used) {
					s.add(_w);
				}
				s.add(_next);
				solution.add(s);
				continue;//continue to find next solution
			}
			
			if(dict.contains(_next) && !used.contains(_next)) {//try a new word in dictionary
				used.add(_next);
				findLadders(originalStart, _next, end, dict, used, solution, maxLength);
				used.remove(_next);
			}
		}
	} 
	
	private List<String> tryNextWords(
			final String word, 
			final String end,
			final HashSet<String> dict,
			final HashSet<String> used) {
		
		if(word == null || used == null) {
			return null;
		}
		
		List<String> nexts = new ArrayList<String>();
		char[] chars = word.toCharArray();
		
		for(int i=0; i<chars.length; i++) {//loop every char in this word
			for(char j='a'; j<'a'+25; j++) {//try every other possible letter to change this char
				if(chars[i] == j) {
					continue;
				}
				
				char tmp = chars[i];
				chars[i] = j;
				String tmpWord = String.copyValueOf(chars);
				if(!used.contains(tmpWord) && 
					(end.equalsIgnoreCase(tmpWord) || dict.contains(tmpWord))) {
					nexts.add(tmpWord);
				}
				chars[i] = tmp;
			}
		}	
		return nexts;
	}
	
	private void filterSolution(ArrayList<ArrayList<String>> solution) {
		int minLength = Integer.MAX_VALUE;
		for(ArrayList<String> s : solution) {
			if(s.size() < minLength) {
				minLength = s.size();
			}
		}
		Iterator<ArrayList<String>> it = solution.iterator();
		while(it.hasNext()) {
			if(it.next().size() > minLength) {
				it.remove();
			}
		}
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
