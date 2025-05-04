#!/bin/bash

main_class="$1"

if [ -z "$main_class" ]; then
  echo "❌ No class name provided. Usage: ./run.sh com.dncoyote.leetcode.TwoSum"
  exit 1
fi

echo "▶️ Running: $main_class"
mvn compile exec:java -Dexec.mainClass="$main_class"

