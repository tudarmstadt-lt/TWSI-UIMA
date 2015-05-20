#!/bin/bash

mvn install:install-file -Dfile=./target/SenseAnnotator-0.0.1.jar -DgroupId=de.tudarmstadt.langtech.substituter -DartifactId=SenseAnnotator -Dversion=0.0.1 -Dpackaging=jar
