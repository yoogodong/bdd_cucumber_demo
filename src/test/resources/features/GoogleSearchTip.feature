Feature: Google Search tips
  Scenario: 搜索某个关键词
    Given 打开 Google 搜索页面
    When 搜索 "人工智能"
    Then 页面的标题应该是 "人工智能"
