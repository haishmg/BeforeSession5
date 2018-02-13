
public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode a) {
	    ArrayList<Integer> num = new ArrayList<Integer>();
	    while(a != null) {
	        num.add(a.val);
	        a = a.next;
	    }
        return construct(num,0,num.size()-1);
	}
	
	public TreeNode construct(ArrayList<Integer> num, int start, int end) {
	    if(start > end) {
	        return null;
	    }
	    int mid = start + (end-start)/2 ;
	    TreeNode head = new TreeNode(num.get(mid));
	    head.left = construct(num,0,mid-1);
	    head.right = construct(num, mid+1, end);
	    return head;
	}
}
