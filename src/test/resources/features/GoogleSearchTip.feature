Feature: 关键词搜索
  Scenario: 搜索某个关键词
    作为一个用户
    我希望搜索结果页面的标题与我输入的关键词有关
    以便我能确认这些搜索结果是与关键词相关的
    Given 打开 Google 搜索页面
    When 搜索 "人工智能"
    Then 页面的标题应该是 "人工智能"
