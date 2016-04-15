package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

public class Startups {

    public static final String STARTUPS = "startups";
    public static final String TOTAL = "total";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE = "page";
    public static final String LAST_PAGE = "last_page";

    @JsonProperty(STARTUPS)
    private List<Startup> startups = ImmutableList.of();
    @JsonProperty(TOTAL)
    private int total;
    @JsonProperty(PER_PAGE)
    private int perPage;
    @JsonProperty(PAGE)
    private int page;
    @JsonProperty(LAST_PAGE)
    private int lastPage;

    private Startups(List<Startup> startups,
                     int total,
                     int perPage,
                     int page,
                     int lastPage) {
        this.startups = startups;
        this.total = total;
        this.perPage = perPage;
        this.page = page;
        this.lastPage = lastPage;
    }

    @SuppressWarnings("unused")
    private Startups() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Startup> getStartups() {
        return startups;
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
        final Startups other = (Startups) obj;
        return Objects.equals(this.startups, other.startups) &&
                Objects.equals(this.total, other.total) &&
                Objects.equals(this.perPage, other.perPage) &&
                Objects.equals(this.page, other.page) &&
                Objects.equals(this.lastPage, other.lastPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                startups,
                total,
                perPage,
                page,
                lastPage
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(STARTUPS, startups)
                .add(TOTAL, total)
                .add(PER_PAGE, perPage)
                .add(PAGE, page)
                .add(LAST_PAGE, lastPage)
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(Startups startups) {
            this.startups = startups.getStartups();
            this.total = startups.getTotal();
            this.perPage = startups.getPerPage();
            this.page = startups.getPage();
            this.lastPage = startups.getLastPage();
        }

        private List<Startup> startups;
        private int total;
        private int perPage;
        private int page;
        private int lastPage;

        public Builder withStartups(List<Startup> startups) {
            this.startups = startups;
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

        public Startups build() {
            return new Startups(startups, total, perPage, page, lastPage);
        }
    }
}
