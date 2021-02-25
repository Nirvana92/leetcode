package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/4 9:13 上午
 * @desc: 643. 子数组最大平均数 I
 */
object No_643_Maximum_average_number_of_subarrays_I {
  def main(args: Array[String]): Unit = {
    var nums = Array(1, 12, -5, -6, 50, 3)
    var k = 4

    val d = findMaxAverage(nums, k)
    println(d)
  }

  /**
   * 通过窗口滑动来控制长度为k, 然后依次求得平均值. 获得最大的平均值
   *
   * @param nums
   * @param k
   * @return
   */
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    var rIndex = 0

    // 需要注意下可能为负数
    var maxRegionSum = Double.MinValue
    var regionSum = 0
    for (i <- 0 to (nums.length - k)) {
      while (rIndex < nums.length && rIndex - i + 1 <= k) {
        regionSum += nums(rIndex)
        rIndex += 1
      }

      maxRegionSum = Math.max(maxRegionSum, regionSum)

      regionSum -= nums(i)
    }

    maxRegionSum / k
  }
}
