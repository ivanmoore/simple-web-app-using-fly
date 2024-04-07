#!/usr/bin/env bash
set -e
./gradlew clean test jacocoTestReport pitest
open build/jacocoHtml/index.html && open build/reports/pitest/index.html
