FROM java:8-jre
MAINTAINER Leandro Pincini <leandropincini@bitbucket.org>

ADD ./target/jm-customer.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/jm-customer.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8889/health || exit 1

EXPOSE 8889
