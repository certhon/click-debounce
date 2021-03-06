package com.harry.click_debounce_gradle_compile;

import java.util.Objects;


public class MethodDescriptor {

  private int access;
  private String name;
  private String desc;

  MethodDescriptor(int access, String name, String desc) {
    this.access = access;
    this.name = name;
    this.desc = desc;
  }

  boolean match(int access, String name, String desc) {
    return this.access == access &&
        Objects.equals(this.name, name) &&
        Objects.equals(this.desc, desc);
  }
}
