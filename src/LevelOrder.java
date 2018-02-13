
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);
        while(q.peek() != null) {
          ArrayList<Integer> row = new ArrayList<Integer>();
          int n = q.size();
          for (int i = 0; i < n; i++) {
            TreeNode head = q.poll();
            row.add(head.val);
            if(head.left != null) {
              q.add(head.left);
             }
            if(head.right != null) {
              q.add(head.right);
             }
           }
          result.add(row);
        }
        return result;
    }
}
