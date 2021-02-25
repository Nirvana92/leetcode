package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/7 9:17 上午
 * @desc: 5657. 唯一元素的和
 */
object No_5657_Sum_of_unique_elements_scala {
  def main(args: Array[String]): Unit = {
    var nums = Array[Int](1, 2, 3, 2)
    nums = Array(1, 1, 1, 1, 1)
    nums = Array(1, 2, 3, 4, 5)

    val sum = sumOfUnique(nums)
    println(sum)
  }

  def sumOfUnique(nums: Array[Int]): Int = {
    var map = new mutable.HashMap[Int, Int]()

    nums.foreach(num => {
      map.put(num, map.getOrElse(num, 0) + 1)
    })

    var sums = 0
    nums.foreach(num => {
      if (map.getOrElse(num, 0) == 1) {
        sums += num
      }
    })

    sums
  }
}
