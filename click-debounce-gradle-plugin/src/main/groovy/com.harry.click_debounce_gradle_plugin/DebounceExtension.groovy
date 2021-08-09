package com.harry.click_debounce_gradle_plugin

class DebounceExtension {
  static final String NAME = "debounce"
  boolean loggable
  Map<String, List<String>> exclusion = [:]
}
