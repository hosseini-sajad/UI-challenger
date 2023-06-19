package com.xone.uichallenge.models


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

class ModelClass : ArrayList<ModelClass.ModelClassItem>(){
    @Keep
    data class ModelClassItem(
        @SerializedName("alt_description")
        val altDescription: String,
        @SerializedName("blur_hash")
        val blurHash: String,
        @SerializedName("color")
        val color: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("current_user_collections")
        val currentUserCollections: List<Any>,
        @SerializedName("description")
        val description: String,
        @SerializedName("height")
        val height: Int,
        @SerializedName("id")
        val id: String,
        @SerializedName("liked_by_user")
        val likedByUser: Boolean,
        @SerializedName("likes")
        val likes: Int,
        @SerializedName("links")
        val links: Links,
        @SerializedName("promoted_at")
        val promotedAt: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("sponsorship")
        val sponsorship: Sponsorship,
        @SerializedName("topic_submissions")
        val topicSubmissions: TopicSubmissions,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("urls")
        val urls: Urls,
        @SerializedName("user")
        val user: User,
        @SerializedName("width")
        val width: Int,
    ) {
        @Keep
        data class Links(
            @SerializedName("download")
            val download: String,
            @SerializedName("download_location")
            val downloadLocation: String,
            @SerializedName("html")
            val html: String,
            @SerializedName("self")
            val self: String
        )
    
        @Keep
        data class Sponsorship(
            @SerializedName("impression_urls")
            val impressionUrls: List<String>,
            @SerializedName("sponsor")
            val sponsor: Sponsor,
            @SerializedName("tagline")
            val tagline: String,
            @SerializedName("tagline_url")
            val taglineUrl: String
        ) {
            @Keep
            data class Sponsor(
                @SerializedName("accepted_tos")
                val acceptedTos: Boolean,
                @SerializedName("bio")
                val bio: String,
                @SerializedName("first_name")
                val firstName: String,
                @SerializedName("for_hire")
                val forHire: Boolean,
                @SerializedName("id")
                val id: String,
                @SerializedName("instagram_username")
                val instagramUsername: String,
                @SerializedName("last_name")
                val lastName: Any,
                @SerializedName("links")
                val links: Links,
                @SerializedName("location")
                val location: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("portfolio_url")
                val portfolioUrl: String,
                @SerializedName("profile_image")
                val profileImage: ProfileImage,
                @SerializedName("social")
                val social: Social,
                @SerializedName("total_collections")
                val totalCollections: Int,
                @SerializedName("total_likes")
                val totalLikes: Int,
                @SerializedName("total_photos")
                val totalPhotos: Int,
                @SerializedName("twitter_username")
                val twitterUsername: String,
                @SerializedName("updated_at")
                val updatedAt: String,
                @SerializedName("username")
                val username: String
            ) {
                @Keep
                data class Links(
                    @SerializedName("followers")
                    val followers: String,
                    @SerializedName("following")
                    val following: String,
                    @SerializedName("html")
                    val html: String,
                    @SerializedName("likes")
                    val likes: String,
                    @SerializedName("photos")
                    val photos: String,
                    @SerializedName("portfolio")
                    val portfolio: String,
                    @SerializedName("self")
                    val self: String
                )
    
                @Keep
                data class ProfileImage(
                    @SerializedName("large")
                    val large: String,
                    @SerializedName("medium")
                    val medium: String,
                    @SerializedName("small")
                    val small: String
                )
    
                @Keep
                data class Social(
                    @SerializedName("instagram_username")
                    val instagramUsername: String,
                    @SerializedName("paypal_email")
                    val paypalEmail: Any,
                    @SerializedName("portfolio_url")
                    val portfolioUrl: String,
                    @SerializedName("twitter_username")
                    val twitterUsername: String
                )
            }
        }
    
        @Keep
        data class TopicSubmissions(
            @SerializedName("act-for-nature")
            val actForNature: ActForNature,
            @SerializedName("arts-culture")
            val artsCulture: ArtsCulture,
            @SerializedName("current-events")
            val currentEvents: CurrentEvents,
            @SerializedName("food-drink")
            val foodDrink: FoodDrink,
            @SerializedName("health")
            val health: Health,
            @SerializedName("nature")
            val nature: Nature,
            @SerializedName("spirituality")
            val spirituality: Spirituality,
            @SerializedName("textures-patterns")
            val texturesPatterns: TexturesPatterns,
            @SerializedName("travel")
            val travel: Travel,
            @SerializedName("wallpapers")
            val wallpapers: Wallpapers
        ) {
            @Keep
            data class ActForNature(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class ArtsCulture(
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class CurrentEvents(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class FoodDrink(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class Health(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class Nature(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class Spirituality(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class TexturesPatterns(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class Travel(
                @SerializedName("status")
                val status: String
            )
    
            @Keep
            data class Wallpapers(
                @SerializedName("approved_on")
                val approvedOn: String,
                @SerializedName("status")
                val status: String
            )
        }
    
        @Keep
        data class Urls(
            @SerializedName("full")
            val full: String,
            @SerializedName("raw")
            val raw: String,
            @SerializedName("regular")
            val regular: String,
            @SerializedName("small")
            val small: String,
            @SerializedName("small_s3")
            val smallS3: String,
            @SerializedName("thumb")
            val thumb: String
        )
    
        @Keep
        data class User(
            @SerializedName("accepted_tos")
            val acceptedTos: Boolean,
            @SerializedName("bio")
            val bio: String,
            @SerializedName("first_name")
            val firstName: String,
            @SerializedName("for_hire")
            val forHire: Boolean,
            @SerializedName("id")
            val id: String,
            @SerializedName("instagram_username")
            val instagramUsername: String,
            @SerializedName("last_name")
            val lastName: String,
            @SerializedName("links")
            val links: Links,
            @SerializedName("location")
            val location: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("portfolio_url")
            val portfolioUrl: String,
            @SerializedName("profile_image")
            val profileImage: ProfileImage,
            @SerializedName("social")
            val social: Social,
            @SerializedName("total_collections")
            val totalCollections: Int,
            @SerializedName("total_likes")
            val totalLikes: Int,
            @SerializedName("total_photos")
            val totalPhotos: Int,
            @SerializedName("twitter_username")
            val twitterUsername: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("username")
            val username: String
        ) {
            @Keep
            data class Links(
                @SerializedName("followers")
                val followers: String,
                @SerializedName("following")
                val following: String,
                @SerializedName("html")
                val html: String,
                @SerializedName("likes")
                val likes: String,
                @SerializedName("photos")
                val photos: String,
                @SerializedName("portfolio")
                val portfolio: String,
                @SerializedName("self")
                val self: String
            )
    
            @Keep
            data class ProfileImage(
                @SerializedName("large")
                val large: String,
                @SerializedName("medium")
                val medium: String,
                @SerializedName("small")
                val small: String
            )
    
            @Keep
            data class Social(
                @SerializedName("instagram_username")
                val instagramUsername: String,
                @SerializedName("paypal_email")
                val paypalEmail: Any,
                @SerializedName("portfolio_url")
                val portfolioUrl: String,
                @SerializedName("twitter_username")
                val twitterUsername: String
            )
        }
    }
}