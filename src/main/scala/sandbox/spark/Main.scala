package sandbox.spark

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .appName("Yelp playground")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    Seq(1, 2, 3)
      .map(x => (x, x)).toDF("i", "j")
      .show()

    spark.stop()
  }
}
