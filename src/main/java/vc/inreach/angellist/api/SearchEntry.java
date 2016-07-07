package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.base.CaseFormat;
import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEntry {

    public static final String ID = "id";
    public static final String PIC = "pic";
    public static final String URL = "url";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    @JsonProperty(ID)
    private long id;
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(PIC)
    private Optional<String> pic = Optional.empty();
    @JsonProperty(URL)
    private String url;
    @JsonProperty(NAME)
    private String name;
    @JsonProperty(TYPE)
    private Type type;

    private SearchEntry(long id,
                        Optional<String> pic,
                        String url,
                        String name,
                        Type type) {
        this.id = id;
        this.pic = pic;
        this.url = url;
        this.name = name;
        this.type = type;
    }

    @SuppressWarnings("unused")
    private SearchEntry() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public Optional<String> getPic() {
        return pic;
    }

    public String requirePic() {
        return pic.get();
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
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
        final SearchEntry other = (SearchEntry) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.pic, other.pic) &&
                Objects.equals(this.url, other.url) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                pic,
                url,
                name,
                type
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(ID, id)
                .add(PIC, pic)
                .add(URL, url)
                .add(NAME, name)
                .add(TYPE, type)
                .toString();
    }

    @JsonSerialize(using=ToStringSerializer.class)
    public enum Type {
        USER, STARTUP, MARKET_TAG, LOCATION_TAG;

        @JsonCreator
        public static Type fromString(String key) {
            return Type.valueOf(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, key));
        }

        @Override
        public String toString() {
            return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, this.name());
        }
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(SearchEntry searchEntry) {
            this.id = searchEntry.getId();
            this.pic = searchEntry.getPic();
            this.url = searchEntry.getUrl();
            this.name = searchEntry.getName();
            this.type = searchEntry.getType();
        }

        private long id;
        private Optional<String> pic = Optional.empty();
        private String url;
        private String name;
        private Type type;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withPic(Optional<String> pic) {
            this.pic = pic;
            return this;
        }

        public Builder withPic(String pic) {
            this.pic = Optional.of(pic);
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public SearchEntry build() {
            return new SearchEntry(id, pic, url, name, type);
        }
    }
}
