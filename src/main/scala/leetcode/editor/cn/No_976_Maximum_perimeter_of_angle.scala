package leetcode.editor.cn

/**
 * @author Nirvana
 * @date 2020/11/29 10:57
 */
object No_976_Maximum_perimeter_of_angle {
  def main(args: Array[String]): Unit = {
    var nums = Array(2, 1, 2)

    nums = Array(1, 2, 1)
    nums = Array(3, 2, 3, 4)

    val i = largestPerimeter(nums)
    println(s"ret: $i")
  }

  def largestPerimeter(A: Array[Int]): Int = {
    val array = A.sortWith(_ > _)

    array.foreach(println)

    var maxPerimeter = 0;

    for (i <- 0 until array.length - 2) {
      if (array.apply(i + 2) + array.apply(i + 1) > array.apply(i)) {
        maxPerimeter = array.apply(i) + array.apply(i + 1) + array.apply(i + 2)
        return maxPerimeter;
      }
    }
    maxPerimeter
  }
}
