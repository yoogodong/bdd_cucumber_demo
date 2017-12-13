Feature: 实现文本类型到Java 类型的转换

  Scenario: 转化成 List<String>
    Given 有如下几种水果"苹果/橘子/香蕉/葡萄"
    Then 列表的长度是 4

  Scenario: 转化成 List<String>
    Given 有如下几种水果：
      | 苹果 | 凤梨 | 猕猴桃 | 香瓜 | 番石榴 |
    Then 列表的长度是 5

  Scenario: 转化成日期类型
    Given 我的生日 "1978-06-23"
    Then  年月日分别是"1978/6/23"

  Scenario: 转化成指定类型，也就是反序列化
    Given 点的坐标 "30/50"
    Then 横坐标是 30, 纵坐标是 50

  Scenario: 转化成指定类型的多个实例
    注意这里数据表的第一列要和目标类型的field 名称匹配
    Given 点的坐标如下
    |x|1|11|111|
    |y|2|22|222|
    Then 应该有3个点
    And 第1个点的坐标是1和2
    And 第2个点的坐标是11和22
    And 第3个点的坐标是111和222



