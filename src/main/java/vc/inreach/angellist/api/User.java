package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String BIO = "bio";
    public static final String BLOG_URL = "blog_url";
    public static final String ONLINE_BIO_URL = "online_bio_url";
    public static final String TWITTER_URL = "twitter_url";
    public static final String FACEBOOK_URL = "facebook_url";
    public static final String LINKEDIN_URL = "linkedin_url";
    public static final String FOLLOWER_COUNT = "follower_count";
    public static final String INVESTOR = "investor";
    public static final String ANGELLIST_URL = "angellist_url";
    public static final String IMAGE = "image";
    public static final String LOCATIONS = "locations";
    public static final String ROLES = "roles";
    public static final String ABOUTME_URL = "aboutme_url";
    public static final String GITHUB_URL = "github_url";
    public static final String DRIBBLE_URL = "dribble_url";
    public static final String BEHANCE_URL = "behance_url";
    public static final String RESUME_URL = "resume_url";
    public static final String WHAT_IVE_BUILT = "what_ive_built";
    public static final String WHAT_I_DO = "what_i_do";
    public static final String CRITERIA = "criteria";

    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(NAME)
    private Optional<String> name = Optional.empty();
    @JsonProperty(ID)
    private long id;
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(BIO)
    private Optional<String> bio = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(BLOG_URL)
    private Optional<String> blogUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ONLINE_BIO_URL)
    private Optional<String> onlineBioUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(TWITTER_URL)
    private Optional<String> twitterUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(FACEBOOK_URL)
    private Optional<String> facebookUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(LINKEDIN_URL)
    private Optional<String> linkedinUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ABOUTME_URL)
    private Optional<String> aboutmeUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(GITHUB_URL)
    private Optional<String> githubUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(DRIBBLE_URL)
    private Optional<String> dribbleUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(BEHANCE_URL)
    private Optional<String> behanceUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(RESUME_URL)
    private Optional<String> resumeUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(WHAT_IVE_BUILT)
    private Optional<String> whatIveBuilt = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(WHAT_I_DO)
    private Optional<String> whatIDo = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(CRITERIA)
    private Optional<String> criteria = Optional.empty();
    @JsonProperty(FOLLOWER_COUNT)
    private Optional<Integer> followerCount = Optional.empty();
    @JsonProperty(INVESTOR)
    private boolean investor;
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ANGELLIST_URL)
    private Optional<String> angellistUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(IMAGE)
    private Optional<String> image = Optional.empty();
    @JsonProperty(LOCATIONS)
    private Optional<Set<Tag>> locations = Optional.empty();
    @JsonProperty(ROLES)
    private Optional<Set<Role>> roles = Optional.empty();

    @SuppressWarnings("unused")
    private User() {
    }

    private User(Optional<String> name,
                 long id,
                 Optional<String> bio,
                 Optional<String> blogUrl,
                 Optional<String> onlineBioUrl,
                 Optional<String> twitterUrl,
                 Optional<String> facebookUrl,
                 Optional<String> linkedinUrl,
                 Optional<String> aboutmeUrl,
                 Optional<String> githubUrl,
                 Optional<String> dribbleUrl,
                 Optional<String> behanceUrl,
                 Optional<String> resumeUrl,
                 Optional<String> whatIveBuilt,
                 Optional<String> whatIDo,
                 Optional<String> criteria,
                 Optional<Integer> followerCount,
                 boolean investor,
                 Optional<String> angellistUrl,
                 Optional<String> image,
                 Optional<Set<Tag>> locations,
                 Optional<Set<Role>> roles) {
        this.name = name;
        this.id = id;
        this.bio = bio;
        this.blogUrl = blogUrl;
        this.onlineBioUrl = onlineBioUrl;
        this.twitterUrl = twitterUrl;
        this.facebookUrl = facebookUrl;
        this.linkedinUrl = linkedinUrl;
        this.aboutmeUrl = aboutmeUrl;
        this.githubUrl = githubUrl;
        this.dribbleUrl = dribbleUrl;
        this.behanceUrl = behanceUrl;
        this.resumeUrl = resumeUrl;
        this.whatIveBuilt = whatIveBuilt;
        this.whatIDo = whatIDo;
        this.criteria = criteria;
        this.followerCount = followerCount;
        this.investor = investor;
        this.angellistUrl = angellistUrl;
        this.image = image;
        this.locations = locations;
        this.roles = roles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Optional<String> getName() {
        return name;
    }

    public String requireName() {
        return name.get();
    }

    public long getId() {
        return id;
    }

    public Optional<String> getBio() {
        return bio;
    }

    public String requireBio() {
        return bio.get();
    }

    public Optional<String> getBlogUrl() {
        return blogUrl;
    }

    public String requireBlogUrl() {
        return blogUrl.get();
    }

    public Optional<String> getOnlineBioUrl() {
        return onlineBioUrl;
    }

    public String requireOnlineBioUrl() {
        return onlineBioUrl.get();
    }

    public Optional<String> getTwitterUrl() {
        return twitterUrl;
    }

    public String requireTwitterUrl() {
        return twitterUrl.get();
    }

    public Optional<String> getFacebookUrl() {
        return facebookUrl;
    }

    public String requireFacebookUrl() {
        return facebookUrl.get();
    }

    public Optional<String> getLinkedinUrl() {
        return linkedinUrl;
    }

    public String requireLinkedinUrl() {
        return linkedinUrl.get();
    }

    public Optional<Integer> getFollowerCount() {
        return followerCount;
    }

    public Integer requireFollowerCount() {
        return followerCount.get();
    }

    public boolean getInvestor() {
        return investor;
    }

    public Optional<String> getAngellistUrl() {
        return angellistUrl;
    }

    public String requireAngellistUrl() {
        return angellistUrl.get();
    }

    public Optional<String> getImage() {
        return image;
    }

    public String requireImage() {
        return image.get();
    }

    public Optional<Set<Tag>> getLocations() {
        return locations;
    }

    public Set<Tag> requireLocations() {
        return locations.get();
    }

    @JsonIgnore
    public Set<Tag> getLocationsOrEmpty() {
        return locations.orElse(ImmutableSet.of());
    }

    public Optional<Set<Role>> getRoles() {
        return roles;
    }

    public Set<Role> requireRoles() {
        return roles.get();
    }

    @JsonIgnore
    public Set<Role> getRolesOrEmpty() {
        return roles.orElse(ImmutableSet.of());
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
        final User other = (User) obj;
        return Objects.equals(this.name, other.name) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.bio, other.bio) &&
                Objects.equals(this.blogUrl, other.blogUrl) &&
                Objects.equals(this.onlineBioUrl, other.onlineBioUrl) &&
                Objects.equals(this.twitterUrl, other.twitterUrl) &&
                Objects.equals(this.facebookUrl, other.facebookUrl) &&
                Objects.equals(this.linkedinUrl, other.linkedinUrl) &&
                Objects.equals(this.aboutmeUrl, other.aboutmeUrl) &&
                Objects.equals(this.githubUrl, other.githubUrl) &&
                Objects.equals(this.dribbleUrl, other.dribbleUrl) &&
                Objects.equals(this.behanceUrl, other.behanceUrl) &&
                Objects.equals(this.resumeUrl, other.resumeUrl) &&
                Objects.equals(this.whatIveBuilt, other.whatIveBuilt) &&
                Objects.equals(this.whatIDo, other.whatIDo) &&
                Objects.equals(this.criteria, other.criteria) &&
                Objects.equals(this.followerCount, other.followerCount) &&
                Objects.equals(this.investor, other.investor) &&
                Objects.equals(this.angellistUrl, other.angellistUrl) &&
                Objects.equals(this.image, other.image) &&
                Objects.equals(this.locations, other.locations) &&
                Objects.equals(this.roles, other.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                id,
                bio,
                blogUrl,
                onlineBioUrl,
                twitterUrl,
                facebookUrl,
                linkedinUrl,
                aboutmeUrl,
                githubUrl,
                dribbleUrl,
                behanceUrl,
                resumeUrl,
                whatIveBuilt,
                whatIDo,
                criteria,
                followerCount,
                investor,
                angellistUrl,
                image,
                locations,
                roles
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(NAME, name)
                .add(ID, id)
                .add(BIO, bio)
                .add(BLOG_URL, blogUrl)
                .add(ONLINE_BIO_URL, onlineBioUrl)
                .add(TWITTER_URL, twitterUrl)
                .add(FACEBOOK_URL, facebookUrl)
                .add(LINKEDIN_URL, linkedinUrl)
                .add(ABOUTME_URL, aboutmeUrl)
                .add(GITHUB_URL, githubUrl)
                .add(DRIBBLE_URL, dribbleUrl)
                .add(BEHANCE_URL, behanceUrl)
                .add(RESUME_URL, resumeUrl)
                .add(WHAT_IVE_BUILT, whatIveBuilt)
                .add(WHAT_I_DO, whatIDo)
                .add(CRITERIA, criteria)
                .add(FOLLOWER_COUNT, followerCount)
                .add(INVESTOR, investor)
                .add(ANGELLIST_URL, angellistUrl)
                .add(IMAGE, image)
                .add(LOCATIONS, locations)
                .add(ROLES, roles)
                .toString();
    }

    public Optional<String> getAboutmeUrl() {
        return aboutmeUrl;
    }

    public String requireAboutmeUrl() {
        return aboutmeUrl.get();
    }

    public Optional<String> getGithubUrl() {
        return githubUrl;
    }

    public String requireGithubUrl() {
        return githubUrl.get();
    }

    public Optional<String> getDribbleUrl() {
        return dribbleUrl;
    }

    public String requireDribbleUrl() {
        return dribbleUrl.get();
    }

    public Optional<String> getBehanceUrl() {
        return behanceUrl;
    }

    public String requireBehanceUrl() {
        return behanceUrl.get();
    }

    public Optional<String> getResumeUrl() {
        return resumeUrl;
    }

    public String requireResumeUrl() {
        return resumeUrl.get();
    }

    public Optional<String> getWhatIveBuilt() {
        return whatIveBuilt;
    }

    public String requireWhatIveBuilt() {
        return whatIveBuilt.get();
    }

    public Optional<String> getWhatIDo() {
        return whatIDo;
    }

    public String requireWhatIDo() {
        return whatIDo.get();
    }

    public Optional<String> getCriteria() {
        return criteria;
    }

    public String requireCriteria() {
        return criteria.get();
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(User user) {
            this.name = user.getName();
            this.id = user.getId();
            this.bio = user.getBio();
            this.blogUrl = user.getBlogUrl();
            this.onlineBioUrl = user.getOnlineBioUrl();
            this.twitterUrl = user.getTwitterUrl();
            this.facebookUrl = user.getFacebookUrl();
            this.linkedinUrl = user.getLinkedinUrl();
            this.aboutmeUrl = user.getAboutmeUrl();
            this.githubUrl = user.getGithubUrl();
            this.dribbleUrl = user.getDribbleUrl();
            this.behanceUrl = user.getBehanceUrl();
            this.resumeUrl = user.getResumeUrl();
            this.whatIveBuilt = user.getWhatIveBuilt();
            this.whatIDo = user.getWhatIDo();
            this.criteria = user.getCriteria();
            this.followerCount = user.getFollowerCount();
            this.investor = user.getInvestor();
            this.angellistUrl = user.getAngellistUrl();
            this.image = user.getImage();
            this.locations = user.getLocations();
            this.roles = user.getRoles();
        }

        private Optional<String> name = Optional.empty();
        private long id;
        private Optional<String> bio = Optional.empty();
        private Optional<String> blogUrl = Optional.empty();
        private Optional<String> onlineBioUrl = Optional.empty();
        private Optional<String> twitterUrl = Optional.empty();
        private Optional<String> facebookUrl = Optional.empty();
        private Optional<String> linkedinUrl = Optional.empty();
        private Optional<String> aboutmeUrl = Optional.empty();
        private Optional<String> githubUrl = Optional.empty();
        private Optional<String> dribbleUrl = Optional.empty();
        private Optional<String> behanceUrl = Optional.empty();
        private Optional<String> resumeUrl = Optional.empty();
        private Optional<String> whatIveBuilt = Optional.empty();
        private Optional<String> whatIDo = Optional.empty();
        private Optional<String> criteria = Optional.empty();
        private Optional<Integer> followerCount = Optional.empty();
        private boolean investor;
        private Optional<String> angellistUrl = Optional.empty();
        private Optional<String> image = Optional.empty();
        private Optional<Set<Tag>> locations = Optional.empty();
        private Optional<Set<Role>> roles = Optional.empty();

        public Builder withName(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder withName(String name) {
            this.name = Optional.of(name);
            return this;
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withBio(Optional<String> bio) {
            this.bio = bio;
            return this;
        }

        public Builder withBio(String bio) {
            this.bio = Optional.of(bio);
            return this;
        }

        public Builder withBlogUrl(Optional<String> blogUrl) {
            this.blogUrl = blogUrl;
            return this;
        }

        public Builder withBlogUrl(String blogUrl) {
            this.blogUrl = Optional.of(blogUrl);
            return this;
        }

        public Builder withOnlineBioUrl(Optional<String> onlineBioUrl) {
            this.onlineBioUrl = onlineBioUrl;
            return this;
        }

        public Builder withOnlineBioUrl(String onlineBioUrl) {
            this.onlineBioUrl = Optional.of(onlineBioUrl);
            return this;
        }

        public Builder withTwitterUrl(Optional<String> twitterUrl) {
            this.twitterUrl = twitterUrl;
            return this;
        }

        public Builder withTwitterUrl(String twitterUrl) {
            this.twitterUrl = Optional.of(twitterUrl);
            return this;
        }

        public Builder withFacebookUrl(Optional<String> facebookUrl) {
            this.facebookUrl = facebookUrl;
            return this;
        }

        public Builder withFacebookUrl(String facebookUrl) {
            this.facebookUrl = Optional.of(facebookUrl);
            return this;
        }

        public Builder withLinkedinUrl(Optional<String> linkedinUrl) {
            this.linkedinUrl = linkedinUrl;
            return this;
        }

        public Builder withLinkedinUrl(String linkedinUrl) {
            this.linkedinUrl = Optional.of(linkedinUrl);
            return this;
        }

        public Builder withAboutmeUrl(Optional<String> aboutmeUrl) {
            this.aboutmeUrl = aboutmeUrl;
            return this;
        }

        public Builder withAboutmeUrl(String aboutmeUrl) {
            this.aboutmeUrl = Optional.of(aboutmeUrl);
            return this;
        }

        public Builder withGithubUrl(Optional<String> githubUrl) {
            this.githubUrl = githubUrl;
            return this;
        }

        public Builder withGithubUrl(String githubUrl) {
            this.githubUrl = Optional.of(githubUrl);
            return this;
        }

        public Builder withDribbleUrl(Optional<String> dribbleUrl) {
            this.dribbleUrl = dribbleUrl;
            return this;
        }

        public Builder withDribbleUrl(String dribbleUrl) {
            this.dribbleUrl = Optional.of(dribbleUrl);
            return this;
        }

        public Builder withBehanceUrl(Optional<String> behanceUrl) {
            this.behanceUrl = behanceUrl;
            return this;
        }

        public Builder withBehanceUrl(String behanceUrl) {
            this.behanceUrl = Optional.of(behanceUrl);
            return this;
        }

        public Builder withResumeUrl(Optional<String> resumeUrl) {
            this.resumeUrl = resumeUrl;
            return this;
        }

        public Builder withResumeUrl(String resumeUrl) {
            this.resumeUrl = Optional.of(resumeUrl);
            return this;
        }

        public Builder withWhatIveBuilt(Optional<String> whatIveBuilt) {
            this.whatIveBuilt = whatIveBuilt;
            return this;
        }

        public Builder withWhatIveBuilt(String whatIveBuilt) {
            this.whatIveBuilt = Optional.of(whatIveBuilt);
            return this;
        }

        public Builder withWhatIDo(Optional<String> whatIDo) {
            this.whatIDo = whatIDo;
            return this;
        }

        public Builder withWhatIDo(String whatIDo) {
            this.whatIDo = Optional.of(whatIDo);
            return this;
        }

        public Builder withCriteria(Optional<String> criteria) {
            this.criteria = criteria;
            return this;
        }

        public Builder withCriteria(String criteria) {
            this.criteria = Optional.of(criteria);
            return this;
        }

        public Builder withFollowerCount(Optional<Integer> followerCount) {
            this.followerCount = followerCount;
            return this;
        }

        public Builder withFollowerCount(Integer followerCount) {
            this.followerCount = Optional.of(followerCount);
            return this;
        }

        public Builder withInvestor(boolean investor) {
            this.investor = investor;
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

        public Builder withImage(Optional<String> image) {
            this.image = image;
            return this;
        }

        public Builder withImage(String image) {
            this.image = Optional.of(image);
            return this;
        }

        public Builder withLocations(Optional<Set<Tag>> locations) {
            this.locations = locations;
            return this;
        }

        public Builder withLocations(Set<Tag> locations) {
            this.locations = Optional.of(locations);
            return this;
        }

        public Builder withRoles(Optional<Set<Role>> roles) {
            this.roles = roles;
            return this;
        }

        public Builder withRoles(Set<Role> roles) {
            this.roles = Optional.of(roles);
            return this;
        }

        public User build() {
            return new User(name, id, bio, blogUrl, onlineBioUrl, twitterUrl, facebookUrl, linkedinUrl, aboutmeUrl, githubUrl, dribbleUrl, behanceUrl, resumeUrl, whatIveBuilt, whatIDo, criteria, followerCount, investor, angellistUrl, image, locations, roles);
        }
    }
}
