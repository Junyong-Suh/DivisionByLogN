#!/bin/bash
javac ${PWD##*/}.java
java ${PWD##*/}
rm *.class
