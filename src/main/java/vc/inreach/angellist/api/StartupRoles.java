package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartupRoles {

    public static final String STARTUP_ROLES = "startup_roles";
    public static final String TOTAL = "total";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE = "page";
    public static final String LAST_PAGE = "last_page";

    @JsonProperty(STARTUP_ROLES)
    private List<StartupRole> startupRoles = ImmutableList.of();
    @JsonProperty(TOTAL)
    private int total;
    @JsonProperty(PER_PAGE)
    private int perPage;
    @JsonProperty(PAGE)
    private int page;
    @JsonProperty(LAST_PAGE)
    private int lastPage;

    private StartupRoles(List<StartupRole> startupRoles,
                         int total,
                         int perPage,
                         int page,
                         int lastPage) {
        this.startupRoles = startupRoles;
        this.total = total;
        this.perPage = perPage;
        this.page = page;
        this.lastPage = lastPage;
    }

    @SuppressWarnings("unused")
    private StartupRoles() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<StartupRole> getStartupRoles() {
        return startupRoles;
    }

    public int getTotal() {
        return total;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getPage() {
        return page;
    }

    public int getLastPage() {
        return lastPage;
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
        final StartupRoles other = (StartupRoles) obj;
        return Objects.equals(this.startupRoles, other.startupRoles) &&
                Objects.equals(this.total, other.total) &&
                Objects.equals(this.perPage, other.perPage) &&
                Objects.equals(this.page, other.page) &&
                Objects.equals(this.lastPage, other.lastPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                startupRoles,
                total,
                perPage,
                page,
                lastPage
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(STARTUP_ROLES, startupRoles)
                .add(TOTAL, total)
                .add(PER_PAGE, perPage)
                .add(PAGE, page)
                .add(LAST_PAGE, lastPage)
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(StartupRoles startupRoles) {
            this.startupRoles = startupRoles.getStartupRoles();
            this.total = startupRoles.getTotal();
            this.perPage = startupRoles.getPerPage();
            this.page = startupRoles.getPage();
            this.lastPage = startupRoles.getLastPage();
        }

        private List<StartupRole> startupRoles;
        private int total;
        private int perPage;
        private int page;
        private int lastPage;

        public Builder withStartupRoles(List<StartupRole> startupRoles) {
            this.startupRoles = startupRoles;
            return this;
        }

        public Builder withTotal(int total) {
            this.total = total;
            return this;
        }

        public Builder withPerPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder withPage(int page) {
            this.page = page;
            return this;
        }

        public Builder withLastPage(int lastPage) {
            this.lastPage = lastPage;
            return this;
        }

        public StartupRoles build() {
            return new StartupRoles(startupRoles, total, perPage, page, lastPage);
        }
    }
}
