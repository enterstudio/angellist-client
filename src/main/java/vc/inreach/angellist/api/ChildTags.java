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
public class ChildTags {

    public static final String CHILDREN = "children";
    public static final String TOTAL = "total";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE = "page";
    public static final String LAST_PAGE = "last_page";

    @JsonProperty(CHILDREN)
    private Set<Tag> children = ImmutableSet.of();
    @JsonProperty(TOTAL)
    private long total;
    @JsonProperty(PER_PAGE)
    private int perPage;
    @JsonProperty(PAGE)
    private int page;
    @JsonProperty(LAST_PAGE)
    private int lastPage;

    private ChildTags(Set<Tag> children,
                      long total,
                      int perPage,
                      int page,
                      int lastPage) {
        this.children = children;
        this.total = total;
        this.perPage = perPage;
        this.page = page;
        this.lastPage = lastPage;
    }

    @SuppressWarnings("unused")
    private ChildTags() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<Tag> getChildren() {
        return children;
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
        final ChildTags other = (ChildTags) obj;
        return Objects.equals(this.children, other.children) &&
                Objects.equals(this.total, other.total) &&
                Objects.equals(this.perPage, other.perPage) &&
                Objects.equals(this.page, other.page) &&
                Objects.equals(this.lastPage, other.lastPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                children,
                total,
                perPage,
                page,
                lastPage
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(CHILDREN, children)
                .add(TOTAL, total)
                .add(PER_PAGE, perPage)
                .add(PAGE, page)
                .add(LAST_PAGE, lastPage)
                .toString();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(ChildTags parentTags) {
            this.children = parentTags.getChildren();
            this.total = parentTags.getTotal();
            this.perPage = parentTags.getPerPage();
            this.page = parentTags.getPage();
            this.lastPage = parentTags.getLastPage();
        }

        private Set<Tag> children;
        private long total;
        private int perPage;
        private int page;
        private int lastPage;

        public Builder withChildren(Set<Tag> children) {
            this.children = children;
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

        public ChildTags build() {
            return new ChildTags(children, total, perPage, page, lastPage);
        }
    }
}
