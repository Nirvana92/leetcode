package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/1/28 9:02 上午
 * @desc: 724. 寻找数组的中心索引
 */
object No_724_Find_the_center_index_of_the_array_scala {
  def main(args: Array[String]): Unit = {
    var nums = Array(1, 7, 3, 6, 5, 6)
    nums = Array(1, 2, 3)

    val index = pivotIndex(nums)
    println(index)
  }

  def pivotIndex(nums: Array[Int]): Int = {
    var sums = 0

    nums.foreach(sums += _)
    var leftSum = 0
    for (i <- nums.indices) {
      sums -= nums(i)

      if (sums == leftSum) {
        return i;
      }

      leftSum += nums(i)
    }

    -1
  }
}
