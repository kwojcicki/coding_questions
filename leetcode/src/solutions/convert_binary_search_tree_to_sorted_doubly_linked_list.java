
package solutions;

class convert_binary_search_tree_to_sorted_doubly_linked_list {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;

        recurse(root);
        first.left = last;
        last.right = first;

        return first;
    }

    public void recurse(Node root){
        if(root == null) return;

        recurse(root.left);

        if(last != null){
            root.left = last;
            last.right = root;
        } else {
            first = root;
        }
        last = root;

        recurse(root.right);
    }
}
