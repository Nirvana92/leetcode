package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/1/28 9:35 上午
 * @desc: 1190. Reverse Substrings Between Each Pair of Parentheses
 *
 *        括号内的字符翻转问题.
 */
object No_1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses_scala {

  def main(args: Array[String]): Unit = {
    var s = "(abcd)"
    s = "(u(love)i)"
    s = "(ed(et(oc))el)"
    s = "a(bcdefghijkl(mno)p)q"

    val str = reverseParentheses(s)
    println(str)
  }

  /**
   * 妙不可言的解法. 参考: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/383670/JavaC++Python-Why-not-O(N)/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
   *
   * @param s
   * @return
   */
  def reverseParentheses(s: String): String = {
    // 1. 首先记录每个 ( 对应的 ) 的位置, ) 对应 ( 的位置
    var stack = Stack[Int]()
    var pairs = new Array[Int](s.length)
    for (i <- 0 until s.length) {
      if (s.charAt(i) == '(') {
        stack.push(i)
      }

      if (s.charAt(i) == ')') {
        val j = stack.pop()
        pairs(i) = j
        pairs(j) = i
      }
    }

    // 2. 然后遍历整个字符串. 当碰到 ( 的时候跳转到对应的 ) 的位置. 然后碰到字符直接添加到结果集中。 如此往复直到遍历所有字符
    // 比如: (a(bc)d)
    var buffer = new StringBuilder
    var index = 0
    var dir = 1
    for (i <- s.indices) {
      if (s.charAt(index) == '(' || s.charAt(index) == ')') {
        index = pairs(index)
        dir = -dir
      } else {
        buffer += s.charAt(index)
      }

      index += dir
    }

    buffer.toString()
  }
}
