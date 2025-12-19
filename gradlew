#!/usr/bin/env sh
set -e

# Gradle wrapper launcher (minimal, portable)
DIRNAME=`dirname "$0"`
CLASSPATH="$DIRNAME/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$CLASSPATH" ]; then
  echo "Missing wrapper jar: $CLASSPATH"
  exit 1
fi

if [ -z "$JAVA_HOME" ]; then
  _java=java
else
  _java="$JAVA_HOME/bin/java"
fi

exec "$_java" -cp "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
