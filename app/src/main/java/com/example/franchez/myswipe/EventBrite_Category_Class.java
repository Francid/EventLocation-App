package com.example.franchez.myswipe;

import java.util.List;

/**
 * Created by Franchez on 2015-11-28.
 */
public class EventBrite_Category_Class {

    /**
     * locale : en_US
     * pagination : {"object_count":20,"page_number":1,"page_size":50,"page_count":1}
     * categories : [{"resource_uri":"https://www.eventbriteapi.com/v3/categories/103/","id":"103","name":"Music","name_localized":"Music","short_name":"Music","short_name_localized":"Music"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/101/","id":"101","name":"Business & Professional","name_localized":"Business & Professional","short_name":"Business","short_name_localized":"Business"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/110/","id":"110","name":"Food & Drink","name_localized":"Food & Drink","short_name":"Food & Drink","short_name_localized":"Food & Drink"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/113/","id":"113","name":"Community & Culture","name_localized":"Community & Culture","short_name":"Community","short_name_localized":"Community"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/105/","id":"105","name":"Performing & Visual Arts","name_localized":"Performing & Visual Arts","short_name":"Arts","short_name_localized":"Arts"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/104/","id":"104","name":"Film, Media & Entertainment","name_localized":"Film, Media & Entertainment","short_name":"Film & Media","short_name_localized":"Film & Media"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/108/","id":"108","name":"Sports & Fitness","name_localized":"Sports & Fitness","short_name":"Sports & Fitness","short_name_localized":"Sports & Fitness"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/107/","id":"107","name":"Health & Wellness","name_localized":"Health & Wellness","short_name":"Health","short_name_localized":"Health"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/102/","id":"102","name":"Science & Technology","name_localized":"Science & Technology","short_name":"Science & Tech","short_name_localized":"Science & Tech"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/109/","id":"109","name":"Travel & Outdoor","name_localized":"Travel & Outdoor","short_name":"Travel & Outdoor","short_name_localized":"Travel & Outdoor"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/111/","id":"111","name":"Charity & Causes","name_localized":"Charity & Causes","short_name":"Charity & Causes","short_name_localized":"Charity & Causes"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/114/","id":"114","name":"Religion & Spirituality","name_localized":"Religion & Spirituality","short_name":"Spirituality","short_name_localized":"Spirituality"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/115/","id":"115","name":"Family & Education","name_localized":"Family & Education","short_name":"Family & Education","short_name_localized":"Family & Education"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/116/","id":"116","name":"Seasonal & Holiday","name_localized":"Seasonal & Holiday","short_name":"Holiday","short_name_localized":"Holiday"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/112/","id":"112","name":"Government & Politics","name_localized":"Government & Politics","short_name":"Government","short_name_localized":"Government"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/106/","id":"106","name":"Fashion & Beauty","name_localized":"Fashion & Beauty","short_name":"Fashion","short_name_localized":"Fashion"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/117/","id":"117","name":"Home & Lifestyle","name_localized":"Home & Lifestyle","short_name":"Home & Lifestyle","short_name_localized":"Home & Lifestyle"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/118/","id":"118","name":"Auto, Boat & Air","name_localized":"Auto, Boat & Air","short_name":"Auto, Boat & Air","short_name_localized":"Auto, Boat & Air"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/119/","id":"119","name":"Hobbies & Special Interest","name_localized":"Hobbies & Special Interest","short_name":"Hobbies","short_name_localized":"Hobbies"},{"resource_uri":"https://www.eventbriteapi.com/v3/categories/199/","id":"199","name":"Other","name_localized":"Other","short_name":"Other","short_name_localized":"Other"}]
     */

    private String locale;
    /**
     * object_count : 20
     * page_number : 1
     * page_size : 50
     * page_count : 1
     */

    private PaginationEntity pagination;
    /**
     * resource_uri : https://www.eventbriteapi.com/v3/categories/103/
     * id : 103
     * name : Music
     * name_localized : Music
     * short_name : Music
     * short_name_localized : Music
     */

    private List<CategoriesEntity> categories;

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setPagination(PaginationEntity pagination) {
        this.pagination = pagination;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public String getLocale() {
        return locale;
    }

    public PaginationEntity getPagination() {
        return pagination;
    }

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public static class PaginationEntity {
        private int object_count;
        private int page_number;
        private int page_size;
        private int page_count;

        public void setObject_count(int object_count) {
            this.object_count = object_count;
        }

        public void setPage_number(int page_number) {
            this.page_number = page_number;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public int getObject_count() {
            return object_count;
        }

        public int getPage_number() {
            return page_number;
        }

        public int getPage_size() {
            return page_size;
        }

        public int getPage_count() {
            return page_count;
        }
    }

    public static class CategoriesEntity {
        private String resource_uri;
        private String id;
        private String name;
        private String name_localized;
        private String short_name;
        private String short_name_localized;

        public void setResource_uri(String resource_uri) {
            this.resource_uri = resource_uri;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setName_localized(String name_localized) {
            this.name_localized = name_localized;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public void setShort_name_localized(String short_name_localized) {
            this.short_name_localized = short_name_localized;
        }

        public String getResource_uri() {
            return resource_uri;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getName_localized() {
            return name_localized;
        }

        public String getShort_name() {
            return short_name;
        }

        public String getShort_name_localized() {
            return short_name_localized;
        }
    }
}
