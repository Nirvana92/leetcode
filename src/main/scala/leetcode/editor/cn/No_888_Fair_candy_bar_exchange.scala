package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/1 9:19 上午
 * @desc: 888. 公平的糖果棒交换
 */
object No_888_Fair_candy_bar_exchange {
  def main(args: Array[String]): Unit = {
    var a = Array[Int](1, 1)
    var b = Array[Int](2, 2)

    a = Array[Int](1, 2)
    b = Array[Int](2, 3)

    a = Array[Int](2)
    b = Array[Int](1, 3)

    a = Array[Int](1, 2, 5)
    b = Array[Int](2, 4)

    val array = fairCandySwap(a, b)
    println(array.mkString(" "))
  }

  def fairCandySwap(a: Array[Int], b: Array[Int]): Array[Int] = {
    val aSum = a.sum
    val bSum = b.sum

    val avg = (aSum + bSum) / 2

    var sets = new mutable.HashSet[Int]()
    a.foreach(entry => sets.add(entry))

    var result = new Array[Int](2)
    b.foreach(entry => {
      var diffVal = bSum - entry
      if (sets.contains(avg - diffVal) && aSum + entry - avg + diffVal == avg) {
        result(0) = avg - bSum + entry
        result(1) = entry
      }
    })

    result
  }
}
