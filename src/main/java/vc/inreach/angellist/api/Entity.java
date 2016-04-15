package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    public static final String ID = "id";
    public static final String URL = "url";
    public static final String SLUG = "slug";
    public static final String TYPE = "type";
    @JsonProperty(ID)
    private long id;
    @JsonProperty(URL)
    private String url;
    @JsonProperty(SLUG)
    private String slug;
    @JsonProperty(TYPE)
    private String type;

    private Entity(long id,
                   String url,
                   String slug,
                   String type) {
        this.id = id;
        this.url = url;
        this.slug = slug;
        this.type = type;
    }

    @SuppressWarnings("unused")
    private Entity() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getSlug() {
        return slug;
    }

    public String getType() {
        return type;
    }

    public Builder asBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Entity other = (Entity) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.url, other.url) &&
                Objects.equals(this.slug, other.slug) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                url,
                slug,
                type
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(ID, id)
                .add(URL, url)
                .add(SLUG, slug)
                .add(TYPE, type)
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(Entity entity) {
            this.id = entity.getId();
            this.url = entity.getUrl();
            this.slug = entity.getSlug();
            this.type = entity.getType();
        }

        private long id;
        private String url;
        private String slug;
        private String type;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withSlug(String slug) {
            this.slug = slug;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Entity build() {
            return new Entity(id, url, slug, type);
        }
    }
}
