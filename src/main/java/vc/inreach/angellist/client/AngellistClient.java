package vc.inreach.angellist.client;

import vc.inreach.angellist.api.*;

import java.util.List;
import java.util.Optional;

public interface AngellistClient {

    Optional<Startup> get(long id);

    Startups startups(int tagId, int page);

    Optional<User> user(long id);

    Optional<Entity> entity(String slug);

    StartupRoles startupRoles(long id);

    Optional<ParentTags> parentTags(long id, int page);

    Optional<ChildTags> childTags(long id, int page);

    List<SearchEntry> search(String query, SearchEntry.Type type);

}
