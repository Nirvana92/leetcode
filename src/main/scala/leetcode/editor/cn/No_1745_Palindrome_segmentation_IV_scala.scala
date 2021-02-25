package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/2 5:48 下午
 * @desc: 1745. 回文串分割 IV
 */
object No_1745_Palindrome_segmentation_IV_scala {
  def main(args: Array[String]): Unit = {
    var s = "bcbddxy"

    val bool = checkPartitioning(s)
    println(bool)
  }

  def checkPartitioning(s: String): Boolean = {
    val len = s.length
    var dp = Array.ofDim[Boolean](len, len)
    for (i <- 0 until len) {
      dp(i)(i) = true;

      if (i + 1 < len) {
        dp(i)(i + 1) = s.charAt(i) == s.charAt(i + 1)
      }
    }
    for (l <- (0 until len - 2).reverse) {
      for (r <- l + 2 until len) {
        dp(l)(r) = s.charAt(l) == s.charAt(r) && dp(l + 1)(r - 1)
      }
    }

    for (l <- 1 until len - 1) {
      for (r <- l until len - 1) {
        if (dp(0)(l - 1) && dp(l)(r) && dp(r + 1)(len - 1)) {
          return true
        }
      }
    }

    false
  }
}
