package vc.inreach.angellist.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import io.dropwizard.jackson.Jackson;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import vc.inreach.angellist.api.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Optional;

import static org.junit.Assert.*;

@Ignore
public class HttpAngellistClientIntegrationTest {

    private AngellistClient angellistClient;

    @Before
    public void setUp() throws Exception {
        final String apiKey = Resources.toString(Resources.getResource(".angellist_key"), Charsets.US_ASCII).replaceAll("\\W", "");

        final ObjectMapper objectMapper = Jackson.newObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());
        final JacksonJaxbJsonProvider jacksonProvider = new JacksonJaxbJsonProvider();
        jacksonProvider.setMapper(objectMapper);
        final Client client = ClientBuilder.newClient(new ClientConfig(jacksonProvider));
        client.register(new LoggingFilter());

        angellistClient = new HttpAngellistClient(client, apiKey, "https://api.angel.co");
    }

    @Test
    public void getStartup() throws Exception {
        final Startup startup = angellistClient.get(6702L).get();
        assertNotNull(startup);
    }

    @Test
    public void getStartups() throws Exception {
        final Startups startups = angellistClient.startups(1654, 1);
        assertEquals(50, startups.getPerPage());
        assertEquals(1, startups.getPage());
    }

    @Test
    public void getParentTags() throws Exception {
        final Optional<ParentTags> parentTags = angellistClient.parentTags(1654, 0);
        assertTrue(parentTags.isPresent());
        assertEquals(1, parentTags.get().getParents().size());
        final Tag tag = parentTags.get().getParents().iterator().next();
        assertEquals(1846L, tag.getId());
    }

    @Test
    public void getChildTags() throws Exception {
        final Optional<ChildTags> childTags = angellistClient.childTags(1L, 0);
        assertTrue(childTags.isPresent());
        assertFalse(childTags.get().getChildren().isEmpty());
    }

    @Test
    public void startupsForNonexistentTag() throws Exception {
        final Startups startups = angellistClient.startups(165447892, 1);
        assertEquals(0, startups.getPerPage());
        assertEquals(1, startups.getPage());
        assertEquals(0, startups.getTotal());
        assertEquals(ImmutableList.<Startup>of(), startups.getStartups());
    }

    @Test
    public void getStartupRoles() throws Exception {
        final StartupRoles roles = angellistClient.startupRoles(6702L);
        assertNotNull(roles);
        assertFalse(roles.getStartupRoles().isEmpty());
    }

    @Test
    public void getUser() throws Exception {
        final Optional<User> user= angellistClient.user(1195118L);
        assertTrue(user.isPresent());
        assertEquals("Ben Smith", user.get().requireName());
    }

    @Test
    public void getEntity() throws Exception {
        final Optional<Entity> entity = angellistClient.entity("top10-1");
        final Entity expected = Entity.builder()
                .withId(172110L)
                .withType("Startup")
                .withUrl("https://angel.co/top10-1")
                .build();

        assertEquals(expected, entity.get());
    }
}
