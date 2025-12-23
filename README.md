# Polyglot Lab 🧪
> "Once you stop learning, you start dying." — *Albert Einstein*

This repository serves as my central research hub for exploring and mastering diverse technologies including **Java**, **Python**, **AWS**, and **Modern Web Frameworks**. 

---

## 📂 Directory Structure

I have organized my research into logical modules to keep the "Polyglot" approach clean and maintainable:

```text
polyglot-lab/
├── ☁️ aws-cloud/               # Infrastructure, Security & Cloud-native configs
│   ├── AWSOrganizationsSCP/    # Service Control Policy (SCP) research
│   └── CloudFormationReview/   # EC2 Spot instance automation
│
├── 🍃 spring-boot/              # Spring ecosystem & Enterprise messaging
│   ├── activemq-receiver/      # Message broker implementation (v3.3.5)
│   ├── activemq-sender/        # Message broker implementation (v3.3.5)
│   ├── SpringBootLogging/      # Logback & FileRollingAppender tests
│   ├── SpringBootSoapClient/   # JAXB/WSDL client research (Java 25)
│   ├── SpringBootSoapWebService/ # SOAP service implementation
│   ├── springbootwebflux/      # Reactive programming experiments
│   ├── gs-accessing-data-mysql/
│   └── gs-scheduling-tasks/
│
├── ☕ java-projects/            # Core Java, Algorithms & Micro-frameworks
│   ├── SecureHashAlgorithm/    # Security & Hashing (Migrated to JUnit 5)
│   ├── fork-join-framework/    # Concurrency & Parallelism research
│   ├── date-manipulation/      # Timezone & Date-time logic
│   ├── UrlDecoderEncoder/      # Utility logic for URL processing
│   └── micronaut-app/          # Experiments with Micronaut framework
│
├── 🌐 web-frontend/             # UI & Modern Web Frameworks
│   ├── turborepo/               # NextJS / Monorepo architecture
│   └── Thymeleaf/               # Server-side Java templates
└── README.md
```
## 🛠 Project Maintenance
The SOAP and ActiveMQ projects are part of my "Living Code" initiative—they are continuously maintained and upgraded to the latest stable library releases to test backward compatibility and migration paths.

## 📝 Release & Migration Notes

#### 2025.12.23
- [x] Rename repository to `polyglot-lab`.
- [x] Implement categorized directory structure.
- [x] Update Git remote URLs and local environment configurations.
- [x] Refactor root documentation for better project navigation.

#### 2024.08.15
- [x] Upgraded: Soap Server and Client to Spring Boot 3.3.2.

#### 2024.06.01
- [x] Upgraded: Soap Server and Client to Spring Boot 3.3.0.

#### 2024.04.01
- [x] Migration: Successfully moved SOAP projects from Spring Boot 2.7.18 to 3.2.5.

**Migration Workflow:**

Updated dependency versions based on 2.7.

Executed OpenRewrite for automated migration.

Shifted Spring Boot version to 3.x.

POJO Generation: Upgraded jaxb2-maven-plugin for XSD-based objects.

WSDL Migration: Switched from maven-jaxb2-plugin to jaxb-maven-plugin for modern Java compatibility.

