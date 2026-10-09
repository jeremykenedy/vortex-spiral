#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
OUT="$ROOT/build/tests"
mkdir -p "$OUT"
javac -source 8 -target 8 -d "$OUT" \
  "$ROOT/src/com/jeremykenedy/vortexspiral/VortexOptions.java" \
  "$ROOT/src/com/jeremykenedy/vortexspiral/SettingsValues.java" \
  "$ROOT/tests/VortexOptionsTest.java"
java -ea -cp "$OUT" com.jeremykenedy.vortexspiral.VortexOptionsTest
python3 -m unittest -v tests.test_installer
