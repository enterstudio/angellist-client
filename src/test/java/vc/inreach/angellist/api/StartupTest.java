package vc.inreach.angellist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartupTest {

    private ObjectMapper objectMapper;
    private String angelJson;
    private String mantisvrJson;
    private String a149311Json;
    private String a149309Json;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());

        angelJson = Resources.toString(Resources.getResource("angel-co.json"), Charsets.UTF_8);
        mantisvrJson = Resources.toString(Resources.getResource("mantisvr-com.json"), Charsets.UTF_8);
        a149311Json = Resources.toString(Resources.getResource("angellist-149311.json"), Charsets.UTF_8);
        a149309Json = Resources.toString(Resources.getResource("angellist-149309.json"), Charsets.UTF_8);
    }

    @Test
    public void angelCo() throws Exception {
        final Startup startup = objectMapper.readValue(angelJson, Startup.class);
        assertNotNull(startup);

        assertFalse(startup.getVideoUrl().isPresent());
        assertFalse(startup.getScreenshots().isEmpty());
        assertFalse(startup.getMarkets().isEmpty());
        assertFalse(startup.getLocations().isEmpty());
        assertTrue(startup.getCreatedAt().isPresent());
    }

    @Test
    public void mantisvrCom() throws Exception {
        final Startup startup = objectMapper.readValue(mantisvrJson, Startup.class);
        assertNotNull(startup);
        assertNotNull(startup.getCompanySize());
        assertNotNull(startup.getVideoUrl());
    }

    @Test
    public void a149311Json() throws Exception {
        final Startup startup = objectMapper.readValue(a149311Json, Startup.class);
        assertNotNull(startup);
        assertFalse(startup.getHighConcept().isPresent());
    }

    @Test
    public void getHidden() throws Exception {
        final Startup startup = objectMapper.readValue(a149309Json, Startup.class);
        assertNotNull(startup);
        assertTrue(startup.getId().isPresent());
        assertTrue(startup.requireHidden());
        assertFalse(startup.getName().isPresent());
    }
}
