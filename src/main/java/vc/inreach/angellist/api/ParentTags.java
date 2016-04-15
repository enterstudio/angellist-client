package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentTags {

    public static final String PARENTS = "parents";
    public static final String TOTAL = "total";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE = "page";
    public static final String LAST_PAGE = "last_page";

    @JsonProperty(PARENTS)
    private Set<Tag> parents = ImmutableSet.of();
    @JsonProperty(TOTAL)
    private long total;
    @JsonProperty(PER_PAGE)
    private int perPage;
    @JsonProperty(PAGE)
    private int page;
    @JsonProperty(LAST_PAGE)
    private int lastPage;

    private ParentTags(Set<Tag> parents,
                       long total,
                       int perPage,
                       int page,
                       int lastPage) {
        this.parents = parents;
        this.total = total;
        this.perPage = perPage;
        this.page = page;
        this.lastPage = lastPage;
    }

    @SuppressWarnings("unused")
    private ParentTags() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<Tag> getParents() {
        return parents;
    }

    public long getTotal() {
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
        final ParentTags other = (ParentTags) obj;
        return Objects.equals(this.parents, other.parents) &&
                Objects.equals(this.total, other.total) &&
                Objects.equals(this.perPage, other.perPage) &&
                Objects.equals(this.page, other.page) &&
                Objects.equals(this.lastPage, other.lastPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                parents,
                total,
                perPage,
                page,
                lastPage
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PARENTS, parents)
                .add(TOTAL, total)
                .add(PER_PAGE, perPage)
                .add(PAGE, page)
                .add(LAST_PAGE, lastPage)
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(ParentTags parentTags) {
            this.parents = parentTags.getParents();
            this.total = parentTags.getTotal();
            this.perPage = parentTags.getPerPage();
            this.page = parentTags.getPage();
            this.lastPage = parentTags.getLastPage();
        }

        private Set<Tag> parents;
        private long total;
        private int perPage;
        private int page;
        private int lastPage;

        public Builder withParents(Set<Tag> parents) {
            this.parents = parents;
            return this;
        }

        public Builder withTotal(long total) {
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

        public ParentTags build() {
            return new ParentTags(parents, total, perPage, page, lastPage);
        }
    }
}
