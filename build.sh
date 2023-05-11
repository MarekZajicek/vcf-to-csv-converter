#!/bin/sh

mvn clean package

cp target/vcf-to-csv-converter-1.0-jar-with-dependencies.jar target/vcf-to-csv-converter.jar

rm target/vcf-to-csv-converter-1.0-jar-with-dependencies.jar
rm target/vcf-to-csv-converter-1.0.jar


