package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartupRole {

    public static final String ID = "id";
    public static final String ROLE = "role";
    public static final String CREATED_AT = "created_at";
    public static final String STARTED_AT = "started_at";
    public static final String ENDED_AT = "ended_at";
    public static final String CONFIRMED = "confirmed";
    public static final String TAGGED = "tagged";
    public static final String USER = "user";
    public static final String TITLE = "title";
    private static final Optional<String> USER_TYPE = Optional.of("User");
    private static final String TYPE = "type";
    private static final String PAST_INVESTOR = "past_investor";

    @JsonProperty(ID)
    private Optional<Long> id = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ROLE)
    private Optional<String> role = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(TITLE)
    private Optional<String> title = Optional.empty();
    @JsonProperty(CREATED_AT)
    private Optional<ZonedDateTime> createdAt = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(STARTED_AT)
    private Optional<String> startedAt = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ENDED_AT)
    private Optional<String> endedAt = Optional.empty();
    @JsonProperty(CONFIRMED)
    private boolean confirmed;
    @JsonProperty(TAGGED)
    private Optional<Map<String, Object>> tagged = Optional.empty();
    @JsonProperty(USER)
    private Optional<User> user = Optional.empty();

    @SuppressWarnings("unused")
    private StartupRole() {
    }

    private StartupRole(Optional<Long> id,
                        Optional<String> role,
                        Optional<String> title,
                        Optional<ZonedDateTime> createdAt,
                        Optional<String> startedAt,
                        Optional<String> endedAt,
                        boolean confirmed,
                        Optional<Map<String, Object>> tagged,
                        Optional<User> user) {
        this.id = id;
        this.role = role;
        this.title = title;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.confirmed = confirmed;
        this.tagged = tagged;
        this.user = user;
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

    public Optional<String> getRole() {
        return role;
    }

    public String requireRole() {
        return role.get();
    }

    public Optional<ZonedDateTime> getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime requireCreatedAt() {
        return createdAt.get();
    }

    public Optional<String> getStartedAt() {
        return startedAt;
    }

    public String requireStartedAt() {
        return startedAt.get();
    }

    public Optional<String> getEndedAt() {
        return endedAt;
    }

    public String requireEndedAt() {
        return endedAt.get();
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public Optional<Map<String, Object>> getTagged() {
        return tagged;
    }

    public Map<String, Object> requireTagged() {
        return tagged.get();
    }

    @JsonIgnore
    public Map<String, Object> getTaggedOrEmpty() {
        return tagged.orElse(ImmutableMap.of());
    }

    public boolean isUser() {
        final Map<String, Object> tagged = getTaggedOrEmpty();
        return Optional.ofNullable(tagged.get(TYPE)).equals(USER_TYPE) && tagged.containsKey(ID);
    }

    public long requireUserId() {
        final Object o = checkNotNull(getTaggedOrEmpty().get(ID));
        if (o instanceof Integer) {
            return ((Integer) o).longValue();
        }
        return (Long) o;
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
        final StartupRole other = (StartupRole) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.role, other.role) &&
                Objects.equals(this.title, other.title) &&
                Objects.equals(this.createdAt, other.createdAt) &&
                Objects.equals(this.startedAt, other.startedAt) &&
                Objects.equals(this.endedAt, other.endedAt) &&
                Objects.equals(this.confirmed, other.confirmed) &&
                Objects.equals(this.tagged, other.tagged) &&
                Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                role,
                title,
                createdAt,
                startedAt,
                endedAt,
                confirmed,
                tagged,
                user
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(ID, id)
                .add(ROLE, role)
                .add(TITLE, title)
                .add(CREATED_AT, createdAt)
                .add(STARTED_AT, startedAt)
                .add(ENDED_AT, endedAt)
                .add(CONFIRMED, confirmed)
                .add(TAGGED, tagged)
                .add(USER, user)
                .toString();
    }

    public boolean isInvestor() {
        return role.equals(Optional.of(PAST_INVESTOR));
    }

    public Optional<User> getUser() {
        return user;
    }

    @JsonIgnore
    public User getUserOrEmpty() {
        return user.orElse(User.builder().build());
    }

    public User requireUser() {
        return user.get();
    }

    public Optional<String> getTitle() {
        return title;
    }

    public String requireTitle() {
        return title.get();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(StartupRole startupRole) {
            this.id = startupRole.getId();
            this.role = startupRole.getRole();
            this.title = startupRole.getTitle();
            this.createdAt = startupRole.getCreatedAt();
            this.startedAt = startupRole.getStartedAt();
            this.endedAt = startupRole.getEndedAt();
            this.confirmed = startupRole.getConfirmed();
            this.tagged = startupRole.getTagged();
            this.user = startupRole.getUser();
        }

        private Optional<Long> id = Optional.empty();
        private Optional<String> role = Optional.empty();
        private Optional<String> title = Optional.empty();
        private Optional<ZonedDateTime> createdAt = Optional.empty();
        private Optional<String> startedAt = Optional.empty();
        private Optional<String> endedAt = Optional.empty();
        private boolean confirmed;
        private Optional<Map<String, Object>> tagged = Optional.empty();
        private Optional<User> user = Optional.empty();

        public Builder withId(Optional<Long> id) {
            this.id = id;
            return this;
        }

        public Builder withId(Long id) {
            this.id = Optional.of(id);
            return this;
        }

        public Builder withRole(Optional<String> role) {
            this.role = role;
            return this;
        }

        public Builder withRole(String role) {
            this.role = Optional.of(role);
            return this;
        }

        public Builder withTitle(Optional<String> title) {
            this.title = title;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = Optional.of(title);
            return this;
        }

        public Builder withCreatedAt(Optional<ZonedDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
            return this;
        }

        public Builder withStartedAt(Optional<String> startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        public Builder withStartedAt(String startedAt) {
            this.startedAt = Optional.of(startedAt);
            return this;
        }

        public Builder withEndedAt(Optional<String> endedAt) {
            this.endedAt = endedAt;
            return this;
        }

        public Builder withEndedAt(String endedAt) {
            this.endedAt = Optional.of(endedAt);
            return this;
        }

        public Builder withConfirmed(boolean confirmed) {
            this.confirmed = confirmed;
            return this;
        }

        public Builder withTagged(Optional<Map<String, Object>> tagged) {
            this.tagged = tagged;
            return this;
        }

        public Builder withTagged(Map<String, Object> tagged) {
            this.tagged = Optional.of(tagged);
            return this;
        }

        public Builder withUser(Optional<User> user) {
            this.user = user;
            return this;
        }

        public Builder withUser(User user) {
            this.user = Optional.of(user);
            return this;
        }

        public StartupRole build() {
            return new StartupRole(id, role, title, createdAt, startedAt, endedAt, confirmed, tagged, user);
        }
    }
}
