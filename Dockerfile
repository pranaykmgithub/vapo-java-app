FROM quay.vapo.va.gov/vapo_tst_images/openjdk18-openshift
EXPOSE 8080

#COPY /c/Users/OITAUSMUNJAP0/IdeaProjects/vapo-sample-java-app/target/student.jar student.jar

COPY target/student.jar student.jar

# Separate CMD provides the means to pass JVM args.
ENTRYPOINT ["java"]
CMD ["-jar","student.jar"]
