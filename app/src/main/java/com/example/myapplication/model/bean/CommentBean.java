package com.example.myapplication.model.bean;

import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class CommentBean {
    /**
     * result : [{"address":"滨河路乙1号雍和航星园74-76号楼","cinemaId":1,"cinemaName":"青春光线电影院","commentTime":1574211703000,"distance":12239585,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","myCommentContent":"这接口是不是有问题啊！！！"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * address : 滨河路乙1号雍和航星园74-76号楼
         * cinemaId : 1
         * cinemaName : 青春光线电影院
         * commentTime : 1574211703000
         * distance : 12239585
         * logo : http://172.17.8.100/images/movie/logo/qcgx.jpg
         * myCommentContent : 这接口是不是有问题啊！！！
         */

        private String address;
        private int cinemaId;
        private String cinemaName;
        private long commentTime;
        private int distance;
        private String logo;
        private String myCommentContent;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }


    }
}