package com.harry.click_debounce_gradle_plugin

import com.google.common.base.Preconditions

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinTask


@Singleton
class ForkJoinExecutor {

  ForkJoinPool forkJoinPool = new ForkJoinPool()
  private final List<ForkJoinTask<?>> subTasks = []

  void execute(Closure task) {
    boolean added = subTasks.add(forkJoinPool.submit(new Runnable() {
      @Override
      void run() {
        task.call()
      }
    }))
    Preconditions.checkState(added, "Failed to add task")
  }

  void waitingForAllTasks() {
    try {
      subTasks*.join()
    } finally {
    }
  }
}
