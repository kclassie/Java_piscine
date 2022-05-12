#!/bin/sh
# USAGE
# java -cp target edu.school21.logic.app.Program [WHILE COLOR] [ANOTHER COLOR] [PATH TO IMAGE.BMP]

rm -rf target

mkdir target

javac -sourcepath src/java `find . -name "*.java"` -d target
java -cp target edu.school21.printer.app.Program . 0 ../it.bmp