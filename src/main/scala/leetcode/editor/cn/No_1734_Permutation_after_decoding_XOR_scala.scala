package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/1/26 4:00 下午
 * @desc: 1734. 解码异或后的排列
 */
object No_1734_Permutation_after_decoding_XOR_scala {
  def main(args: Array[String]): Unit = {
    var encoded = Array(3, 1)
    encoded = Array(6, 5, 4, 6)

    val results = decode(encoded)
    // 中间通过 空格隔离开打印
    println(results.mkString(" "))
  }

  /**
   *
   * @param encoded
   * @return
   */
  def decode(encoded: Array[Int]): Array[Int] = {
    val len = encoded.length + 1
    val perm = new Array[Int](len)
    var totalXor = 0;
    // 遍历 1~len 拿到所有数据的异或和
    for (i <- 1 to len) {
      // 异或
      totalXor ^= i
    }

    // 然后遍历 encoded 隔一个拿一个数据进行异或
    var otherXor = 0;
    for (i <- 1 until len if i % 2 == 1) {
      otherXor ^= encoded(i)
    }

    // 这一步拿到原数组的第一个数
    perm(0) = totalXor ^ otherXor
    // 然后通过加密数组求出原数组
    for (i <- 1 until len) {
      perm(i) = perm(i - 1) ^ encoded(i - 1)
    }

    perm
  }
}
