package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/1/26 9:17 上午
 * @desc
 */
object No_1128_Number_of_equivalent_domino_pairs_scala {
  def main(args: Array[String]): Unit = {
    var dominoes = Array(Array(1, 2), Array(2, 1), Array(3, 4), Array(5, 6))
    val i = numEquivDominoPairs(dominoes)
    println(i)
  }

  def numEquivDominoPairs(dominoes: Array[Array[Int]]): Int = {
    var countMaps: Map[Int, Int] = Map()
    var tmpNum = 0;
    for (x <- dominoes) {
      tmpNum = if (x(0) > x(1)) x(0) * 10 + x(1) else x(1) * 10 + x(0)

      countMaps += (tmpNum -> (countMaps.getOrElse(tmpNum, 0) + 1))
    }

    var numResult = 0
    countMaps.values.foreach(countNum => {
      if (countNum > 1) {
        numResult += countNum * (countNum - 1) / 2
      }
    })

    numResult
  }
}
