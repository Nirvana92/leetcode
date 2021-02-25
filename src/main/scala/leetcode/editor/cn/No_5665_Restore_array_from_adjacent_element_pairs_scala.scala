package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/1 10:25 上午
 * @desc: 5665. 从相邻元素对还原数组
 */
object No_5665_Restore_array_from_adjacent_element_pairs_scala {
  def main(args: Array[String]): Unit = {
    var adjacentPairs = Array.ofDim[Int](2, 3)

    val array = restoreArray(adjacentPairs)
    println(array.mkString(" "))
  }

  def restoreArray(adjacentPairs: Array[Array[Int]]): Array[Int] = {
    //    var queue = new mutable.PriorityQueue[Info](new Ordering[Info]() {
    //      override def compare(x: Info, y: Info): Int = x.in.compareTo(y.in)
    //    })
    null
  }

  class Info(initNum: Int, initIn: Int) {
    // 目标数字
    var num: Int = initNum
    // 关联度数
    var in: Int = initIn
  }

}
