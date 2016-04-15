package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Status {

    public static final String MESSAGE = "message";
    public static final String CREATED_AT = "created_at";

    @JsonProperty(MESSAGE)
    private Optional<String> message = Optional.empty();
    @JsonProperty(CREATED_AT)
    private Optional<ZonedDateTime> createdAt = Optional.empty();

    private Status(Optional<String> message,
                   Optional<ZonedDateTime> createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    @SuppressWarnings("unused")
    private Status() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Optional<String> getMessage() {
        return message;
    }

    public String requireMessage() {
        return message.get();
    }

    public Optional<ZonedDateTime> getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime requireCreatedAt() {
        return createdAt.get();
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
        final Status other = (Status) obj;
        return Objects.equals(this.message, other.message) &&
                Objects.equals(this.createdAt, other.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                message,
                createdAt
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(MESSAGE, message)
                .add(CREATED_AT, createdAt)
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(Status status) {
            this.message = status.getMessage();
            this.createdAt = status.getCreatedAt();
        }

        private Optional<String> message = Optional.empty();
        private Optional<ZonedDateTime> createdAt = Optional.empty();

        public Builder withMessage(Optional<String> message) {
            this.message = message;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = Optional.of(message);
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

        public Status build() {
            return new Status(message, createdAt);
        }
    }
}
