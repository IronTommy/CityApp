package com.korsakov.cityapp.model;

import java.io.Serializable;
import java.util.List;

public class VKPostResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response implements Serializable {
        private static final long serialVersionUID = 1L;

        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public static class Item implements Serializable {
            private static final long serialVersionUID = 1L;

            private String text;
            private long date;
            private List<Attachment> attachments;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public List<Attachment> getAttachments() {
                return attachments;
            }

            public void setAttachments(List<Attachment> attachments) {
                this.attachments = attachments;
            }

            public static class Attachment implements Serializable {
                private static final long serialVersionUID = 1L;

                private String type;
                private Photo photo;
                private Video video;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Photo getPhoto() {
                    return photo;
                }

                public void setPhoto(Photo photo) {
                    this.photo = photo;
                }

                public Video getVideo() {
                    return video;
                }

                public void setVideo(Video video) {
                    this.video = video;
                }

                public static class Photo implements Serializable {
                    private static final long serialVersionUID = 1L;

                    private List<Size> sizes;

                    public List<Size> getSizes() {
                        return sizes;
                    }

                    public void setSizes(List<Size> sizes) {
                        this.sizes = sizes;
                    }

                    public static class Size implements Serializable {
                        private static final long serialVersionUID = 1L;

                        private int width;
                        private String url;

                        public int getWidth() {
                            return width;
                        }

                        public void setWidth(int width) {
                            this.width = width;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class Video implements Serializable {
                    private static final long serialVersionUID = 1L;

                    private String id;
                    private String owner_id;
                    private Files files;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getOwner_id() {
                        return owner_id;
                    }

                    public void setOwner_id(String owner_id) {
                        this.owner_id = owner_id;
                    }

                    public Files getFiles() {
                        return files;
                    }

                    public void setFiles(Files files) {
                        this.files = files;
                    }

                    public static class Files implements Serializable {
                        private static final long serialVersionUID = 1L;

                        private String external;

                        public String getExternal() {
                            return external;
                        }

                        public void setExternal(String external) {
                            this.external = external;
                        }
                    }
                }
            }
        }
    }
}
