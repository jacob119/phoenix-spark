package com.jacob.phoenix

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameTest {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val df = sqlContext.load(
      "org.apache.phoenix.spark",
      Map("table" -> "TABLE1", "zkUrl" -> "localhost:2181")
    )
    df.show()
  }
}
