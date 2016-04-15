package vc.inreach.angellist.client;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vc.inreach.angellist.api.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Optional;

public class HttpAngellistClient implements AngellistClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAngellistClient.class);

    private static final String PREFIX = "/1/";
    private static final String STARTUP = PREFIX + "startups/{id}";
    private static final String STARTUP_ROLES = STARTUP + "/roles";
    private static final String USER = PREFIX + "users/{id}";
    private static final String STARTUPS = PREFIX + "tags/{tag}/startups";
    private static final String TAG_PARENTS = PREFIX + "tags/{tag}/parents";
    private static final String TAG_CHILDREN = PREFIX + "tags/{tag}/children";
    private static final String ID = "id";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String PAGE = "page";
    private static final String TAG = "tag";
    private static final String SLUGS = PREFIX + "search/slugs";
    private static final String QUERY = "query";

    private final Client client;
    private final String apiKey;
    private final String host;

    public HttpAngellistClient(Client client,
                               String apiKey,
                               String host) {
        this.client = client;
        this.apiKey = apiKey;
        this.host = host;
    }

    @Override
    public Optional<Startup> get(long id) {
        LOGGER.info("Requesting Angellist Startup: {}", id);

        try {
            return Optional.of(client.target(uriBuilder(STARTUP).buildFromMap(ImmutableMap.of(ID, id)))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Startup.class));
        } catch (NotFoundException e) {
            LOGGER.info("Unable to find Angellist startup {}", id);
            return Optional.empty();
        }
    }

    @Override
    public Startups startups(int tagId, int page) {
        LOGGER.info("Requesting Angellist Startups from tag: {}, page: {}", tagId, page);

        try {
            return client.target(uriBuilder(STARTUPS).buildFromMap(ImmutableMap.of(TAG, tagId)))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .queryParam(PAGE, page)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Startups.class);
        } catch (NotFoundException e) {
            return Startups.builder()
                    .withStartups(ImmutableList.of())
                    .withLastPage(0)
                    .withPage(page)
                    .withPerPage(0)
                    .withTotal(0)
                    .build();
        }
    }

    @Override
    public Optional<User> user(long id) {
        LOGGER.info("Requesting Angellist user: {}", id);

        try {
            return Optional.of(client.target(uriBuilder(USER).buildFromMap(ImmutableMap.of(ID, id)))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(User.class));
        } catch (NotFoundException e) {
            LOGGER.info("Unable to find Angellist user {}", id);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Entity> entity(String slug) {
        LOGGER.info("Requesting Angellist entity for: {}", slug);

        try {
            return Optional.of(client.target(uriBuilder(SLUGS))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .queryParam(QUERY, slug)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Entity.class));
        } catch (NotFoundException e) {
            return Optional.empty();
        }
    }

    @Override
    public StartupRoles startupRoles(long id) {
        LOGGER.info("Requesting Angellist Startup roles for: {}", id);

        try {
            return client.target(uriBuilder(STARTUP_ROLES).buildFromMap(ImmutableMap.of(ID, id)))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(StartupRoles.class);
        } catch (NotFoundException e) {
            return StartupRoles.builder()
                    .withLastPage(1)
                    .withPage(1)
                    .withPerPage(50)
                    .withTotal(0)
                    .withStartupRoles(ImmutableList.of())
                    .build();
        }
    }

    @Override
    public Optional<ParentTags> parentTags(long id, int page) {
        LOGGER.info("Requesting Angellist parent tags for: {}", id);

        try {
            return Optional.of(client.target(uriBuilder(TAG_PARENTS).buildFromMap(ImmutableMap.of(TAG, id)))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .queryParam(PAGE, page)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(ParentTags.class));
        } catch (NotFoundException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ChildTags> childTags(long id, int page) {
        LOGGER.info("Requesting Angellist child tags for: {}", id);

        try {
            return Optional.of(client.target(uriBuilder(TAG_CHILDREN).buildFromMap(ImmutableMap.of(TAG, id)))
                    .queryParam(ACCESS_TOKEN, apiKey)
                    .queryParam(PAGE, page)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(ChildTags.class));
        } catch (NotFoundException e) {
            return Optional.empty();
        }
    }

    private UriBuilder uriBuilder(String path) {
        return UriBuilder.fromPath(host + path);
    }
}
