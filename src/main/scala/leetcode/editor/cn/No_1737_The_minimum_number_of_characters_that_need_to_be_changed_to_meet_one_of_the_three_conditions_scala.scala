package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/1/26 5:41 下午
 * @desc: 1737. 满足三条件之一需改变的最少字符数
 */
object No_1737_The_minimum_number_of_characters_that_need_to_be_changed_to_meet_one_of_the_three_conditions_scala {
  def main(args: Array[String]): Unit = {
    var a = "aba"
    var b = "caa"

    a = "dabadd"
    b = "cda"

    a = "ae"
    b = "b"

    a = "bd"
    b = "a"

    a = "abc"
    b = "bc"

    a = "a"
    b = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"

    val minChar = minCharacters(a, b)
    println(minChar)
  }

  /**
   * 记录两个字符串中的每个字符出现的个数, 然后一次遍历每个字符来满足条件的时候变动的最小操作数.
   *
   * @param a
   * @param b
   * @return: 返回最小的变更操作数
   */
  def minCharacters(a: String, b: String): Int = {
    /**
     * 记录a, b 字符串的每个字母的个数
     */
    val countA = new Array[Int](26)
    val countB = new Array[Int](26)
    val alen = a.length
    val bLen = b.length
    /**
     * dpA(i) 表示a 中小于 i 的字符出现的个数
     */
    val dpA = new Array[Int](26)
    val dpB = new Array[Int](26)

    // 记录每个字符串的每个字符出现的个数
    for (i <- 0 until alen) {
      countA(a.charAt(i) - 'a') += 1
    }

    for (i <- 0 until bLen) {
      countB(b.charAt(i) - 'a') += 1
    }

    // 将每个字符 < 当前字符的个数存放到相关的dp 中
    for (i <- 0 until 26) {
      dpA(i) = (if (i == 0) 0 else dpA(i - 1)) + countA(i)
      dpB(i) = (if (i == 0) 0 else dpB(i - 1)) + countB(i)
    }

    var minOper = Int.MaxValue
    // 遍历每个字符当做目标字符, 求解每个字符的操作次数. 然后求得最小的操作次数
    // 这边只扩展到 24, 因为没有办法让所有字符都大于 z
    for (i <- 0 until 25) {
      // a 中的每个字母严格小于 b 中的每个字母
      minOper = Math.min(minOper, alen - dpA(i) + dpB(i))
      // b 中的每个字母严格小于 a 中的每个字母
      minOper = Math.min(minOper, bLen - dpB(i) + dpA(i))
      // 保证两个字符串中的字母都等于i
      minOper = Math.min(minOper, alen - countA(i) + bLen - countB(i))
    }

    // 判断两个字符
    minOper = Math.min(minOper, alen - countA(25) + bLen - countB(25))

    minOper
  }
}
