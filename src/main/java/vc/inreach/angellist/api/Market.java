package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Market {

    public static final String ID = "id";
    public static final String TAG_TYPE = "tag_type";
    public static final String NAME = "name";
    public static final String DISPLAY_NAME = "display_name";
    public static final String ANGELLIST_URL = "angellist_url";

    @JsonProperty(ID)
    private Optional<Long> id = Optional.empty();
    @JsonProperty(TAG_TYPE)
    private Optional<String> tagType = Optional.empty();
    @JsonProperty(NAME)
    private Optional<String> name = Optional.empty();
    @JsonProperty(DISPLAY_NAME)
    private Optional<String> displayName = Optional.empty();
    @JsonProperty(ANGELLIST_URL)
    private Optional<String> angellistUrl = Optional.empty();

    private Market(Optional<Long> id,
                   Optional<String> tagType,
                   Optional<String> name,
                   Optional<String> displayName,
                   Optional<String> angellistUrl) {
        this.id = id;
        this.tagType = tagType;
        this.name = name;
        this.displayName = displayName;
        this.angellistUrl = angellistUrl;
    }

    @SuppressWarnings("unused")
    private Market() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Optional<Long> getId() {
        return id;
    }

    public Long requireId() {
        return id.get();
    }

    public Optional<String> getTagType() {
        return tagType;
    }

    public String requireTagType() {
        return tagType.get();
    }

    public Optional<String> getName() {
        return name;
    }

    public String requireName() {
        return name.get();
    }

    public Optional<String> getDisplayName() {
        return displayName;
    }

    public String requireDisplayName() {
        return displayName.get();
    }

    public Optional<String> getAngellistUrl() {
        return angellistUrl;
    }

    public String requireAngellistUrl() {
        return angellistUrl.get();
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
        final Market other = (Market) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.tagType, other.tagType) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.displayName, other.displayName) &&
                Objects.equals(this.angellistUrl, other.angellistUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                tagType,
                name,
                displayName,
                angellistUrl
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
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(Market market) {
            this.id = market.getId();
            this.tagType = market.getTagType();
            this.name = market.getName();
            this.displayName = market.getDisplayName();
            this.angellistUrl = market.getAngellistUrl();
        }

        private Optional<Long> id = Optional.empty();
        private Optional<String> tagType = Optional.empty();
        private Optional<String> name = Optional.empty();
        private Optional<String> displayName = Optional.empty();
        private Optional<String> angellistUrl = Optional.empty();

        public Builder withId(Optional<Long> id) {
            this.id = id;
            return this;
        }

        public Builder withId(Long id) {
            this.id = Optional.of(id);
            return this;
        }

        public Builder withTagType(Optional<String> tagType) {
            this.tagType = tagType;
            return this;
        }

        public Builder withTagType(String tagType) {
            this.tagType = Optional.of(tagType);
            return this;
        }

        public Builder withName(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder withName(String name) {
            this.name = Optional.of(name);
            return this;
        }

        public Builder withDisplayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder withDisplayName(String displayName) {
            this.displayName = Optional.of(displayName);
            return this;
        }

        public Builder withAngellistUrl(Optional<String> angellistUrl) {
            this.angellistUrl = angellistUrl;
            return this;
        }

        public Builder withAngellistUrl(String angellistUrl) {
            this.angellistUrl = Optional.of(angellistUrl);
            return this;
        }

        public Market build() {
            return new Market(id, tagType, name, displayName, angellistUrl);
        }
    }
}
