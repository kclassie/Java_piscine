#!/bin/sh
# USAGE
# java -cp target edu.school21.printer.app.Program [WHILE COLOR] [ANOTHER COLOR]

rm -rf target

mkdir target

javac -sourcepath src/java `find . -name "*.java"` -d target

cp -R src/resources target

jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

java -jar target/images-to-chars-printer.jar _ X