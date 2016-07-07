# AngelList Client

This library provides a simple Java / JVM client that hits the [AngelList API](https://angel.co/api).

So far, the following API calls have been implemented:
* Get a Startup
* Get a Startup's roles
* Get a User
* Get a tag's Startups
* Get a tag's parent tags
* Get a tag's child tags

## Usage

The project can be found in maven central:

```xml
<dependency>
    <groupId>vc.inreach.angellist</groupId>
    <artifactId>angellist-client</artifactId>
    <version>0.0.2</version>
</dependency>
```

The library uses Java8 Optionals and ZonedDateTime objects, so you'll need to make sure the Jersey Client is given an `ObjectMapper` with the requisite modules.

```java
final ObjectMapper objectMapper = Jackson.newObjectMapper();
objectMapper.registerModule(new Jdk8Module());
objectMapper.registerModule(new JavaTimeModule());
final JacksonJaxbJsonProvider jacksonProvider = new JacksonJaxbJsonProvider();
jacksonProvider.setMapper(objectMapper);
final Client client = ClientBuilder.newClient(new ClientConfig(jacksonProvider));
```

Currently the only implementation for the AngellistClient is the HttpAngellistClient which uses [Jersey 2 HTTP client](https://jersey.java.net/documentation/latest/client.html). How very [Dropwizard](http://dropwizard.io)-y.

## Building

Contributing back to the project would be greatly appreciated. The project includes an integration test which hits the live AngelList API with your API key.

Obviously I don't want to commit our key so you need to add the key to `src/test/resources/.angellist_key` and make sure you never commit it!
