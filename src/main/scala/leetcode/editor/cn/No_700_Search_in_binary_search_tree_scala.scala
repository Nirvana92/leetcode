package leetcode.editor.cn

/**
 * @author Nirvana
 * @date 2020/11/10 23:28
 *
 * 700. 二叉搜索树中的搜索
 */
object No_700_Search_in_binary_search_tree_scala {
  def main(args: Array[String]): Unit = {
    var queues: mutable.Queue[String] = new mutable.Queue[String]
    queues = queues :+ "哈哈"

    print(queues.dequeue())
    print(queues)
  }

  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null || root.`val` == `val`) {
      return root;
    }

    var queues: mutable.Queue[TreeNode] = mutable.Queue(root)
    while (queues.nonEmpty) {
      val node = queues.dequeue()
      if (node.`val` == `val`) {
        return node
      }

      if (node.left != null) {
        queues = queues :+ node.left
      }

      if (node.right != null) {
        queues = queues :+ node.right
      }
    }

    null
  }
}
