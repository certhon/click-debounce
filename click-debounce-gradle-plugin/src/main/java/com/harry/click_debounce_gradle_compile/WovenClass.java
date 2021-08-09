package com.harry.click_debounce_gradle_compile;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


public class WovenClass implements Serializable {
  private static final long serialVersionUID = 211794679952616432L;

  public String className;
  public Set<String> debouncedMethods = new LinkedHashSet<>();

  WovenClass(String className) {
    this.className = className;
  }

  void addDebouncedMethod(String methodSignature) {
    debouncedMethods.add(methodSignature);
  }

  public boolean hasDebouncedMethod() {
    return debouncedMethods.size() > 0;
  }
}
