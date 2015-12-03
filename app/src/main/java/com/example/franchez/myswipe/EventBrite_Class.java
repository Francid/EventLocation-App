package com.example.franchez.myswipe;

import java.util.List;

/**
 * Created by Franchez on 2015-11-26.
 */
public class EventBrite_Class {

    /**
     * object_count : 35
     * page_number : 1
     * page_size : 50
     * page_count : 1
     */

    private PaginationEntity pagination;
    /**
     * latitude : 43.785810
     * within : 8
     * longitude : -79.227254
     */

    private LocationEntity location;
    /**
     * name : {"text":"ALDO A-List Scarborough Town Center","html":"ALDO A-List Scarborough Town Center"}
     * description : {"text":"WELCOME TO THE ALDO A-LIST  IT\u2019S TIME TO DISCOVER WHAT ALL THE FUSS IS ABOUT!  Get ready, you\u2019ve been invited to our most exclusive shopping party! We\u2019re stocking up on drinks, treats, discounts and gifts just for you. You and your most fashionable friends will not want to miss this! ","html":"<P>WELCOME TO THE ALDO A-LIST<BR> IT\u2019S TIME TO DISCOVER WHAT ALL THE FUSS IS ABOUT!<BR> Get ready, you\u2019ve been invited to our most exclusive shopping party! We\u2019re stocking up on drinks, treats, discounts and gifts just for you. You and your most fashionable friends will not want to miss this!<\/P>"}
     * id : 19386790412
     * url : http://www.eventbrite.ca/e/aldo-a-list-scarborough-town-center-tickets-19386790412?aff=ebapi
     * start : {"timezone":"America/New_York","local":"2015-12-05T10:00:00","utc":"2015-12-05T15:00:00Z"}
     * end : {"timezone":"America/New_York","local":"2015-12-05T12:00:00","utc":"2015-12-05T17:00:00Z"}
     * created : 2015-11-03T18:31:49Z
     * changed : 2015-11-03T21:07:50Z
     * capacity : 200
     * status : live
     * currency : USD
     * listed : true
     * shareable : true
     * online_event : false
     * tx_time_limit : 480
     * hide_start_date : false
     * locale : en_CA
     * is_locked : false
     * privacy_setting : unlocked
     * logo_id : null
     * organizer_id : 7048296107
     * venue_id : 11355301
     * category_id : null
     * subcategory_id : null
     * format_id : null
     * resource_uri : https://www.eventbriteapi.com/v3/events/19386790412/
     * logo : null
     */

    private List<EventsEntity> events;

    public void setPagination(PaginationEntity pagination) {
        this.pagination = pagination;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public void setEvents(List<EventsEntity> events) {
        this.events = events;
    }

    public PaginationEntity getPagination() {
        return pagination;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public List<EventsEntity> getEvents() {
        return events;
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

    public static class LocationEntity {
        private String latitude;
        private String within;
        private String longitude;

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public void setWithin(String within) {
            this.within = within;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public String getWithin() {
            return within;
        }

        public String getLongitude() {
            return longitude;
        }
    }

    public static class EventsEntity {
        /**
         * text : ALDO A-List Scarborough Town Center
         * html : ALDO A-List Scarborough Town Center
         */

        private NameEntity name;
        /**
         * text : WELCOME TO THE ALDO A-LIST  IT’S TIME TO DISCOVER WHAT ALL THE FUSS IS ABOUT!  Get ready, you’ve been invited to our most exclusive shopping party! We’re stocking up on drinks, treats, discounts and gifts just for you. You and your most fashionable friends will not want to miss this!
         * html : <P>WELCOME TO THE ALDO A-LIST<BR> IT’S TIME TO DISCOVER WHAT ALL THE FUSS IS ABOUT!<BR> Get ready, you’ve been invited to our most exclusive shopping party! We’re stocking up on drinks, treats, discounts and gifts just for you. You and your most fashionable friends will not want to miss this!</P>
         */

        private DescriptionEntity description;
        private String id;
        private String url;
        /**
         * timezone : America/New_York
         * local : 2015-12-05T10:00:00
         * utc : 2015-12-05T15:00:00Z
         */

        private StartEntity start;
        /**
         * timezone : America/New_York
         * local : 2015-12-05T12:00:00
         * utc : 2015-12-05T17:00:00Z
         */

        private EndEntity end;
        private String created;
        private String changed;
        private int capacity;
        private String status;
        private String currency;
        private boolean listed;
        private boolean shareable;
        private boolean online_event;
        private int tx_time_limit;
        private boolean hide_start_date;
        private String locale;
        private boolean is_locked;
        private String privacy_setting;
        private Object logo_id;
        private String organizer_id;
        private String venue_id;
        private Object category_id;
        private Object subcategory_id;
        private Object format_id;
        private String resource_uri;
        private Object logo;

        public void setName(NameEntity name) {
            this.name = name;
        }

        public void setDescription(DescriptionEntity description) {
            this.description = description;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setStart(StartEntity start) {
            this.start = start;
        }

        public void setEnd(EndEntity end) {
            this.end = end;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public void setChanged(String changed) {
            this.changed = changed;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setListed(boolean listed) {
            this.listed = listed;
        }

        public void setShareable(boolean shareable) {
            this.shareable = shareable;
        }

        public void setOnline_event(boolean online_event) {
            this.online_event = online_event;
        }

        public void setTx_time_limit(int tx_time_limit) {
            this.tx_time_limit = tx_time_limit;
        }

        public void setHide_start_date(boolean hide_start_date) {
            this.hide_start_date = hide_start_date;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public void setIs_locked(boolean is_locked) {
            this.is_locked = is_locked;
        }

        public void setPrivacy_setting(String privacy_setting) {
            this.privacy_setting = privacy_setting;
        }

        public void setLogo_id(Object logo_id) {
            this.logo_id = logo_id;
        }

        public void setOrganizer_id(String organizer_id) {
            this.organizer_id = organizer_id;
        }

        public void setVenue_id(String venue_id) {
            this.venue_id = venue_id;
        }

        public void setCategory_id(Object category_id) {
            this.category_id = category_id;
        }

        public void setSubcategory_id(Object subcategory_id) {
            this.subcategory_id = subcategory_id;
        }

        public void setFormat_id(Object format_id) {
            this.format_id = format_id;
        }

        public void setResource_uri(String resource_uri) {
            this.resource_uri = resource_uri;
        }

        public void setLogo(Object logo) {
            this.logo = logo;
        }

        public NameEntity getName() {
            return name;
        }

        public DescriptionEntity getDescription() {
            return description;
        }

        public String getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public StartEntity getStart() {
            return start;
        }

        public EndEntity getEnd() {
            return end;
        }

        public String getCreated() {
            return created;
        }

        public String getChanged() {
            return changed;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getStatus() {
            return status;
        }

        public String getCurrency() {
            return currency;
        }

        public boolean isListed() {
            return listed;
        }

        public boolean isShareable() {
            return shareable;
        }

        public boolean isOnline_event() {
            return online_event;
        }

        public int getTx_time_limit() {
            return tx_time_limit;
        }

        public boolean isHide_start_date() {
            return hide_start_date;
        }

        public String getLocale() {
            return locale;
        }

        public boolean isIs_locked() {
            return is_locked;
        }

        public String getPrivacy_setting() {
            return privacy_setting;
        }

        public Object getLogo_id() {
            return logo_id;
        }

        public String getOrganizer_id() {
            return organizer_id;
        }

        public String getVenue_id() {
            return venue_id;
        }

        public Object getCategory_id() {
            return category_id;
        }

        public Object getSubcategory_id() {
            return subcategory_id;
        }

        public Object getFormat_id() {
            return format_id;
        }

        public String getResource_uri() {
            return resource_uri;
        }

        public Object getLogo() {
            return logo;
        }

        public static class NameEntity {
            private String text;
            private String html;

            public void setText(String text) {
                this.text = text;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getText() {
                return text;
            }

            public String getHtml() {
                return html;
            }
        }

        public static class DescriptionEntity {
            private String text;
            private String html;

            public void setText(String text) {
                this.text = text;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getText() {
                return text;
            }

            public String getHtml() {
                return html;
            }
        }

        public static class StartEntity {
            private String timezone;
            private String local;
            private String utc;

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public void setLocal(String local) {
                this.local = local;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }

            public String getTimezone() {
                return timezone;
            }

            public String getLocal() {
                return local;
            }

            public String getUtc() {
                return utc;
            }
        }

        public static class EndEntity {
            private String timezone;
            private String local;
            private String utc;

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public void setLocal(String local) {
                this.local = local;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }

            public String getTimezone() {
                return timezone;
            }

            public String getLocal() {
                return local;
            }

            public String getUtc() {
                return utc;
            }
        }
    }
}
