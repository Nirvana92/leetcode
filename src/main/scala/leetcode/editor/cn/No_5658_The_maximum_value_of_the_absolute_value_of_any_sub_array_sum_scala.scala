package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/7 9:27 上午
 * @desc: 5658. 任意子数组和的绝对值的最大值
 *        参考: { @link No_5658_The_maximum_value_of_the_absolute_value_of_any_sub_array_sum}
 */
object No_5658_The_maximum_value_of_the_absolute_value_of_any_sub_array_sum_scala {
  def main(args: Array[String]): Unit = {
    var nums = Array(1, -3, 2, 3, -4)
    nums = Array(2, -5, 1, -4, 3, -2)

    val maxVal = maxAbsoluteSum(nums)
    println(maxVal)
  }

  /**
   * 通过动态规划的方法来处理本题[这种处理方式结果不对]
   *
   * @param nums
   * @return
   */
  def maxAbsoluteSum(nums: Array[Int]): Int = {

    // maxDp[i] : 标识 nums[0...i] 中的和的绝对值最大的结果
    // maxDp[i] = Math.max(Math.abs(nums[i]), Math.abs(maxDp[i-1]+nums[i])) 来遍历求得每个i 的值
    // 然后在遍历求解的过程中记录一个maxVal 来记录和的绝对值的最大结果

    var maxDp = new Array[Int](nums.length)
    var minDp = new Array[Int](nums.length)
    var maxVal = Int.MinValue
    var minVal = Int.MaxValue
    for (i <- 0 until nums.length) {
      maxDp(i) = nums(i)
      minDp(i) = nums(i)
      if (i > 0) {

        maxDp(i) = Math.max(maxDp(i), maxDp(i - 1) + nums(i))
        minDp(i) = Math.min(minDp(i), minDp(i - 1) + nums(i))
      }

      maxVal = Math.max(maxVal, maxDp(i))
      minVal = Math.min(minVal, minDp(i))
    }

    Math.max(Math.abs(maxVal), Math.abs(minVal))
  }
}
