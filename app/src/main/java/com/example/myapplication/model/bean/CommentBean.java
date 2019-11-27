package com.example.myapplication.model.bean;

import java.util.List;

public class CommentBean {

    /**
     * result : [{"commentContent":"很好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-13/20191113094842.png","commentId":2135,"commentTime":1573215297000,"commentUserId":13613,"commentUserName":"你妹","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"听闻谷天乐爱食屎","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-07/20190907140903.jpg","commentId":2122,"commentTime":1573002977000,"commentUserId":13472,"commentUserName":"红衣佳人白衣友","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.5},{"commentContent":"唉唉唉","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-13/20191113094254.jpg","commentId":2023,"commentTime":1572867848000,"commentUserId":13714,"commentUserName":"run","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.1},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-23/20191023184812.jpg","commentId":1918,"commentTime":1572860319000,"commentUserId":13708,"commentUserName":"郭转晨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"004","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-23/20190923191522.unknown","commentId":1425,"commentTime":1569379708000,"commentUserId":13643,"commentUserName":"������ҵ","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"�̼�","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":207,"commentTime":1569377417000,"commentUserId":13458,"commentUserName":"23","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"faa","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-28/20190828113844.png","commentId":17,"commentTime":1567472859000,"commentUserId":13526,"commentUserName":"哈哈h4343","greatNum":0,"isGreat":0,"replyHeadPic":["http://172.17.8.100/images/movie/head_pic/2019-09-25/20190925100559.jpg","http://172.17.8.100/images/movie/head_pic/2019-09-25/20190925100559.jpg"],"replyNum":2,"score":4.5}]
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
         * commentContent : 很好
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-11-13/20191113094842.png
         * commentId : 2135
         * commentTime : 1573215297000
         * commentUserId : 13613
         * commentUserName : 你妹
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<String> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<String> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<String> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
