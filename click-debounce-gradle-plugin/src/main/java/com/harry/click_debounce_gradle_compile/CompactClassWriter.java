package com.harry.click_debounce_gradle_compile;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;


public class CompactClassWriter extends ClassWriter {

  public CompactClassWriter(ClassReader classReader, int flags) {
    super(classReader, flags);
  }

  @Override protected String getCommonSuperClass(final String type1, final String type2) {
    Class<?> c, d;
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      c = Class.forName(type1.replace('/', '.'), true, classLoader);
      d = Class.forName(type2.replace('/', '.'), true, classLoader);
    } catch (Exception e) {
      return "java/lang/Object";
    }
    if (c.isAssignableFrom(d)) {
      return type1;
    }
    if (d.isAssignableFrom(c)) {
      return type2;
    }
    if (c.isInterface() || d.isInterface()) {
      return "java/lang/Object";
    } else {
      do {
        c = c.getSuperclass();
      } while (!c.isAssignableFrom(d));
      return c.getName().replace('.', '/');
    }
  }
}

