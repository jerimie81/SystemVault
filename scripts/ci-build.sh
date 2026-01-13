#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

if [ -d "$ROOT_DIR/.jdk" ]; then
  export JAVA_HOME="$ROOT_DIR/.jdk"
  export PATH="$JAVA_HOME/bin:$PATH"
fi

cd "$ROOT_DIR"

chmod +x ./gradlew

./gradlew clean :app:assembleDebug testDebugUnitTest
