
public class wordladder {
    class StrNode{
        String str;
        int distance;
        StrNode(String str,int distance){
            this.str=str;
            this.distance=distance;
        }
    }
	public int ladderLength(String start, String end, ArrayList<String> dictV) {
	    if(start.equals(end)){
	        return 1;
	    }
	    Queue<StrNode> qe = new ArrayDeque<>();
	    int min=Integer.MAX_VALUE;
	    Map<String,Boolean> mp = new HashMap<>();
	    qe.add(new StrNode(start,1));
	    mp.put(start,true);
	    while(!qe.isEmpty()){
	        StrNode st = qe.poll();
	        /*System.out.println(st.str + st.distance());*/
	        int distance = st.distance;
	        if(changeString(st.str,end)){
	            min = Math.min(min, distance+1);
	        }
	        Iterator<String> it = dictV.iterator();
	        while(it.hasNext()){
	            String pr = it.next();
	            if(!mp.containsKey(pr) && changeString(st.str,pr)){
	                mp.put(pr,true);
	                qe.add(new StrNode(pr,distance+1));
	            }
	        }
	    }
	    if(min!=Integer.MAX_VALUE){
	        return min;
	    }
	    return 0;
	    
	}
	public boolean changeString(String dictVstr , String end){
	    int i=0;
	    int count=0;
	    while(i<end.length()){
	        if(dictVstr.charAt(i)!=end.charAt(i)){
	            count++;
	        }
	        if(count==2){
	            return false;
	        }
	        i++;
	    }
	    return true;
	    
	}
}
