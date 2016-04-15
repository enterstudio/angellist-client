package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    public static final String ID = "id";
    public static final String TAG_TYPE = "tag_type";
    public static final String NAME = "name";
    public static final String DISPLAY_NAME = "display_name";
    public static final String ANGELLIST_URL = "angellist_url";
    public static final String PARENTS = "parents";

    @JsonProperty(ID)
    private long id;
    @JsonProperty(TAG_TYPE)
    private String tagType;
    @JsonProperty(NAME)
    private String name;
    @JsonProperty(DISPLAY_NAME)
    private String displayName;
    @JsonProperty(ANGELLIST_URL)
    private String angellistUrl;
    @JsonProperty(PARENTS)
    private Optional<Set<Tag>> parents = Optional.empty();

    @SuppressWarnings("unused")
    private Tag() {
    }

    private Tag(long id,
                String tagType,
                String name,
                String displayName,
                String angellistUrl,
                Optional<Set<Tag>> parents) {
        this.id = id;
        this.tagType = tagType;
        this.name = name;
        this.displayName = displayName;
        this.angellistUrl = angellistUrl;
        this.parents = parents;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public String getTagType() {
        return tagType;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAngellistUrl() {
        return angellistUrl;
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
        final Tag other = (Tag) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.tagType, other.tagType) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.displayName, other.displayName) &&
                Objects.equals(this.angellistUrl, other.angellistUrl) &&
                Objects.equals(this.parents, other.parents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                tagType,
                name,
                displayName,
                angellistUrl,
                parents
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(ID, id)
                .add(TAG_TYPE, tagType)
                .add(NAME, name)
                .add(DISPLAY_NAME, displayName)
                .add(ANGELLIST_URL, angellistUrl)
                .add(PARENTS, parents)
                .toString();
    }

    public Optional<Set<Tag>> getParents() {
        return parents;
    }

    public Set<Tag> requireParents() {
        return parents.get();
    }

    @JsonIgnore
    public Set<Tag> getParentsOrEmpty() {
        return parents.orElse(ImmutableSet.of());
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(Tag tag) {
            this.id = tag.getId();
            this.tagType = tag.getTagType();
            this.name = tag.getName();
            this.displayName = tag.getDisplayName();
            this.angellistUrl = tag.getAngellistUrl();
            this.parents = tag.getParents();
        }

        private long id;
        private String tagType;
        private String name;
        private String displayName;
        private String angellistUrl;
        private Optional<Set<Tag>> parents = Optional.empty();

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withTagType(String tagType) {
            this.tagType = tagType;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder withAngellistUrl(String angellistUrl) {
            this.angellistUrl = angellistUrl;
            return this;
        }

        public Builder withParents(Optional<Set<Tag>> parents) {
            this.parents = parents;
            return this;
        }

        public Builder withParents(Set<Tag> parents) {
            this.parents = Optional.of(parents);
            return this;
        }

        public Tag build() {
            return new Tag(id, tagType, name, displayName, angellistUrl, parents);
        }
    }
}
