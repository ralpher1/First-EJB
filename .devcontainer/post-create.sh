#!/usr/bin/env bash
set -euo pipefail

if [ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]; then
  # shellcheck source=/dev/null
  source "$HOME/.sdkman/bin/sdkman-init.sh"
fi

if ! command -v mvn >/dev/null 2>&1; then
  if command -v sdk >/dev/null 2>&1; then
    tmp_log="$(mktemp)"
    yes | sdk install maven 3.9.6 >"$tmp_log" && cat "$tmp_log"
    rm -f "$tmp_log"
  else
    sudo apt-get update
    sudo apt-get install -y maven
  fi
fi

mvn -B -DskipTests package
