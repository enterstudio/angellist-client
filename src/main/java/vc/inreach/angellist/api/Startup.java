package vc.inreach.angellist.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Predicate;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Startup {

    public static final String ID = "id";
    public static final String HIDDEN = "hidden";
    public static final String COMMUNITY_PROFILE = "community_profile";
    public static final String NAME = "name";
    public static final String ANGELLIST_URL = "angellist_url";
    public static final String LOGO_URL = "logo_url";
    public static final String THUMB_URL = "thumb_url";
    public static final String QUALITY = "quality";
    public static final String PRODUCT_DESC = "product_desc";
    public static final String HIGH_CONCEPT = "high_concept";
    public static final String FOLLOWER_COUNT = "follower_count";
    public static final String COMPANY_URL = "company_url";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String TWITTER_URL = "twitter_url";
    public static final String BLOG_URL = "blog_url";
    public static final String VIDEO_URL = "video_url";
    public static final String MARKETS = "markets";
    public static final String LOCATIONS = "locations";
    public static final String STATUS = "status";
    public static final String SCREENSHOTS = "screenshots";
    public static final String COMPANY_SIZE = "company_size";
    public static final String COMPANY_TYPES = "company_types";
    public static final String ROLES = "roles";
    public static final String ANGELLIST_BASE_URL = "https://angel.co/";
    private static final String EMPTY = "";

    @JsonProperty(ID)
    private Optional<Long> id = Optional.empty();
    @JsonProperty(HIDDEN)
    private Optional<Boolean> hidden = Optional.empty();
    @JsonProperty(COMMUNITY_PROFILE)
    private Optional<Boolean> communityProfile = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(NAME)
    private Optional<String> name = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ANGELLIST_URL)
    private Optional<String> angellistUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(LOGO_URL)
    private Optional<String> logoUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(THUMB_URL)
    private Optional<String> thumbUrl = Optional.empty();
    @JsonProperty(QUALITY)
    private Optional<Integer> quality = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(PRODUCT_DESC)
    private Optional<String> productDesc = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(HIGH_CONCEPT)
    private Optional<String> highConcept = Optional.empty();
    @JsonProperty(FOLLOWER_COUNT)
    private Optional<Long> followerCount = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(COMPANY_URL)
    private Optional<String> companyUrl = Optional.empty();
    @JsonProperty(CREATED_AT)
    private Optional<ZonedDateTime> createdAt = Optional.empty();
    @JsonProperty(UPDATED_AT)
    private Optional<ZonedDateTime> updatedAt = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(TWITTER_URL)
    private Optional<String> twitterUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(BLOG_URL)
    private Optional<String> blogUrl = Optional.empty();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(VIDEO_URL)
    private Optional<String> videoUrl = Optional.empty();
    @JsonProperty(MARKETS)
    private List<Market> markets = ImmutableList.of();
    @JsonProperty(LOCATIONS)
    private List<Tag> locations = ImmutableList.of();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(COMPANY_SIZE)
    private Optional<String> companySize = Optional.empty();
    @JsonProperty(COMPANY_TYPES)
    private List<CompanyType> companyTypes = ImmutableList.of();
    @JsonProperty(STATUS)
    private Optional<Status> status = Optional.empty();
    @JsonProperty(SCREENSHOTS)
    private List<Map<String, String>> screenshots = ImmutableList.of();
    @JsonSerialize(using = StringSerializer.class)
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonProperty(ROLES)
    private Optional<Set<StartupRole>> roles = Optional.empty();

    @SuppressWarnings("unused")
    private Startup() {
    }

    private Startup(Optional<Long> id,
                    Optional<Boolean> hidden,
                    Optional<Boolean> communityProfile,
                    Optional<String> name,
                    Optional<String> angellistUrl,
                    Optional<String> logoUrl,
                    Optional<String> thumbUrl,
                    Optional<Integer> quality,
                    Optional<String> productDesc,
                    Optional<String> highConcept,
                    Optional<Long> followerCount,
                    Optional<String> companyUrl,
                    Optional<ZonedDateTime> createdAt,
                    Optional<ZonedDateTime> updatedAt,
                    Optional<String> twitterUrl,
                    Optional<String> blogUrl,
                    Optional<String> videoUrl,
                    List<Market> markets,
                    List<Tag> locations,
                    Optional<String> companySize,
                    List<CompanyType> companyTypes,
                    Optional<Status> status,
                    List<Map<String, String>> screenshots,
                    Optional<Set<StartupRole>> roles) {
        this.id = id;
        this.hidden = hidden;
        this.communityProfile = communityProfile;
        this.name = name;
        this.angellistUrl = angellistUrl;
        this.logoUrl = logoUrl;
        this.thumbUrl = thumbUrl;
        this.quality = quality;
        this.productDesc = productDesc;
        this.highConcept = highConcept;
        this.followerCount = followerCount;
        this.companyUrl = companyUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.twitterUrl = twitterUrl;
        this.blogUrl = blogUrl;
        this.videoUrl = videoUrl;
        this.markets = markets;
        this.locations = locations;
        this.companySize = companySize;
        this.companyTypes = companyTypes;
        this.status = status;
        this.screenshots = screenshots;
        this.roles = roles;
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

    public Optional<Boolean> getHidden() {
        return hidden;
    }

    public Boolean requireHidden() {
        return hidden.get();
    }

    public Optional<Boolean> getCommunityProfile() {
        return communityProfile;
    }

    public Boolean requireCommunityProfile() {
        return communityProfile.get();
    }

    public Optional<String> getName() {
        return name;
    }

    public String requireName() {
        return name.get();
    }

    public Optional<String> getAngellistUrl() {
        return angellistUrl;
    }

    public String requireAngellistUrl() {
        return angellistUrl.get();
    }

    @JsonIgnore
    public Optional<String> getSlug() {
        return angellistUrl.map(url -> url.replaceAll(ANGELLIST_BASE_URL, EMPTY));
    }

    public String requireSlug() {
        return getSlug().get();
    }

    public Optional<String> getLogoUrl() {
        return logoUrl;
    }

    public String requireLogoUrl() {
        return logoUrl.get();
    }

    public Optional<String> getThumbUrl() {
        return thumbUrl;
    }

    public String requireThumbUrl() {
        return thumbUrl.get();
    }

    public Optional<Integer> getQuality() {
        return quality;
    }

    public Integer requireQuality() {
        return quality.get();
    }

    public Optional<String> getProductDesc() {
        return productDesc;
    }

    public String requireProductDesc() {
        return productDesc.get();
    }

    public Optional<String> getHighConcept() {
        return highConcept;
    }

    public String requireHighConcept() {
        return highConcept.get();
    }

    public Optional<Long> getFollowerCount() {
        return followerCount;
    }

    public Long requireFollowerCount() {
        return followerCount.get();
    }

    public Optional<String> getCompanyUrl() {
        return companyUrl;
    }

    public String requireCompanyUrl() {
        return companyUrl.get();
    }

    public Optional<ZonedDateTime> getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime requireCreatedAt() {
        return createdAt.get();
    }

    public Optional<ZonedDateTime> getUpdatedAt() {
        return updatedAt;
    }

    public ZonedDateTime requireUpdatedAt() {
        return updatedAt.get();
    }

    public Optional<String> getTwitterUrl() {
        return twitterUrl;
    }

    public String requireTwitterUrl() {
        return twitterUrl.get();
    }

    public Optional<String> getBlogUrl() {
        return blogUrl;
    }

    public String requireBlogUrl() {
        return blogUrl.get();
    }

    public Optional<String> getVideoUrl() {
        return videoUrl;
    }

    public String requireVideoUrl() {
        return videoUrl.get();
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public List<Tag> getLocations() {
        return locations;
    }

    public Optional<Status> getStatus() {
        return status;
    }

    public Status requireStatus() {
        return status.get();
    }

    public List<Map<String, String>> getScreenshots() {
        return screenshots;
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
        final Startup other = (Startup) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.hidden, other.hidden) &&
                Objects.equals(this.communityProfile, other.communityProfile) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.angellistUrl, other.angellistUrl) &&
                Objects.equals(this.logoUrl, other.logoUrl) &&
                Objects.equals(this.thumbUrl, other.thumbUrl) &&
                Objects.equals(this.quality, other.quality) &&
                Objects.equals(this.productDesc, other.productDesc) &&
                Objects.equals(this.highConcept, other.highConcept) &&
                Objects.equals(this.followerCount, other.followerCount) &&
                Objects.equals(this.companyUrl, other.companyUrl) &&
                Objects.equals(this.createdAt, other.createdAt) &&
                Objects.equals(this.updatedAt, other.updatedAt) &&
                Objects.equals(this.twitterUrl, other.twitterUrl) &&
                Objects.equals(this.blogUrl, other.blogUrl) &&
                Objects.equals(this.videoUrl, other.videoUrl) &&
                Objects.equals(this.markets, other.markets) &&
                Objects.equals(this.locations, other.locations) &&
                Objects.equals(this.companySize, other.companySize) &&
                Objects.equals(this.companyTypes, other.companyTypes) &&
                Objects.equals(this.status, other.status) &&
                Objects.equals(this.screenshots, other.screenshots) &&
                Objects.equals(this.roles, other.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                hidden,
                communityProfile,
                name,
                angellistUrl,
                logoUrl,
                thumbUrl,
                quality,
                productDesc,
                highConcept,
                followerCount,
                companyUrl,
                createdAt,
                updatedAt,
                twitterUrl,
                blogUrl,
                videoUrl,
                markets,
                locations,
                companySize,
                companyTypes,
                status,
                screenshots,
                roles
        );
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(ID, id)
                .add(HIDDEN, hidden)
                .add(COMMUNITY_PROFILE, communityProfile)
                .add(NAME, name)
                .add(ANGELLIST_URL, angellistUrl)
                .add(LOGO_URL, logoUrl)
                .add(THUMB_URL, thumbUrl)
                .add(QUALITY, quality)
                .add(PRODUCT_DESC, productDesc)
                .add(HIGH_CONCEPT, highConcept)
                .add(FOLLOWER_COUNT, followerCount)
                .add(COMPANY_URL, companyUrl)
                .add(CREATED_AT, createdAt)
                .add(UPDATED_AT, updatedAt)
                .add(TWITTER_URL, twitterUrl)
                .add(BLOG_URL, blogUrl)
                .add(VIDEO_URL, videoUrl)
                .add(MARKETS, markets)
                .add(LOCATIONS, locations)
                .add(COMPANY_SIZE, companySize)
                .add(COMPANY_TYPES, companyTypes)
                .add(STATUS, status)
                .add(SCREENSHOTS, screenshots)
                .add(ROLES, roles)
                .toString();
    }

    public Optional<String> getCompanySize() {
        return companySize;
    }

    public String requireCompanySize() {
        return companySize.get();
    }

    public List<CompanyType> getCompanyTypes() {
        return companyTypes;
    }

    public Optional<Set<StartupRole>> getRoles() {
        return roles;
    }

    public Set<StartupRole> requireRoles() {
        return roles.get();
    }

    @JsonIgnore
    public Set<StartupRole> getRolesOrEmpty() {
        return roles.orElse(ImmutableSet.of());
    }

    public static class Builder {
        private Builder() {
        }

        private Builder(Startup startup) {
            this.id = startup.getId();
            this.hidden = startup.getHidden();
            this.communityProfile = startup.getCommunityProfile();
            this.name = startup.getName();
            this.angellistUrl = startup.getAngellistUrl();
            this.logoUrl = startup.getLogoUrl();
            this.thumbUrl = startup.getThumbUrl();
            this.quality = startup.getQuality();
            this.productDesc = startup.getProductDesc();
            this.highConcept = startup.getHighConcept();
            this.followerCount = startup.getFollowerCount();
            this.companyUrl = startup.getCompanyUrl();
            this.createdAt = startup.getCreatedAt();
            this.updatedAt = startup.getUpdatedAt();
            this.twitterUrl = startup.getTwitterUrl();
            this.blogUrl = startup.getBlogUrl();
            this.videoUrl = startup.getVideoUrl();
            this.markets = startup.getMarkets();
            this.locations = startup.getLocations();
            this.companySize = startup.getCompanySize();
            this.companyTypes = startup.getCompanyTypes();
            this.status = startup.getStatus();
            this.screenshots = startup.getScreenshots();
            this.roles = startup.getRoles();
        }

        private Optional<Long> id = Optional.empty();
        private Optional<Boolean> hidden = Optional.empty();
        private Optional<Boolean> communityProfile = Optional.empty();
        private Optional<String> name = Optional.empty();
        private Optional<String> angellistUrl = Optional.empty();
        private Optional<String> logoUrl = Optional.empty();
        private Optional<String> thumbUrl = Optional.empty();
        private Optional<Integer> quality = Optional.empty();
        private Optional<String> productDesc = Optional.empty();
        private Optional<String> highConcept = Optional.empty();
        private Optional<Long> followerCount = Optional.empty();
        private Optional<String> companyUrl = Optional.empty();
        private Optional<ZonedDateTime> createdAt = Optional.empty();
        private Optional<ZonedDateTime> updatedAt = Optional.empty();
        private Optional<String> twitterUrl = Optional.empty();
        private Optional<String> blogUrl = Optional.empty();
        private Optional<String> videoUrl = Optional.empty();
        private List<Market> markets;
        private List<Tag> locations;
        private Optional<String> companySize = Optional.empty();
        private List<CompanyType> companyTypes;
        private Optional<Status> status = Optional.empty();
        private List<Map<String, String>> screenshots;
        private Optional<String> organizationId = Optional.empty();
        private Optional<Set<StartupRole>> roles = Optional.empty();

        public Builder withId(Optional<Long> id) {
            this.id = id;
            return this;
        }

        public Builder withId(Long id) {
            this.id = Optional.of(id);
            return this;
        }

        public Builder withHidden(Optional<Boolean> hidden) {
            this.hidden = hidden;
            return this;
        }

        public Builder withHidden(Boolean hidden) {
            this.hidden = Optional.of(hidden);
            return this;
        }

        public Builder withCommunityProfile(Optional<Boolean> communityProfile) {
            this.communityProfile = communityProfile;
            return this;
        }

        public Builder withCommunityProfile(Boolean communityProfile) {
            this.communityProfile = Optional.of(communityProfile);
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

        public Builder withAngellistUrl(Optional<String> angellistUrl) {
            this.angellistUrl = angellistUrl;
            return this;
        }

        public Builder withAngellistUrl(String angellistUrl) {
            this.angellistUrl = Optional.of(angellistUrl);
            return this;
        }

        public Builder withLogoUrl(Optional<String> logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        public Builder withLogoUrl(String logoUrl) {
            this.logoUrl = Optional.of(logoUrl);
            return this;
        }

        public Builder withThumbUrl(Optional<String> thumbUrl) {
            this.thumbUrl = thumbUrl;
            return this;
        }

        public Builder withThumbUrl(String thumbUrl) {
            this.thumbUrl = Optional.of(thumbUrl);
            return this;
        }

        public Builder withQuality(Optional<Integer> quality) {
            this.quality = quality;
            return this;
        }

        public Builder withQuality(Integer quality) {
            this.quality = Optional.of(quality);
            return this;
        }

        public Builder withProductDesc(Optional<String> productDesc) {
            this.productDesc = productDesc;
            return this;
        }

        public Builder withProductDesc(String productDesc) {
            this.productDesc = Optional.of(productDesc);
            return this;
        }

        public Builder withHighConcept(Optional<String> highConcept) {
            this.highConcept = highConcept;
            return this;
        }

        public Builder withHighConcept(String highConcept) {
            this.highConcept = Optional.of(highConcept);
            return this;
        }

        public Builder withFollowerCount(Optional<Long> followerCount) {
            this.followerCount = followerCount;
            return this;
        }

        public Builder withFollowerCount(Long followerCount) {
            this.followerCount = Optional.of(followerCount);
            return this;
        }

        public Builder withCompanyUrl(Optional<String> companyUrl) {
            this.companyUrl = companyUrl;
            return this;
        }

        public Builder withCompanyUrl(String companyUrl) {
            this.companyUrl = Optional.of(companyUrl);
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

        public Builder withUpdatedAt(Optional<ZonedDateTime> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder withUpdatedAt(ZonedDateTime updatedAt) {
            this.updatedAt = Optional.of(updatedAt);
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

        public Builder withBlogUrl(Optional<String> blogUrl) {
            this.blogUrl = blogUrl;
            return this;
        }

        public Builder withBlogUrl(String blogUrl) {
            this.blogUrl = Optional.of(blogUrl);
            return this;
        }

        public Builder withVideoUrl(Optional<String> videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder withVideoUrl(String videoUrl) {
            this.videoUrl = Optional.of(videoUrl);
            return this;
        }

        public Builder withMarkets(List<Market> markets) {
            this.markets = markets;
            return this;
        }

        public Builder withLocations(List<Tag> locations) {
            this.locations = locations;
            return this;
        }

        public Builder withCompanySize(Optional<String> companySize) {
            this.companySize = companySize;
            return this;
        }

        public Builder withCompanySize(String companySize) {
            this.companySize = Optional.of(companySize);
            return this;
        }

        public Builder withCompanyTypes(List<CompanyType> companyTypes) {
            this.companyTypes = companyTypes;
            return this;
        }

        public Builder withStatus(Optional<Status> status) {
            this.status = status;
            return this;
        }

        public Builder withStatus(Status status) {
            this.status = Optional.of(status);
            return this;
        }

        public Builder withScreenshots(List<Map<String, String>> screenshots) {
            this.screenshots = screenshots;
            return this;
        }

        public Builder withRoles(Optional<Set<StartupRole>> roles) {
            this.roles = roles;
            return this;
        }

        public Builder withRoles(Set<StartupRole> roles) {
            this.roles = Optional.of(roles);
            return this;
        }

        public Startup build() {
            return new Startup(id, hidden, communityProfile, name, angellistUrl, logoUrl, thumbUrl, quality, productDesc, highConcept, followerCount, companyUrl, createdAt, updatedAt, twitterUrl, blogUrl, videoUrl, markets, locations, companySize, companyTypes, status, screenshots, roles);
        }
    }

    public static final Predicate<Startup> IS_NOT_HIDDEN = startup ->
            startup != null && !startup.getHidden().orElse(Boolean.FALSE);
}
