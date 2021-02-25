package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/2/1 9:51 上午
 * @desc: 5654. 盒子中小球的最大数量
 */
object No_5654_Maximum_number_of_balls_in_the_box {
  def main(args: Array[String]): Unit = {
    var lowLimit = 5
    var highLimit = 15

    lowLimit = 1
    highLimit = 10

    lowLimit = 19
    highLimit = 28

    val result = countBalls(lowLimit, highLimit)
    println(result)
  }

  def countBalls(lowLimit: Int, highLimit: Int): Int = {
    var counts = new Array[Int](46)

    var maxCount = 0
    for (num <- lowLimit to highLimit) {
      var sum = getBitSum(num)
      counts(sum) += 1

      maxCount = Math.max(maxCount, counts(sum))
    }

    maxCount
  }

  def getBitSum(num: Int): Int = {
    var sum = 0
    var tmpNum = num
    while (tmpNum > 0) {
      sum += tmpNum % 10
      tmpNum /= 10
    }

    sum
  }
}
