package com.example.franchez.myswipe;

import java.util.List;

/**
 * Created by Franchez on 2015-12-14.
 */
public class GooglePLace_Details_Class {


    /**
     * address_components : [{"long_name":"Woburn","short_name":"Woburn","types":["neighborhood","political"]},{"long_name":"Scarborough","short_name":"Scarborough","types":["sublocality_level_1","sublocality","political"]},{"long_name":"Toronto","short_name":"Toronto","types":["locality","political"]},{"long_name":"Toronto Division","short_name":"Toronto Division","types":["administrative_area_level_2","political"]},{"long_name":"Ontario","short_name":"ON","types":["administrative_area_level_1","political"]},{"long_name":"Canada","short_name":"CA","types":["country","political"]}]
     * adr_address : Woburn, <span class="locality">Toronto</span>, <span class="region">ON</span>, <span class="country-name">Canada</span>
     * formatted_address : Woburn, Toronto, ON, Canada
     * geometry : {"location":{"lat":43.767528,"lng":-79.21772100000001},"viewport":{"northeast":{"lat":43.7882329,"lng":-79.19906619999999},"southwest":{"lat":43.7417704,"lng":-79.2550277}}}
     * icon : https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png
     * id : 9386032ef477ceacf362cc8c1dbb53c913bf0347
     * name : Woburn
     * place_id : ChIJA8k0WVzQ1IkRCtrcDBx3a6Y
     * reference : CoQBeAAAAMF77na4DxQFN3FSeZ3RcwfuoNJueBTa45NyFhESBBeDzkyaXYqP0RCD_BELd6ByPHzdTO3Tmp4oBmh5IB7uVnZDMy96y49DcBZad8sF6ak5jcgbAsBL04qdP5Mv9GMoe5gl2M9y2WnU1eESw82BbnHkJCsY7C-_cKEpZrqdXyOtEhCkpWM5ZsnBMp8wPTWQfkJkGhReCnS-qZiyv8-QYFm5E8_ruX3UgQ
     * scope : GOOGLE
     * types : ["neighborhood","political"]
     * url : https://maps.google.com/?q=Woburn,+Toronto,+ON,+Canada&ftid=0x89d4d05c5934c903:0xa66b771c0cdcda0a
     * vicinity : Scarborough
     */

    private ResultEntity result;
    /**
     * html_attributions : []
     * result : {"address_components":[{"long_name":"Woburn","short_name":"Woburn","types":["neighborhood","political"]},{"long_name":"Scarborough","short_name":"Scarborough","types":["sublocality_level_1","sublocality","political"]},{"long_name":"Toronto","short_name":"Toronto","types":["locality","political"]},{"long_name":"Toronto Division","short_name":"Toronto Division","types":["administrative_area_level_2","political"]},{"long_name":"Ontario","short_name":"ON","types":["administrative_area_level_1","political"]},{"long_name":"Canada","short_name":"CA","types":["country","political"]}],"adr_address":"Woburn, <span class=\"locality\">Toronto<\/span>, <span class=\"region\">ON<\/span>, <span class=\"country-name\">Canada<\/span>","formatted_address":"Woburn, Toronto, ON, Canada","geometry":{"location":{"lat":43.767528,"lng":-79.21772100000001},"viewport":{"northeast":{"lat":43.7882329,"lng":-79.19906619999999},"southwest":{"lat":43.7417704,"lng":-79.2550277}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png","id":"9386032ef477ceacf362cc8c1dbb53c913bf0347","name":"Woburn","place_id":"ChIJA8k0WVzQ1IkRCtrcDBx3a6Y","reference":"CoQBeAAAAMF77na4DxQFN3FSeZ3RcwfuoNJueBTa45NyFhESBBeDzkyaXYqP0RCD_BELd6ByPHzdTO3Tmp4oBmh5IB7uVnZDMy96y49DcBZad8sF6ak5jcgbAsBL04qdP5Mv9GMoe5gl2M9y2WnU1eESw82BbnHkJCsY7C-_cKEpZrqdXyOtEhCkpWM5ZsnBMp8wPTWQfkJkGhReCnS-qZiyv8-QYFm5E8_ruX3UgQ","scope":"GOOGLE","types":["neighborhood","political"],"url":"https://maps.google.com/?q=Woburn,+Toronto,+ON,+Canada&ftid=0x89d4d05c5934c903:0xa66b771c0cdcda0a","vicinity":"Scarborough"}
     * status : OK
     */

    private String status;
    private List<?> html_attributions;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHtml_attributions(List<?> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public List<?> getHtml_attributions() {
        return html_attributions;
    }

    public static class ResultEntity {
        private String adr_address;
        private String formatted_address;
        /**
         * location : {"lat":43.767528,"lng":-79.21772100000001}
         * viewport : {"northeast":{"lat":43.7882329,"lng":-79.19906619999999},"southwest":{"lat":43.7417704,"lng":-79.2550277}}
         */

        private GeometryEntity geometry;
        private String icon;
        private String id;
        private String name;
        private String place_id;
        private String reference;
        private String scope;
        private String url;
        private String vicinity;
        /**
         * long_name : Woburn
         * short_name : Woburn
         * types : ["neighborhood","political"]
         */

        private List<AddressComponentsEntity> address_components;
        private List<String> types;

        public void setAdr_address(String adr_address) {
            this.adr_address = adr_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public void setGeometry(GeometryEntity geometry) {
            this.geometry = geometry;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public void setAddress_components(List<AddressComponentsEntity> address_components) {
            this.address_components = address_components;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public String getAdr_address() {
            return adr_address;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public GeometryEntity getGeometry() {
            return geometry;
        }

        public String getIcon() {
            return icon;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPlace_id() {
            return place_id;
        }

        public String getReference() {
            return reference;
        }

        public String getScope() {
            return scope;
        }

        public String getUrl() {
            return url;
        }

        public String getVicinity() {
            return vicinity;
        }

        public List<AddressComponentsEntity> getAddress_components() {
            return address_components;
        }

        public List<String> getTypes() {
            return types;
        }

        public static class GeometryEntity {
            /**
             * lat : 43.767528
             * lng : -79.21772100000001
             */

            private LocationEntity location;
            /**
             * northeast : {"lat":43.7882329,"lng":-79.19906619999999}
             * southwest : {"lat":43.7417704,"lng":-79.2550277}
             */

            private ViewportEntity viewport;

            public void setLocation(LocationEntity location) {
                this.location = location;
            }

            public void setViewport(ViewportEntity viewport) {
                this.viewport = viewport;
            }

            public LocationEntity getLocation() {
                return location;
            }

            public ViewportEntity getViewport() {
                return viewport;
            }

            public static class LocationEntity {
                private double lat;
                private double lng;

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }

                public double getLat() {
                    return lat;
                }

                public double getLng() {
                    return lng;
                }
            }

            public static class ViewportEntity {
                /**
                 * lat : 43.7882329
                 * lng : -79.19906619999999
                 */

                private NortheastEntity northeast;
                /**
                 * lat : 43.7417704
                 * lng : -79.2550277
                 */

                private SouthwestEntity southwest;

                public void setNortheast(NortheastEntity northeast) {
                    this.northeast = northeast;
                }

                public void setSouthwest(SouthwestEntity southwest) {
                    this.southwest = southwest;
                }

                public NortheastEntity getNortheast() {
                    return northeast;
                }

                public SouthwestEntity getSouthwest() {
                    return southwest;
                }

                public static class NortheastEntity {
                    private double lat;
                    private double lng;

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }

                    public double getLat() {
                        return lat;
                    }

                    public double getLng() {
                        return lng;
                    }
                }

                public static class SouthwestEntity {
                    private double lat;
                    private double lng;

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }

                    public double getLat() {
                        return lat;
                    }

                    public double getLng() {
                        return lng;
                    }
                }
            }
        }

        public static class AddressComponentsEntity {
            private String long_name;
            private String short_name;
            private List<String> types;

            public void setLong_name(String long_name) {
                this.long_name = long_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public void setTypes(List<String> types) {
                this.types = types;
            }

            public String getLong_name() {
                return long_name;
            }

            public String getShort_name() {
                return short_name;
            }

            public List<String> getTypes() {
                return types;
            }
        }
    }
}
