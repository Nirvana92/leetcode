package leetcode.editor.cn

/**
 * @author gzm
 * @date 2021/1/26 5:04 下午
 * @desc: 1736. 替换隐藏数字得到的最晚时间
 */
object No_1736_The_latest_time_obtained_by_replacing_hidden_numbers_scala {
  def main(args: Array[String]): Unit = {
    var time = "2?:?0"
    time = "0?:3?"
    time = "1?:22"

    val str = maximumTime(time)
    println(str)
  }

  def maximumTime(time: String): String = {
    val chars = time.toCharArray
    for (i <- 0 until chars.length) {
      if (chars(i) == '?') {
        if (i == 0) {
          chars(i) = if (chars(i + 1) != '?' && chars(i + 1) > '3') '1' else '2'
        } else if (i == 1) {
          chars(i) = if (chars(i - 1) == '2') '3' else '9'
        } else if (i == 3) {
          chars(i) = '5'
        } else if (i == 4) {
          chars(i) = '9'
        }
      }
    }

    chars.mkString("")
  }
}
