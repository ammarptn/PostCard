package com.ammarptn.postcard;

/**
 * Created by ammarptn on 10/22/2015.
 */
public class PostCardGalleryItem {
    String url;
    String owner;

    public PostCardGalleryItem(String url, String owner) {
        this.url = url;
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
