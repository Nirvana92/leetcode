package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/8 9:23 上午
 * @desc: 978. 最长湍流子数组
 */
object No_978_Longest_turbulence_subarray_scala {
  def main(args: Array[String]): Unit = {
    var arr = Array(9, 4, 2, 10, 7, 8, 8, 1, 9)
    arr = Array(4, 8, 12, 16)
    arr = Array(100)

    val maxTurbulenceLen = maxTurbulenceSize(arr)
    println(maxTurbulenceLen)
  }

  def maxTurbulenceSize(arr: Array[Int]): Int = {
    if (arr.length < 2) {
      return arr.length
    }

    var maxLen = 0

    var lIndex = 0
    var rIndex = 1
    var preSizeRelation = arr(1) > arr(0)
    while (rIndex < arr.length) {
      while (rIndex + 1 < arr.length
        && arr(rIndex + 1) != arr(rIndex)
        && (arr(rIndex + 1) > arr(rIndex)) == !preSizeRelation) {
        preSizeRelation = !preSizeRelation
        rIndex += 1
      }

      maxLen = Math.max(maxLen, rIndex - lIndex + 1)
      lIndex = rIndex
      rIndex += 1

      if (rIndex < arr.length) {
        preSizeRelation = arr(rIndex) > arr(lIndex)
      }
    }

    maxLen
  }
}
